package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

import javax.swing.SwingUtilities;

public class ConvertRomanMain {

    public static void main(String ... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ConvertRomanGUI.createAndShowGui();
            }
        });
    }

    static Integer convertRomanToArabicNumber(String romanNumber) {
        // TODO: implement conversion
        return 0;
    }

    final static Function<String, Integer> converter = new Function<String, Integer>() {
        public Integer apply(String string) {
            return convertRomanToArabicNumber(string);
        }
    };

}
