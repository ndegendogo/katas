package de.kifaru.ndegendogo.kata.fakeOs;

public interface FileCommand {

    public void processDefault();
    public void processSingleFile(final String filename);
}
