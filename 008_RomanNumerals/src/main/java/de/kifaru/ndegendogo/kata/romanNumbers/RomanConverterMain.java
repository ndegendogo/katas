package de.kifaru.ndegendogo.kata.romanNumbers;

import javax.swing.SwingUtilities;

public class RomanConverterMain {
    public static void main(final String ... args) {
        SwingUtilities.invokeLater(() -> 
        {
            constructAndLaunchGui();
        });
    }

    private static void constructAndLaunchGui() {
        final RomanConverterGui gui = new RomanConverterGui(new RomanNumbersConverter());
        gui.launch();
    }
}
