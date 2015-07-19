package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEcho {

    @Test
    public void singleArgument() {
        Echo.getResult("hello");
    }
}
