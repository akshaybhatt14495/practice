package ratelimitter.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientLimitConfig {
    private String name;
    private List<RateLimit> limit;
    private Map<String, List<RateLimit>> apiRateLimit;
    private Map<String, List<RateLimit>> methodRateLimit;


    public ClientLimitConfig(String name) {
        this.name = name;
        this.limit = new ArrayList<>();
        this.apiRateLimit = new HashMap<>();
        this.methodRateLimit = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RateLimit> getLimit() {
        return limit;
    }

    public void setLimit(List<RateLimit> limit) {
        this.limit = limit;
    }

    public Map<String, List<RateLimit>> getApiRateLimit() {
        return apiRateLimit;
    }

    public void setApiRateLimit(Map<String, List<RateLimit>> apiRateLimit) {
        this.apiRateLimit = apiRateLimit;
    }

    public Map<String, List<RateLimit>> getMethodRateLimit() {
        return methodRateLimit;
    }

    public void setMethodRateLimit(Map<String, List<RateLimit>> methodRateLimit) {
        this.methodRateLimit = methodRateLimit;
    }


}



/*
Exmaple:
//client test, get --> /get-data

// /v1/ratelimit
// post+/v1/ratelimit
// delete /v1/ratelimit


{
    "E-com":
        {
            Hour: {
                //60*60*1000

                12-1 time (millis): totalRequests

            },
        },

       "E-com-api-name":
       "E-com-method-name":
}

client:
	E-COM
      limit:
           HOUR -> 100
		   WEEK -> 900
           MONTH  -> 10000
      specialization:
          type: METHOD
                 - GET :
             limit:
                   SEC -> 10
                   MIN -> 50
                   WEEK -> 700
                - POST :
                     limit:
                           SEC -> 20
                           HOUR -> 40
                           WEEK -> 900
                           MONTH -> 1000

             type as api:
                /get-data
                    limit:
                    SEC -> 10
                    MIN -> 50
                    WEEK -> 700




 */