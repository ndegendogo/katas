package de.kifaru.ndegendogo.kata.romanNumbers;


import java.awt.Container;

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
        JFrame frame = new JFrame("Roman Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Hello World!");
        JLabel label2 = new JLabel("Hello World!");
        JLabel label3 = new JLabel("Hello World!");
        JLabel label4 = new JLabel("Hello World!");

        Container pane = frame.getContentPane();
        GroupLayout layout = new GroupLayout(pane);
        pane.setLayout(layout);

        SequentialGroup hgroup = layout.createSequentialGroup();
        hgroup.addGroup(layout.createParallelGroup().addComponent(label1).addComponent(label2));
        hgroup.addGroup(layout.createParallelGroup().addComponent(label3).addComponent(label4));
        layout.setHorizontalGroup(hgroup);

        SequentialGroup vgroup = layout.createSequentialGroup();
        vgroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(label1).addComponent(label3));
        vgroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(label2).addComponent(label4));
        layout.setVerticalGroup(vgroup);

        frame.pack();
        frame.setVisible(true);
    }
}
