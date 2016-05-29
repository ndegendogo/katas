package de.kifaru.ndegendogo.kata.romanNumbers;

import javax.swing.SwingUtilities;

public class ConvertRomanMain {

    public static void main(String ... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                UserInterface ui = UserInterface.createAndShowGui(new RomanNumbersConverter());
                UserInterface.createAndShowGui(new RomanNumbersConverter());
            }
        });
    }

}
