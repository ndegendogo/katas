import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;

public class Head extends MultiFileCommand {
    private static final int MAX_LINES = 10;
    private static boolean hasToPrintFilenames;
    public Head() {
        super();
    }
    public Head(final InputStream stdin, final PrintStream stdout) {
        super(stdin, stdout);
    }
    public static void main(final String... args) throws IOException {
        new Head().run(args);
    }
    protected void process(final InputStream in) throws IOException {
        try (final BufferedReader bin = new BufferedReader(new InputStreamReader(in))) {
            String line;
            for (int i = 0; i < MAX_LINES && (line = bin.readLine()) != null; i++)
                out.println(line);
        }
    }
    protected void beforeRun(final String... args) {
        hasToPrintFilenames = args.length > 1;
    }
    protected void beforeProcess(final String filename) {
        if (hasToPrintFilenames)
            out.format("==> %s <==%n", getFilenameForUser(filename));
    }
    private String getFilenameForUser(final String filename) {
        return isStdStream(filename) ? "standard input" : filename;
    }
}
