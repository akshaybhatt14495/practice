package ratelimitter.models;

public class RequestMeta {
    private String methodType;
    private String api;
    private String client;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RequestMeta{");
        sb.append("methodType='").append(methodType).append('\'');
        sb.append(", api='").append(api).append('\'');
        sb.append(", client='").append(client).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public RequestMeta(String client, String methodType, String api) {
        this.methodType = methodType;
        this.api = api;
        this.client = client;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}


