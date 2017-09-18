package com.shubhamsethi.www;

/**
 * Created by shsethi on 9/18/17.
 */
public class ConsoleReporterPubSub implements Reporters {
//    String reporter;

    public void report(Event event) {
        System.out.println("ConsoleReporterPubSub reported " + event);
    }
}
