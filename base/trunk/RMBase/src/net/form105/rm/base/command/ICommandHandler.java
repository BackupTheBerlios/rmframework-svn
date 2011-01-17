package net.form105.rm.base.command;

import java.rmi.RemoteException;
import java.util.List;

import net.form105.rm.base.service.IResult;

public interface ICommandHandler<T> {
	
	public void execute(ICommand command);
	
	public void execute(List<ICommand> commands);
	
	public IResult<T> getResult() throws RemoteException;

}
