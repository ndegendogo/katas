package de.kifaru.ndegendogo.kata.romanNumbers;

import javax.swing.SwingUtilities;

public class RomanConverterMain {

    public static void main(String ... args) {
        final RomanConverterGui gui = new RomanConverterGui(new RomanNumbersConverter());
        SwingUtilities.invokeLater(gui::launch);
    }

}
