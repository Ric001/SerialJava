package com.enterprise.server.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

public class VerySimpleChatServer 
{
  

    private ArrayList<PrintWriter> clientOutputStreams;

    public class ClientHandler implements Runnable{
        BufferedReader reader;
        Socket sock;

        public ClientHandler(Socket clientSocket) {
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);

            } catch(Exception e) { e.printStackTrace(); }
        }

        
        public void run() {
            String message;
            try {
                while (( message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    tellEveryone(message);
                    assert ( message != "");
                }
            } catch (Exception ex) { ex.printStackTrace(); }    
        }
       
    }

    public void tellEveryone(String message) {
        for (PrintWriter client : clientOutputStreams) {
            client.println(message);
            client.flush();
        }
    }

    public void go() {
        clientOutputStreams = new ArrayList<PrintWriter>();
        try {
            ServerSocket serverSock = new ServerSocket(5000);

            while(true) {
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);
                
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("Got a Connection");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
}