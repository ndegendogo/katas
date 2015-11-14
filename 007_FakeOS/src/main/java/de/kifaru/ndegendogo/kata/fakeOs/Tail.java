package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Tail {

    public static void main(String... args) throws IOException {
        InputStream in = System.in;
        PrintStream out = System.out;
        try(InputStreamReader reader = new InputStreamReader(in);
            BufferedReader buffered = new BufferedReader(reader);
        ) {
            String line = buffered.readLine();
            if (line != null) {
                out.println(line);
                out.flush();
            }
        }
    }

}
