import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Cat extends MultiFileCommand {
    public Cat() {
        super();
    }
    public Cat(final InputStream stdin, final PrintStream stdout) {
        super(stdin, stdout);
    }
    public static void main(final String... args) throws IOException {
        new Cat().run(args);
    }
    protected void process(final InputStream in) throws IOException {
        final byte[] buf = new byte[4096];
        for (int bytesRead; (bytesRead = in.read(buf)) != -1; )
            out.write(buf, 0, bytesRead);
    }
}
