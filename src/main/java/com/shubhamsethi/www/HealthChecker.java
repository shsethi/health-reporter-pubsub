package com.shubhamsethi.www;

/**
 * Created by shsethi on 9/18/17.
 */
public class HealthChecker implements Runnable {

    private HealthQueue queue;

    public HealthChecker(HealthQueue queue) {
        this.queue = queue;
    }

    private boolean checkStatus() {
        boolean event = (int) (Math.random() * 10) % 2 == 0;
        System.out.println("Emitted " + event);
        return event;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Thread.sleep(1000);
                Event status = new Event(checkStatus());
                queue.publish(status);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }
}
