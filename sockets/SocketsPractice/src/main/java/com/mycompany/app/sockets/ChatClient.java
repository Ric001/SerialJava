package com.mycompany.app.sockets;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;

public class ChatClient {

    private JFrame frame;
    private JButton sendButton;
    private Socket socket;
    private PrintWriter writer;
    private JTextField outGoing;
    public void go() {
        frame = new JFrame("Chat Client");
        frame.setSize(300,200);
        JPanel mainPanel = new JPanel();
        sendButton = new JButton("Send Message");
        outGoing = new JTextField(20);
        sendButton.addActionListener(event -> {
            try {
                writer.println(outGoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            outGoing.setText("");
            outGoing.requestFocus();
        });
        mainPanel.add(sendButton);
        mainPanel.add(outGoing);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setNetWorking();
        frame.setVisible(true);
    }

    public void setNetWorking() {
      try {
          socket = new Socket("127.0.0.1", 5000);
          writer = new PrintWriter(socket.getOutputStream());
      } catch (IOException ex) {
          ex.printStackTrace();
      }
    } 
}