package com.finder.service; 

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServiceServer extends Remote {

    Object[] getServiceList() throws RemoteException;
    IService getService(Object serviceKey) throws RemoteException;
}