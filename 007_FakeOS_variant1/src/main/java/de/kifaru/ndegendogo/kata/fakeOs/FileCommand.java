package de.kifaru.ndegendogo.kata.fakeOs;

public abstract class FileCommand {

    abstract protected void processDefault();
    abstract protected void processSingleFile(final String filename);

    private boolean hasError = false;

    protected boolean setError() {
        return hasError = true;
    }

    protected boolean hasError() {
        return (hasError);
    }

    protected void handleError() {
        if (hasError()) {
            System.exit(1);
        }
    }
}
