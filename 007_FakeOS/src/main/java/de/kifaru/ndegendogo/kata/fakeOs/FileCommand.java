package de.kifaru.ndegendogo.kata.fakeOs;

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

    void processDefault() {
        process(defaultInput);
    }

    protected void processMulti(final String... filenames) {
    }

    protected void processSingle(final String name) {
    }
    
    void processSingleFile(final String filename)  {
    }
    
    void process(final DataSource source) {
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
