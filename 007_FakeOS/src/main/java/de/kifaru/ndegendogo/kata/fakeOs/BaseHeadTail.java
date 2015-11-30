package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;

public abstract class BaseHeadTail extends FileCommand {
    private static final int MAX_NUMBER_OF_LINES = 10;
    private final boolean withTitle;
    private final OutputJoiner output;

    BaseHeadTail(final boolean withTitle, final PrintStream output) {
        this.withTitle = withTitle;
        this.output = new OutputJoiner(output);
    }

    protected void printLines(final BufferedReader bufferedReader) {
        try {
            final Iterable<String> collectedLines = readAndCollectLines(bufferedReader);
            printTitle();
            output.print(collectedLines);
        } catch (IOException e) {
            setError();
        }
    }

    private void printTitle() {
        if (withTitle) {
            output.print(buildTitle(currentFilename));
        }
    }

    protected String buildTitle(final String name) {
        return "==> " + name + " <==";
    }

    protected Iterable<String> readAndCollectLines(final BufferedReader reader) throws IOException {
        final ArrayBlockingQueue<String> collector = new ArrayBlockingQueue<>(MAX_NUMBER_OF_LINES);
        String line;
        while ((line = reader.readLine()) != null && collectLine(collector, line));
        return collector;
    }

    abstract protected boolean collectLine(final ArrayBlockingQueue<String> collector, final String line);

    @Override
    protected boolean hasError() {
        return (super.hasError() || output.checkError());
    }

}
