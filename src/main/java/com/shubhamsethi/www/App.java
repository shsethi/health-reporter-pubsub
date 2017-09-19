package com.shubhamsethi.www;

public class App
{
    public static void main (String [] args)
            throws Exception {

        HealthQueue healthQueue  = new HealthQueue();
        healthQueue.addReporter(new FileReporterPubSub());
        healthQueue.addReporter(new ConsoleReporterPubSub());
        Thread healthQThread = new Thread(healthQueue);


        HealthChecker healthChecker =  new HealthChecker(healthQueue);
        Thread checkerThread = new Thread(healthChecker);


        checkerThread.start();
        healthQThread.start();

    }
}

