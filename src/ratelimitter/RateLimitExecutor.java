package ratelimitter;

import ratelimitter.models.*;

import java.util.*;

public class RateLimitExecutor {


    private Map<String, ClientLimitConfig> clientConfigMap;
                //client    //time
    private Map<String, Map<String, SortedMap<Long, Integer>>> datStoreNew;


    public RateLimitExecutor(List<ClientLimitConfig> clientConfigs) {

        this.clientConfigMap = new HashMap<>();
        this.datStoreNew = new HashMap<>();
        for (ClientLimitConfig clientLimitConfig : clientConfigs) {
            this.clientConfigMap.put(clientLimitConfig.getName(), clientLimitConfig);
        }
        new Thread(() -> {
            try {
                dataStoreGC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }



    boolean allowed(RequestMeta apiMeta) {
        // userID can be apikey, location, ip

        ClientLimitConfig clientConfig = clientConfigMap.get(apiMeta.getClient());

        //[clientcheck -->git, methodcheck --> get]
        if (Objects.isNull(clientConfig)) {
            return RequestConstants.NON_EXIST_CONFIG_ALLOW;
        }
        if (!isAllowed(apiMeta.getClient(), clientConfig.getLimit())) {
            return false;
        }

        List<RateLimit> apiLimitConfig = clientConfig.getApiRateLimit().get(apiMeta.getApi());
        if (Objects.isNull(apiLimitConfig) || apiLimitConfig.isEmpty()) {
            return RequestConstants.NON_EXIST_CONFIG_ALLOW;
        }
        if (!isAllowed(String.format("%s,%s:%s", apiMeta.getClient(), RequestConstants.API_KEY, apiMeta.getApi()), apiLimitConfig)) {
            return false;
        }

        List<RateLimit> methodLimitConfig = clientConfig.getMethodRateLimit().get(apiMeta.getMethodType());
        if (Objects.isNull(methodLimitConfig) || methodLimitConfig.isEmpty()) {
            return RequestConstants.NON_EXIST_CONFIG_ALLOW;
        }
        if (!isAllowed(String.format("%s,%s:%s", apiMeta.getClient(), RequestConstants.METHOD_KEY, apiMeta.getMethodType()), methodLimitConfig)) {
            return false;
        }
        return true;
    }

    private boolean isAllowed(String clientId, List<RateLimit> limits) {
        for (RateLimit rateLimit : limits) {
            if (rateLimit.getTime().enable &&
                    !isAllowed(clientId, rateLimit.getTime(), rateLimit.getTime().intervalInMs, rateLimit.getMaxRequest())) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllowed(String clientId, TimeEnum timeType, int intervalInMs, int maxRequests) {
        long currentWindow = System.currentTimeMillis() / intervalInMs;
        Map<String, SortedMap<Long, Integer>> timeMap = this.datStoreNew.get(clientId);
        if (Objects.isNull(timeMap)) {
            timeMap = new HashMap<>();
            //put durationMap as sorted for hash operations
            this.datStoreNew.put(clientId, timeMap);
        }
        SortedMap<Long, Integer> durationMap = timeMap.get(timeType.toString());
        if (Objects.isNull(durationMap)) {
            durationMap =  Collections.synchronizedSortedMap(new TreeMap<>());
            timeMap.put(timeType.toString(),durationMap);
        }
        int requestCount = durationMap.getOrDefault(currentWindow, 0);
        if (requestCount >= maxRequests) {
            return false;
        }


        durationMap.put(currentWindow, requestCount + 1);
        return true;
    }

    private void dataStoreGC() throws InterruptedException {
        while (true) {
            Thread.sleep(10 * TimeEnum.SECOND.intervalInMs);
            TimeEnum allTimes[] = new TimeEnum[]{TimeEnum.DAY, TimeEnum.SECOND, TimeEnum.Minute, TimeEnum.HOUR,
                    TimeEnum.DAY, TimeEnum.WEEK, TimeEnum.MONTH};
            for (Map.Entry<String, Map<String, SortedMap<Long, Integer>>> clientEntry : datStoreNew.entrySet()) {
                timeMapGC(allTimes, clientEntry);
            }
        }
    }

    private void timeMapGC(TimeEnum[] allTimes, Map.Entry<String, Map<String, SortedMap<Long, Integer>>> clientEntry) {
        Map<String, SortedMap<Long, Integer>> timeTypeMap = clientEntry.getValue();
        for (TimeEnum time : allTimes) {
            durationMapGC(timeTypeMap, time);
        }
    }

    private void durationMapGC(Map<String, SortedMap<Long, Integer>> timeTypeMap, TimeEnum time) {
        long lastWindow = (System.currentTimeMillis() / time.intervalInMs) - 1;
        SortedMap<Long, Integer> durationMap = timeTypeMap.get(time.toString());
        if (!Objects.isNull(durationMap)) {
            while (!durationMap.isEmpty()) {
                long firstKey = durationMap.firstKey();
                if (firstKey <= lastWindow) {
                    durationMap.remove(firstKey);
                } else {
                    break;
                }
            }
        }
    }
}
