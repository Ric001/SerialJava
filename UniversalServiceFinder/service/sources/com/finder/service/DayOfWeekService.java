package com.finder.service;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class DayOfTheWeekService implements Service {
    JLabel outputLabel;
    JComboBox month;
    JTextField day;
    JTextField year;

    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Do it");
        implementButton(button);
        outputLabel = new JLabel("date appears here");
        DateFormatSymbols dataStuff = new DateFormatSymbols();
        month = new JComboBox(dateStuff.getMonths());
        day = new JTextField(8);
        year = new JTextField(8);
        JPanel inputPanel = JPanel(new GridLayout(3,2));
        inputPanel.add(new JLabel("Month"));
        inputPanel.add(month);    
        inputPanel.add(new JLabel("Year"));
        inputPanel.add(year);
        panel.add(inputPanel);
        panel.add(button);
        panel.add(outLabel);
        return panel;
    }

    private void implementButton(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int monthNum = month.getSelectedIndex(); 
                int dayNum = Integer.parseInt(day.getText());
                int yearNum = Integer.parseInt(year.getText());
                Calendar c = Calendar.getInstance();
                c.set(Calendar.MONTH, monthNum);
                c.set(Calendar.DAY, dayNum);
                c.set(Calendar.YEAR, yearNum);
                Date date = c.getTime();
                String dayOfWeek = (new SimpleDateFormat("EEEE")).format(date);
                outputPanel.setText(dayOfWeek);
            }
        });
    }

}