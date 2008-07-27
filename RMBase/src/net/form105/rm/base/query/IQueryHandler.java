package net.form105.rm.base.query;

import java.rmi.Remote;
import java.rmi.RemoteException;

import net.form105.rm.base.service.IResult;


public interface IQueryHandler extends Remote {
	
	public void executeQuery(IQuery<Void> query) throws RemoteException;
	
	public IResult getResultList() throws RemoteException;

}
