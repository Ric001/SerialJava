package com.mycompany.app.sockets;

import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class DailyAdviceServer extends Thread{
    
    
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            
            while(true) {
                System.out.println("Waiting Requests....");
                Socket client = serverSocket.accept(); 
                SocketClientHandler clientHandler = new SocketClientHandler(client);
                
                System.out.println("I just received a request");
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }


        
    }

    

    public static class SocketClientHandler extends Thread{
        private Socket client;
        String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do Not make you feel fat."};
        public SocketClientHandler(Socket client) {
            this.client = client;
            this.start();
        }

        @Override 
        public void run() {
            try {
                PrintWriter writer = new PrintWriter(client.getOutputStream());
                writer.println(getAdvice());
                writer.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        private String getAdvice() {
            int random = (int) (Math.random() * adviceList.length);
            return adviceList[random];
        }

    
    }
}