package de.kifaru.ndegendogo.kata.romanNumbers;

import static java.awt.GridBagConstraints.*;
import static javax.swing.WindowConstants.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class UserInterface {

    static void createAndShowGui(final RomanNumbersConverter converter) {
        final JLabel arabicLabel = new JLabel("Arabic:");
        final JLabel arabicNumber = new JLabel("");
        final JLabel romanLabel = new JLabel("Roman:");
        final JTextField romanNumber = new JTextField(20);
        romanNumber.addActionListener( (ActionEvent e) -> {
            final Integer convertedNumber = converter.convertToArabicNumber(romanNumber.getText());
            final String convertedString = (convertedNumber <= 0 ? "Illegal Input" : convertedNumber.toString());
            arabicNumber.setText(convertedString);
            romanNumber.selectAll();
        });

        final JComponent components[][] = {{romanLabel, romanNumber}, {arabicLabel, arabicNumber}};
        final JPanel panel = new JPanel();
        setupLayout(panel, components);

        final JFrame frame = new JFrame("Roman Numbers");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void setupLayout(final JPanel panel, final JComponent[][] components) {
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets (5, 5, 5, 5);
        constraints.anchor = BASELINE_LEADING;
        for (JComponent[] line : components) {
            for (int i = 0; i < line.length; i ++) {
                JComponent element = line[i];
                constraints.gridwidth = (i == line.length - 1 ? REMAINDER : 1);
                layout.setConstraints(element, constraints);
                panel.add(element);
            }
        }
    }
}
