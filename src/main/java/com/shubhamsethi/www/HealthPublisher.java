package com.shubhamsethi.www;

/**
 * Created by shsethi on 9/18/17.
 */
public class HealthPublisher implements Runnable{

   private HealthQueue queue;

    public HealthPublisher(HealthQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Thread.sleep(1000);
                boolean event = (int) (Math.random() * 10) % 2 == 0;
                System.out.println("Emitted " + event);

                queue.publish(new Event(event));

            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }
}
