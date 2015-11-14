import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;

public abstract class MultiFileCommand {
    protected final PrintStream out;
    protected final InputStream in;
    protected MultiFileCommand() {
        this(System.in, System.out);
    }
    protected MultiFileCommand(final InputStream in, final PrintStream out) {
        this.in = in;
        this.out = out;
    }
    public void run(final String... args) throws IOException {
        beforeRun(args);
        if (args.length == 0)
            process(in);
        else
            process(args);
    }
    public void process(final String... filenames) throws IOException {
        IOException exception = null;
        for (final String filename : filenames) {
            try {
                process(filename);
            } catch (final IOException e) {
                System.err.format("%s: error while processing '%s': %s%n", getClass().getName(), filename, e.getMessage());
                if (exception == null)
                    exception = e;
                else
                    exception.addSuppressed(e);
            }
        }
        if (exception != null)
            throw exception;
    }
    public void process(final String filename) throws IOException {
        if (isStdStream(filename)) {
            beforeProcess(filename);
            process(in);
        } else
            processFile(filename);
    }
    private void processFile(final String filename) throws IOException {
        try (final InputStream in = new FileInputStream(filename)) {
            beforeProcess(filename);
            process(in);
            out.flush();
        }
    }
    protected abstract void process(final InputStream in) throws IOException;
    protected void beforeRun(final String... args) {}
    protected void beforeProcess(final String filename) {}
    protected static boolean isStdStream(final String filename) {
        return "-".equals(filename);
    }
}
