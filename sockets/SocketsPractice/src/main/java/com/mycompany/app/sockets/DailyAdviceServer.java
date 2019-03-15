package com.mycompany.app.sockets;

import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class DailyAdviceServer {
    
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do Not make you feel fat."};
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            
            while(true) {
                Socket sock = serverSocket.accept(); 

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }


}