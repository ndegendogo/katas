package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class TailCollector extends ArrayBlockingQueue<String> implements HeadTailCollector {

    private static final long serialVersionUID = 1L;

    public TailCollector(int capacity) {
        super(capacity);
    }

    @Override
    public Iterator<String> iterator() {
        return super.iterator();
    }

    @Override
    public boolean addTillFull(String line) {
        if (remainingCapacity() == 0) {
            remove();
        }
        add(line);
        return true;
    }

}
