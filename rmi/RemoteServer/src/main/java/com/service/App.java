package com.service;

import java.rmi.Naming;

public class App 
{
    public static void main( String[] args )
    {
       try {
           MyRemote remote = new MyRemoteImpl();
           Naming.rebind("Remote Hello Service", remote);
       } catch (Exception ex) {
           ex.printStackTrace();
       }
    }
}
