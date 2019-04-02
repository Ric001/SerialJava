package com.service;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote 
{
    private static final long serialVersionUID = -988341148090964690L;

    public MyRemoteImpl() throws RemoteException { }

    @Override
    public String sayHello() {
        return "Server Says, 'Hey'";
    }
}