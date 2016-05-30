package de.kifaru.ndegendogo.kata.romanNumbers;

import javax.swing.SwingUtilities;

public class RomanConverterMain {
    public static void main(final String ... args) {
        SwingUtilities.invokeLater(() -> 
        {
            final RomanConverterGui gui = new RomanConverterGui(new RomanNumbersConverter());
            gui.launch();
        });
    }
}
