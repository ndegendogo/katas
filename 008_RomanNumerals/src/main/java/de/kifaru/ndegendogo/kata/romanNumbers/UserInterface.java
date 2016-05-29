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

public class UserInterface {

    private final RomanNumbersConverter converter;
    private final JTextField romanNumber;
    private final JLabel arabicNumber;

    static UserInterface createAndShowGui(final RomanNumbersConverter converter) {
        return new UserInterface(converter);
    }

    private UserInterface(final RomanNumbersConverter converter) {
        this.converter = converter;
        final JLabel romanLabel = new JLabel("Roman:");
        romanNumber = new JTextField(20);
        romanNumber.addActionListener( this::showConvertedNumber);
        final JLabel arabicLabel = new JLabel("Arabic:");
        arabicNumber = new JLabel("");
        final Component components[][] = {{romanLabel, romanNumber}, {arabicLabel, arabicNumber}};
        makeFrameForComponents(components);
    }

    private void showConvertedNumber(final ActionEvent dummy) {
        final Integer convertedNumber = converter.convertToArabicNumber(romanNumber.getText());
        final String convertedString = (convertedNumber <= 0 ? "Illegal Input" : convertedNumber.toString());
        arabicNumber.setText(convertedString);
        romanNumber.selectAll();
    }

    private static void makeFrameForComponents(final Component[][] components) {
        final Container container = createGui(components);

        showGui(container);
    }

    private static Container createGui(final Component[][] components) {
        final Container container = new JPanel();
        layoutComponents(components, container);
        return container;
    }

    private static void showGui(final Container container) {
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
