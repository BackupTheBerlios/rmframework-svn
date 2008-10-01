package net.form105.rm.base.command;

import java.rmi.RemoteException;

import net.form105.rm.base.service.IResult;

public interface ICommandHandler<T> {
	
	public IResult<T> getResult() throws RemoteException;

}
