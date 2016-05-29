package de.kifaru.ndegendogo.kata.romanNumbers;

import javax.swing.SwingUtilities;

public class RomanConverterMain {

    public static void main(String ... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RomanConverterGui.createAndLaunch(new RomanNumbersConverter());
            }
        });
    }

}
