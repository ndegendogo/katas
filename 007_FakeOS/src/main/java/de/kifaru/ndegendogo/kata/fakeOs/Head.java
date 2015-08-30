package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System;

public class Head {

    public static void main(final String... args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffered = new BufferedReader(reader);
        String line = buffered.readLine();
        if (line != null) {
            System.out.println(line);
        }
    }

}
