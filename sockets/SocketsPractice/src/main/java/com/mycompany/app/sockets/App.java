package com.mycompany.app.sockets;


public class App 
{
    public static void main( String[] args )
    {
        DailyAdviceClient adviceClient = new DailyAdviceClient();
        adviceClient.go();
    }
}
