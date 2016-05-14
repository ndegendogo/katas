package de.kifaru.ndegendogo.kata.romanNumbers;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;

public class ConvertRomanGUI extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel romanLabel;
    private JTextField romanNumber;
    private JLabel arabicLabel;
    private JLabel arabicNumber;

    private Function<String, Integer> converter;

    static void createAndShowGui(final Function<String, Integer> converter) {
        // top-level container
        final JFrame frame = new JFrame("Roman Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new ConvertRomanGUI(converter));
        frame.pack();
        frame.setVisible(true);
    }

    private ConvertRomanGUI(final Function<String, Integer> converter) {
        this.converter = converter;
        romanLabel = new JLabel("Roman:");
        romanNumber = makeInputField();
        arabicLabel = new JLabel("Arabic:");
        arabicNumber = new JLabel("");

        final JComponent components[][] = {{romanLabel, romanNumber}, {arabicLabel, arabicNumber}};
        setupLayout(this, components);
    }

    private JTextField makeInputField() {
        final JTextField textField = new JTextField(20);
        final ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final String inputString = textField.getText();
                final Integer convertedNumber = converter.apply(inputString);
                final String convertedString = (convertedNumber <= 0 ? "Illegal Input" : convertedNumber.toString());
                arabicNumber.setText(convertedString);
                textField.selectAll();
            }
        };
        textField.addActionListener(listener);
        return textField;
    }

    private static void setupLayout(final Container pane, final JComponent[][] components) {
        final GroupLayout layout = new GroupLayout(pane);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        pane.setLayout(layout);

        final SequentialGroup vgroup = layout.createSequentialGroup();
        vgroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(components[0][0]).addComponent(components[0][1]));
        vgroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(components[1][0]).addComponent(components[1][1]));
        layout.setVerticalGroup(vgroup);

        final SequentialGroup hgroup = layout.createSequentialGroup();
        hgroup.addGroup(layout.createParallelGroup().addComponent(components[0][0]).addComponent(components[1][0]));
        hgroup.addGroup(layout.createParallelGroup().addComponent(components[0][1]).addComponent(components[1][1]));
        layout.setHorizontalGroup(hgroup);
    }
}
