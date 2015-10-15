package de.kifaru.ndegendogo.kata.fakeOs;

public class FileCommand {

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
