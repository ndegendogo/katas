package de.kifaru.ndegendogo.kata.fakeOs;

public class BaseHeadTail extends FileCommand {

    protected String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

}
