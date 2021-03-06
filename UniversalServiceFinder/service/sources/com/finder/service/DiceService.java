package com.finder.service;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiceService implements IService {
 
    JLabel label;
    JComboBox numOfDice;

    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Roll `em!");
        String[] choices = {"1", "2", "3", "4", "5"};
        numOfDice = new JComboBox();
        label = new JLabel("dice values here");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String diceOutput = "";
                String selection = (String) numOfDice.getSelectedItem();
                int numOfDiceToRoll = Integer.parseInt(selection);
                
                for (int i = 0; i < numOfDiceToRoll; i++) {
                    int r = (int) ((Math.random() * 6) + 1);
                    diceOutput += (" " + r);
                }

                label.setText(diceOutput);
            }
        });
       
        panel.add(numOfDice);
        panel.add( button );
        panel.add( label );
        return panel;
    }
}