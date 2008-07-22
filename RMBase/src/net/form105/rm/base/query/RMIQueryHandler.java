package net.form105.rm.base.query;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import net.form105.rm.base.service.IResult;

public class RMIQueryHandler<T> extends UnicastRemoteObject implements IQueryHandler<T> {

	public RMIQueryHandler() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	private QueryResult<T> result = new QueryResult<T>();
	
	private final String name = "QueryHandler";

	@Override
	public void executeQuery(IQuery<T> query) throws RemoteException {
		try {
			result.setResultList(query.execute());
		} catch (Exception ex) {
			result.setException(ex);
		}
	}

	@Override
	public IResult<T> getResultList() throws RemoteException {
		return result;
	}
	
	public String getName() {
		return name;
	}

}
