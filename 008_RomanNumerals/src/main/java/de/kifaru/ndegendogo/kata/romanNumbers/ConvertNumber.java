package de.kifaru.ndegendogo.kata.romanNumbers;

import javax.swing.*;

public class ConvertNumber {

    public static void main(String ... args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("Hello World!");
        frame.getContentPane().add(label);
        
        frame.pack();
        frame.setVisible(true);
    }
}
