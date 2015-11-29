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
        final Iterable<String> filteredLines = readAndFilterLines(bufferedReader);
        printTitle();
        output.print(filteredLines);
    }

    private void printTitle() {
        if (withTitle) {
            output.print(buildTitle(currentFilename));
        }
    }

    protected String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

    protected Iterable<String> readAndFilterLines(final BufferedReader buffered) {
        final ArrayBlockingQueue<String> lines = new ArrayBlockingQueue<>(MAX_NUMBER_OF_LINES);
        try {
            getFilteredLines(lines, buffered);
        } catch (IOException e) {
            setError();
        }
        return lines;
    }

    protected void getFilteredLines(final ArrayBlockingQueue<String> queue, final BufferedReader buffered) throws IOException {
        String line;
        while ((line = buffered.readLine()) != null && bufferLineWhileCapacity(line, queue));
    }

    abstract protected boolean bufferLineWhileCapacity(final String line, final ArrayBlockingQueue<String> queue);

    @Override
    protected boolean hasError() {
        return (super.hasError() || output.checkError());
    }

}
