package de.kifaru.ndegendogo.kata.romanNumbers;

//import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

import javax.swing.*;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.GroupLayout.SequentialGroup;

public class ConvertRomanGUI extends JPanel {

    private static final long serialVersionUID = 1L;

    private Function<String, Integer> converter;

    private JLabel romanLabel;
    private JTextField romanNumber;
    private JLabel arabicLabel;
    private JLabel arabicNumber;

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
        final Integer convertedNumber = converter.apply(romanNumber.getText());
        final String convertedString = (convertedNumber <= 0 ? "Illegal Input" : convertedNumber.toString());
        arabicNumber.setText(convertedString);
        romanNumber.selectAll();
    }

    private static void setupLayout(final JPanel pane, final JComponent[][] components) {
     // vertical and horizontal Box
        Box vbox0 = Box.createVerticalBox();
        vbox0.add(Box.createGlue());
        vbox0.add(components[0][0]);
        vbox0.add(Box.createGlue());
        vbox0.add(components[1][0]);
        vbox0.add(Box.createGlue());

        Box vbox1 = Box.createVerticalBox();
        vbox1.add(Box.createGlue());
        vbox1.add(components[0][1]);
        vbox1.add(Box.createGlue());
        vbox1.add(components[1][1]);
        components[1][1].setAlignmentX(LEFT_ALIGNMENT);
        vbox1.add(Box.createGlue());

        Box hbox = Box.createHorizontalBox();
        hbox.add(Box.createGlue());
        hbox.add(vbox0);
        hbox.add(Box.createGlue());
        hbox.add(vbox1);
        hbox.add(Box.createGlue());

        pane.add(hbox);
/*
// BoxLayout
        BoxLayout layout = new BoxLayout(pane, BoxLayout.PAGE_AXIS);
        pane.setLayout(layout);
        for (JComponent[] line : components) {
            final JPanel panelLine = new JPanel();
            panelLine.setLayout(new BoxLayout(panelLine, BoxLayout.LINE_AXIS));
            panelLine.setAlignmentX(LEFT_ALIGNMENT);
            for (JComponent element : line) {
                panelLine.add(element);
            }
            pane.add(panelLine);
        }
*/
/*
// GroupLayout 
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
*/
    }
}
