package ratelimitter.models;

public class RateLimit {
    private TimeEnum time;
    private int maxRequest;

    public RateLimit(TimeEnum time, int maxRequest) {
        this.time = time;
        this.maxRequest = maxRequest;
    }

    public TimeEnum getTime() {
        return time;
    }

    public void setTime(TimeEnum time) {
        this.time = time;
    }

    public int getMaxRequest() {
        return maxRequest;
    }

    public void setMaxRequest(int maxRequest) {
        this.maxRequest = maxRequest;
    }
}
