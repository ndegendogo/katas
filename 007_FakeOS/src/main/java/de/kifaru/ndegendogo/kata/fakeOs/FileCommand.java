package de.kifaru.ndegendogo.kata.fakeOs;

public abstract class FileCommand {

    private boolean hasError = false;

    abstract protected void processAll(final String... filenames);

    abstract protected void processDefault();

    abstract protected void processMulti(final String... filenames);
    
    abstract protected void processSingle(final String name);
    
    abstract protected boolean isDefaultInput(final String name);
    
    abstract protected void processSingleFile(final String filename);

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
