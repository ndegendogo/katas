package de.kifaru.ndegendogo.kata.romanNumbers;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;

public class ConvertNumberGUI {

    private static JPanel pane;
    private static JLabel roman;
    private static JTextField inputField;
    private static JLabel arabic;
    private static JLabel outputField;
    private static JButton button;

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

        final JPanel pane = makePanel();

        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
    }

    static JPanel makePanel() {
        pane = new JPanel();

        roman = new JLabel("Roman:");
        inputField = new JTextField(20);
        arabic = new JLabel("Arabic:");
        outputField = new JLabel("");
        button = makeButton();

        final JComponent components[][] = {{roman, inputField}, {arabic, outputField}, {button}};
        setupLayout(pane, components);
        return pane;
    }

    private static JButton makeButton() {
        final JButton button = new JButton("Convert");
        final ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: add action
            }
        };
        button.addActionListener(listener);
        return button;
    }

    private static void setupLayout(final Container pane, final JComponent[][] components) {
        final GroupLayout layout = new GroupLayout(pane);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        pane.setLayout(layout);

        final SequentialGroup vgroup = layout.createSequentialGroup();
        vgroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(components[0][0]).addComponent(components[0][1]));
        vgroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(components[1][0]).addComponent(components[1][1]));
        vgroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(components[2][0]));
        layout.setVerticalGroup(vgroup);

        final SequentialGroup hgroup = layout.createSequentialGroup();
        hgroup.addGroup(layout.createParallelGroup().addComponent(components[0][0]).addComponent(components[1][0]).addComponent(components[2][0]));
        hgroup.addGroup(layout.createParallelGroup().addComponent(components[0][1]).addComponent(components[1][1]));
        layout.setHorizontalGroup(hgroup);
    }
}
