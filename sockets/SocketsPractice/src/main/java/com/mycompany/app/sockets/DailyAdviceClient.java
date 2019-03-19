package com.mycompany.app.sockets;

import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class DailyAdviceClient 
{
    
    public void go() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 4242);
            
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            
            String advice = reader.readLine();
            System.out.println("Today you should: ".concat(advice));
            
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}