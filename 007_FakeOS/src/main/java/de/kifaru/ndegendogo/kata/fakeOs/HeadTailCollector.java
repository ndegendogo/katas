package de.kifaru.ndegendogo.kata.fakeOs;

public interface HeadTailCollector extends Iterable<String> {

    boolean addTillFull(final String line);
}
