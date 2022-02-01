package ratelimitter;

import ratelimitter.models.*;

import java.util.Arrays;
import java.util.List;

public class RateLimiter {

    public static void main(String[] args) throws InterruptedException {
        RateLimitExecutor rateLimitExecutor = new RateLimitExecutor(generateClientConfig());
        RequestMeta apiRequestMeta=new RequestMeta(RequestConstants.CLIENT, RequestConstants.METHOD_GET,RequestConstants.API_GET_DATA);
        RequestMeta apiRequestMeta1=new RequestMeta(RequestConstants.CLIENT+1,RequestConstants.METHOD_GET,RequestConstants.API_GET_DUMMY);

        while (true) {
            Thread.sleep(1000);
            System.out.println(apiRequestMeta.toString() +":" +rateLimitExecutor.allowed(apiRequestMeta));
//            System.out.println(apiRequestMeta1.toString() +":" +rateLimitExecutor.allowed(apiRequestMeta1));
        }

    }

    private static List<ClientLimitConfig> generateClientConfig() {
        ClientLimitConfig clientLimitConfig = new ClientLimitConfig(RequestConstants.CLIENT);
        clientLimitConfig.setLimit(Arrays.asList(
                new RateLimit(TimeEnum.SECOND, 1),
                new RateLimit(TimeEnum.Minute, 3)
        ));

        clientLimitConfig.getApiRateLimit().put(RequestConstants.API_GET_DATA, Arrays.asList(
                new RateLimit(TimeEnum.SECOND, 1),
                new RateLimit(TimeEnum.Minute, 3)
        ));

        clientLimitConfig.getApiRateLimit().put(RequestConstants.API_GET_DUMMY, Arrays.asList(
                new RateLimit(TimeEnum.SECOND, 1),
                new RateLimit(TimeEnum.Minute, 1)
        ));

        clientLimitConfig.getMethodRateLimit().put(RequestConstants.METHOD_GET, Arrays.asList(
                new RateLimit(TimeEnum.SECOND, 1),
                new RateLimit(TimeEnum.Minute, 3)
        ) );
        return Arrays.asList(clientLimitConfig);
    }
}
