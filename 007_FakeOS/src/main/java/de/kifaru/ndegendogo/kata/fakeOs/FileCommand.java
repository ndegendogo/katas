package de.kifaru.ndegendogo.kata.fakeOs;

public class FileCommand {

    private boolean hasError = false;
    protected FileOperation fileOperation;
    
    protected void setFileOperation(final FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

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
