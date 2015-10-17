package de.kifaru.ndegendogo.kata.fakeOs;

public class FileCommandProcessor {

    final FileCommand command;

    FileCommandProcessor(FileCommand command) {
        this.command = command;
    }

    void processSingle(final String name) {
        if(command.isDefaultInput(name)) {
            command.processDefault();
        } else {
            command.processSingleFile(name);
        }
    }
}
