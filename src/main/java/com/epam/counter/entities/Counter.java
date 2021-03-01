package com.epam.counter.entities;

public class Counter {
    private int count = 0;

    public synchronized void increase() {
        this.count++;
    }

    public synchronized int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Counter = " + this.count;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Counter counter = (Counter) object;
        return count == counter.count;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(count);
    }
}
