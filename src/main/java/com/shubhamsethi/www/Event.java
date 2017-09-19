package com.shubhamsethi.www;

/**
 * Created by shsethi on 9/18/17.
 */
class Event {
    boolean value;

    public Event(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Status= "+value;
    }
}
