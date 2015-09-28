package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.InputStream;

public class DataSourceForBytes extends DataSource {
    private final InputStream input;

    DataSourceForBytes(final InputStream input) {
        this.input = input;
    }
    
    InputStream getInput() {
        return input;
    }
}
