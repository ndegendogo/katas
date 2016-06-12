package de.kifaru.ndegendogo.kata.romanNumbers;

import static java.awt.GridBagConstraints.*;
import static javax.swing.WindowConstants.*;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class RomanConverterGui {

    private final RomanNumbersConverter converter;
    private final JTextField romanNumber;
    private final JLabel arabicNumber;
    private final Container container;

    RomanConverterGui(final RomanNumbersConverter converter) {
        this.converter = converter;
        final JLabel romanLabel = new JLabel("Roman:");
        romanNumber = new JTextField(20);
        romanNumber.addActionListener( this::showConvertedNumber);
        final JLabel arabicLabel = new JLabel("Arabic:");
        arabicNumber = new JLabel("");
        container = new JPanel();
        final Component components[][] = {{romanLabel, romanNumber}, {arabicLabel, arabicNumber}};
        layoutComponents(components, container);
    }

    private void showConvertedNumber(final ActionEvent dummy) {
        String convertedString;
        try {
            final int convertedNumber = RomanNumbersConverter.convertToArabicNumber(romanNumber.getText());
            convertedString = String.valueOf(convertedNumber);
        } catch (RomanNumberFormatException e) {
            convertedString = "Illegal Input";
        }
        arabicNumber.setText(convertedString);
        romanNumber.selectAll();
    }

    void launch() {
        final JFrame frame = new JFrame("Roman Numbers");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(container);
        frame.pack();
        frame.setVisible(true);
    }

    private static void layoutComponents(final Component[][] components, final Container container) {
        GridBagLayout layout = new GridBagLayout();
        container.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets (5, 5, 5, 5);
        constraints.anchor = BASELINE_LEADING;
        for (Component[] line : components) {
            layoutLine(line, container, layout, constraints);
        }
    }

    private static void layoutLine(final Component[] components, final Container container, final GridBagLayout layout, final GridBagConstraints constraints) {
        for (int i = 0; i < components.length; i ++) {
            constraints.gridwidth = (i == components.length - 1 ? REMAINDER : 1);
            layout.setConstraints(container.add(components[i]), constraints);
        }
    }
}
