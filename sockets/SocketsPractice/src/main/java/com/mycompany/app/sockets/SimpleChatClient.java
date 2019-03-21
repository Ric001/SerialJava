package com.mycompany.app.sockets;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClient {

    private JTextArea inComing;
    private JTextField outGoing;
    private JTextField proof;
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket sock;
    private JFrame frame;
    
    public void go() {
       
        frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        inComing = new JTextArea(15, 50);
        inComing.setLineWrap(true);
        inComing.setWrapStyleWord(true);
        inComing.setEditable(false);
        JScrollPane qScroller = new JScrollPane(inComing);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outGoing = new JTextField(20);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(event -> {
            try {
                writer.println(outGoing.getText());
                writer.flush();
            } catch (Exception e) { e.printStackTrace(); }

            outGoing.setText("");
            outGoing.requestFocus();
        });

        mainPanel.add(qScroller);
        mainPanel.add(outGoing);
        mainPanel.add(sendButton);
        setUpNetworking();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
        proof = new JTextField(20);
        mainPanel.add(proof);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        try {
            sock = new Socket("localhost", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Networking established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;
            String tmp;
            try {
                while ( (message = reader.readLine()) != null) {
                    System.out.println("incoming read " + message);
                    inComing.append(message.concat("\n"));
                }  
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }

}