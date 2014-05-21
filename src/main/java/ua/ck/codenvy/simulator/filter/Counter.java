package ua.ck.codenvy.simulator.filter;

/**
 * Created by sergey on 20.04.14.
 */
public class Counter {
    private int count;

    public synchronized void inc() {
        count++;
    }

    public synchronized int get() {
        return count;
    }
}
