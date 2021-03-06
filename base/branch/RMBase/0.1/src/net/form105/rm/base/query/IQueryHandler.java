package net.form105.rm.base.query;

import java.rmi.Remote;
import java.rmi.RemoteException;

import net.form105.rm.base.service.IResult;


public interface IQueryHandler<T> extends Remote {
	
	public void executeQuery(IQuery<T> query) throws RemoteException;
	
	public IResult<T> getResult() throws RemoteException;

}
