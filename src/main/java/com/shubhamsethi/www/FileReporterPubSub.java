package com.shubhamsethi.www;

/**
 * Created by shsethi on 9/18/17.
 */

interface Reporters {
    void report(Event event);
}

public class FileReporterPubSub implements Reporters {
//    String reporter;

    public void report(Event event) {
        System.out.println("FileReporting " + event);
    }
}

