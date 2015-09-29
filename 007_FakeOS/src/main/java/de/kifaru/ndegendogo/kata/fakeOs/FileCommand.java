package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Arrays;

public class FileCommand {

    protected boolean hasError = false;
    protected final DataSource defaultInput;
    
    FileCommand(DataSource defaultInput) {
        this.defaultInput = defaultInput;
    }
    
    protected void processAll(final String... filenames) {
        if (filenames.length == 0) {
            processDefault();
        } else {
            processMulti(filenames);
        }
        handleError();
    }

    protected void processDefault() {
        process(defaultInput);
    }

    protected void process(final DataSource source) {
    }
    
    protected void processMulti(final String... filenames) {
        Arrays.asList(filenames).stream()
            .forEach(name -> processSingle(name));
    }

    protected void processSingle(final String name) {
    }
    
    protected void processSingleFile(final String filename)  {
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
