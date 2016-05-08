package de.kifaru.ndegendogo.kata.romanNumbers;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;

public class ConvertNumber {

    public static void main(String ... args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    private static void createAndShowGui() {
        // top-level container
        final JFrame frame = new JFrame("Roman Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Container pane = frame.getContentPane();

        final JTextField input = new JTextField();
        final JLabel roman = new JLabel("Roman");
        final JLabel arabic = new JLabel("Arabic");

        final JButton button = new JButton("Convert");
        final ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: add action
            }
        };
        button.addActionListener(listener);
        final JComponent components[][] = {{input, roman}, {button, arabic}};

        setupLayout(pane, components);

        frame.pack();
        frame.setVisible(true);
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
