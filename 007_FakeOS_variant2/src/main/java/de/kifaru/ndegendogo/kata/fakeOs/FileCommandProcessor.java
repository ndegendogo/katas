package de.kifaru.ndegendogo.kata.fakeOs;

public class FileCommandProcessor {

    final FileCommand command;

    FileCommandProcessor(FileCommand command) {
        this.command = command;
    }

    protected void processSingle(Cat cat, final String name) {
        if(cat.isDefaultInput(name)) {
            cat.processDefault();
        } else {
            cat.processSingleFile(name);
        }
    }
}
