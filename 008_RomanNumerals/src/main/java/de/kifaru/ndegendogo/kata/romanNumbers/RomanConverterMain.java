package de.kifaru.ndegendogo.kata.romanNumbers;

import javax.swing.SwingUtilities;

public class RomanConverterMain {

    public static void main(String ... args) {
        final RomanNumbersConverter converter = new RomanNumbersConverter();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final RomanConverterGui ui = new RomanConverterGui(converter);
                ui.launch();
            }
        });
    }

}
