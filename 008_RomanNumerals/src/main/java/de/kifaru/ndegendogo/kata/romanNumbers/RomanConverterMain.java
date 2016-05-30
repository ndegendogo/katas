package de.kifaru.ndegendogo.kata.romanNumbers;

import static javax.swing.SwingUtilities.invokeLater;

public class RomanConverterMain {
    public static void main(final String ... args) {
        invokeLater(RomanConverterMain::constructAndLaunchGui);
    }

    private static void constructAndLaunchGui() {
        final RomanConverterGui gui = new RomanConverterGui(new RomanNumbersConverter());
        gui.launch();
    }
}
