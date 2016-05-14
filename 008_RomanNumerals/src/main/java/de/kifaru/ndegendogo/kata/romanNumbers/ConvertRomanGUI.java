package de.kifaru.ndegendogo.kata.romanNumbers;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;

public class ConvertRomanGUI extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel roman;
    private JTextField inputField;
    private JLabel arabic;
    private JLabel outputField;

    ConvertRomanGUI() {
        roman = new JLabel("Roman:");
        makeInputField();
        arabic = new JLabel("Arabic:");
        outputField = new JLabel("");

        final JComponent components[][] = {{roman, inputField}, {arabic, outputField}};
        setupLayout(this, components);
    }

    static void createAndShowGui() {
        // top-level container
        final JFrame frame = new JFrame("Roman Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new ConvertRomanGUI());
        frame.pack();
        frame.setVisible(true);
    }

    private void makeInputField() {
        inputField = new JTextField(20);
        final ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final String input = inputField.getText();
                final String output = convertRomanToArabicNumber(input);
                outputField.setText(output);
                inputField.selectAll();
            }
        };
        inputField.addActionListener(listener);
    }

    private String convertRomanToArabicNumber(String romanNumber) {
        // TODO: implement conversion
        return romanNumber;
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
