package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.InputStream;

public class FileCommand {

    protected boolean hasError = false;

    protected void process(final String... filenames) {
        if (filenames.length == 0) {
            processDefault();
        } else {
            processAll(filenames);
        }
        handleError();
    }

    void processDefault() {
    }

    protected void processAll(final String... filenames) {
    }

    protected void processSingle(final String name) {
    }
    
    void processSingleFile(final String filename)  {
    }
    
    void doIt(final InputStream source) {
    }
    
    protected boolean setError() {
        return hasError = true;
    }

    boolean hasError() {
        return (hasError);
    }

    protected void handleError() {
        if (hasError()) {
            System.exit(1);
        }
    }
}
