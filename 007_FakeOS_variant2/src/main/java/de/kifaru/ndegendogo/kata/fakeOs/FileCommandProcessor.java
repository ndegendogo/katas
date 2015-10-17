package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Arrays;

public class FileCommandProcessor {

    final FileCommand command;

    FileCommandProcessor(FileCommand command) {
        this.command = command;
    }

    void processAll(final String... filenames) {
        if (filenames.length > 0) {
            processMulti(filenames);
        } else {
            command.processDefault();
        }
        command.handleError();
    }

    void processMulti(final String... filenames) {
        Arrays.asList(filenames).stream()
            .forEach(name -> processSingle(name));
    }

    void processSingle(final String name) {
        if(command.isDefaultInput(name)) {
            command.processDefault();
        } else {
            command.processSingleFile(name);
        }
    }
}
