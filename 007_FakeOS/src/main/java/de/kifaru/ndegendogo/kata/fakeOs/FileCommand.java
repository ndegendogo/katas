package de.kifaru.ndegendogo.kata.fakeOs;

public abstract class FileCommand {

    abstract protected void processAll(final String... filenames);

    abstract protected void processDefault();

    abstract protected void processMulti(final String... filenames);
    
    abstract protected void processSingle(final String name);
    
    abstract protected boolean isDefaultInput(final String name);
    
    abstract protected void processSingleFile(final String filename);

}
