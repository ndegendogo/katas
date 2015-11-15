package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;


public class Tail extends FileCommand {
    private static final int MAX_NUMBER_OF_LINES = 10;
    protected final boolean withTitle;
    protected final PrintStream output;
    protected String currentFilename;

    Tail(final boolean withTitle, final InputStream in, final PrintStream output) {
        this.withTitle = withTitle;
        this.output = new OutputJoiner(output);
        setFileOperation(new TextFileOperation(in, this::printTrailingLines));
    }
    
    public static void main(final String... args) throws IOException {
        final FileCommand tail = (args.length >= 2) ? new TailWithTitle(System.in, System.out) : new Tail(false, System.in, System.out);
        tail.processAll(args);
    }

    @Override
    protected void processSingleFile(final String filename) {
        currentFilename = filename;
        super.processSingleFile(filename);
    }

    void printTrailingLines(final BufferedReader buffered) {
        final String result = readTrailingLines(buffered);
        output.print(result);
    }

    String readTrailingLines(final BufferedReader buffered) {
        final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(MAX_NUMBER_OF_LINES);
        String line;
        try {
            while ((line = buffered.readLine()) != null) {
                if (queue.remainingCapacity() == 0) {
                    queue.remove();
                }
                queue.add(new String(line));
            }
        } catch (IOException e) {
            setError();
        }
        final String result = String.join(System.lineSeparator(), queue);
        if (!result.isEmpty()) return result + System.lineSeparator();
        else return result;
    }

    @Override
    protected boolean hasError() {
        return (super.hasError() || output.checkError());
    }
}
