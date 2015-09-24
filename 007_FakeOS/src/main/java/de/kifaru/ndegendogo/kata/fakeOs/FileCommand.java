package de.kifaru.ndegendogo.kata.fakeOs;

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
