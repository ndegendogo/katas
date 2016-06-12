package de.kifaru.ndegendogo.kata.romanNumbers;

import static javax.swing.SwingUtilities.invokeLater;

public class RomanConverterMain {
    public static void main(final String ... args) {
        invokeLater(() -> constructAndLaunchGui());
    }

    private static void constructAndLaunchGui() {
        new RomanConverterGui().launch();
    }
}
