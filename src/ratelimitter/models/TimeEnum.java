package ratelimitter.models;


public enum TimeEnum {
    SECOND(Constants.second, false),
    Minute(Constants.minute, true),
    HOUR(Constants.hour, true),
    DAY(Constants.day, true),
    WEEK(Constants.week, true),
    MONTH(Constants.month, true);

    public final int intervalInMs;
    public final boolean enable;

    private TimeEnum(int intervalInMs, boolean enable) {
        this.intervalInMs = intervalInMs;
        this.enable = enable;
    }
}
