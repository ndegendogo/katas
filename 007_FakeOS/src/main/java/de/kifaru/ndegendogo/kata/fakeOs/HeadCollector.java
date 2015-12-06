package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class HeadCollector extends ArrayBlockingQueue<String> implements HeadTailCollector {

    private static final long serialVersionUID = 1L;

    public HeadCollector(int capacity) {
        super(capacity);
    }

    @Override
    public Iterator<String> iterator() {
        return super.iterator();
    }

    @Override
    public boolean addTillFull(String line) {
        add(line);
        return remainingCapacity() > 0;
    }

}
