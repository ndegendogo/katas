package de.kifaru.ndegendogo.kata.fakeOs;

public class FileCommand {

    protected boolean hasError = false;

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
