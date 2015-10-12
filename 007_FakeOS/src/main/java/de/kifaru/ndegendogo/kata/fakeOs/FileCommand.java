package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.IOException;
import java.util.Arrays;

public class FileCommand {

    private boolean hasError = false;
    protected FileOperation fileOperation;
    
    protected void setFileOperation(final FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    protected void processAll(final String... filenames) {
        if (filenames.length > 0) {
            processMulti(filenames);
        } else {
            processDefault();
        }
        handleError();
    }

    protected void processDefault() {
        fileOperation.processFromDefault();
    }

    protected void processMulti(final String... filenames) {
        Arrays.asList(filenames).stream()
            .forEach(name -> processSingle(name));
    }

    protected void processSingle(final String name) {
        processSingleFile(name);
    }

    protected void processSingleFile(final String filename) {
        try {
            fileOperation.processFromFile(filename);
        } catch (IOException e) {
            setError();
        }
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
