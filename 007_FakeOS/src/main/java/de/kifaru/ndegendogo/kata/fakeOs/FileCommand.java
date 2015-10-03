package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Arrays;

public abstract class FileCommand {

    private boolean hasError = false;

    protected void processAll(final String... filenames) {
        if (filenames.length == 0) {
            processDefault();
        } else {
            processMulti(filenames);
        }
        handleError();
    }

    abstract protected void processDefault();

    protected void processMulti(final String... filenames) {
        Arrays.asList(filenames).stream()
            .forEach(name -> processSingle(name));
    }

    protected void processSingle(final String name) {
        if(isDefaultInput(name)) {
            processDefault();
        } else {
            processSingleFile(name);
        }
    }

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
