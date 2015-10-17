package de.kifaru.ndegendogo.kata.fakeOs;

public interface FileCommand {

    public boolean isDefaultInput(final String name);
    public void processDefault();
    public void processSingleFile(final String filename);
    public void handleError();
}
