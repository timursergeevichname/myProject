package wtomod.base;

public enum Time {

    SECONDS(1),
    MINUTES(60),
    HOUR(3600);

    private final int seconds;

    Time(int seconds){

        this.seconds = seconds;

    }

    public int getSeconds() {
        return seconds;
    }
}
