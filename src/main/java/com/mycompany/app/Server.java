package com.mycompany.app;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
public class Server {
    private String incomingMessage; 
    private String messageToSend;
    public Server() {
        try {
            Socket chatSocket = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(chatSocket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            incomingMessage = reader.readLine();
            
            PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
            writer.println("Fell Alone Black Days");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getIncomingMessage() {
        return incomingMessage;
    }

    public String getMessageToSend() {
        return messageToSend;
    }

    public void setMessageToSend(String messageToSend) {
        this.messageToSend = messageToSend;
    }
}