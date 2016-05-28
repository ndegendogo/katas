package de.kifaru.ndegendogo.kata.romanNumbers;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserInterface extends JPanel {

    private static final long serialVersionUID = 1L;

    private RomanNumbersConverter converter;

    private JLabel romanLabel;
    private JTextField romanNumber;
    private JLabel arabicLabel;
    private JLabel arabicNumber;

    static void createAndShowGui(final RomanNumbersConverter converter) {
        // top-level container
        final JFrame frame = new JFrame("Roman Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new UserInterface(converter));
        frame.pack();
        frame.setVisible(true);
    }

    private UserInterface(final RomanNumbersConverter converter) {
        this.converter = converter;
        romanLabel = new JLabel("Roman:");
        romanNumber = new JTextField(20);
        romanNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showConvertedNumber();
            }
        });
        arabicLabel = new JLabel("Arabic:");
        arabicNumber = new JLabel("");

        final JComponent components[][] = {{romanLabel, romanNumber}, {arabicLabel, arabicNumber}};
        setupLayout(this, components);
    }

    private void showConvertedNumber() {
        final Integer convertedNumber = converter.convertToArabicNumber(romanNumber.getText());
        final String convertedString = (convertedNumber <= 0 ? "Illegal Input" : convertedNumber.toString());
        arabicNumber.setText(convertedString);
        romanNumber.selectAll();
    }

    private static void setupLayout(final JPanel pane, final JComponent[][] components) {
        GridBagLayout layout = new GridBagLayout();
        pane.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets (5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.BASELINE_LEADING;
        for (JComponent[] line : components) {
            for (int i = 0; i < line.length; i ++) {
                JComponent element = line[i];
                constraints.gridwidth = (i == line.length -1 ? GridBagConstraints.REMAINDER : 1);
                layout.setConstraints(element, constraints);
                pane.add(element);
            }
        }
    }
}
