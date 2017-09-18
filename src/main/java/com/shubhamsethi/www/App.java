package com.shubhamsethi.www;

public class App
{
    public static void main (String [] args)
            throws Exception {

//        Queue eventQ = new ArrayBlockingQueue(100);
        HealthQueue h =  new HealthQueue();
        h.addReporter(new FileReporterPubSub());
        h.addReporter(new ConsoleReporterPubSub());

        HealthQueue healthQueue  = new HealthQueue();
        Thread healthQ = new Thread(h);

        HealthPublisher healthPublisher =  new HealthPublisher(healthQueue);
        Thread publisherThread = new Thread(healthPublisher);


        publisherThread.start();
        healthQ.start();

    }
}

