package wtomod.base;

import java.util.concurrent.TimeUnit;

public class ClockImpl implements Clock{

    private int seconds = 0;

    @Override
    public void setTime(Time time, int tact) {
        this.seconds = tact * time.getSeconds();
    }

    @Override
    public void start() {
        for (int i = seconds; i >= 0; i--) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Time to clock " + i + "seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
