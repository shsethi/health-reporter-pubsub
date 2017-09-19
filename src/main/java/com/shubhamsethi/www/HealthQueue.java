package com.shubhamsethi.www;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by shsethi on 9/18/17.
 */
public class HealthQueue implements Runnable {

    BlockingQueue<Event> eventQ;
    List<Reporters> reporters;

    public HealthQueue() {
        eventQ = new ArrayBlockingQueue<Event>(100);
        reporters = new ArrayList<Reporters>();
    }

    public void publish(Event e) {
        //TODO check
        eventQ.add(e);
    }

    public void addReporter(Reporters r) {
        reporters.add(r);
    }
    @Override
    public void run() {

        while (true) {
            Event event;
            try {
                event = eventQ.poll(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                continue;
            }
            catch (Exception e) {
                System.out.println("Unexpected ex"+e.getMessage());
                continue;
            }
            if(event != null) {
                for (Reporters r : reporters) {
                    r.report(event);
                }
            }
        }
    }
}
