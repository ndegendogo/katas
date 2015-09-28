package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;

public class DataSourceForStrings extends DataSource {
    private final BufferedReader input;
    
    DataSourceForStrings(final BufferedReader input) {
        this.input = input;
    }

    BufferedReader getInput() {
        return input;
    }
}
