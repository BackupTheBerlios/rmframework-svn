package net.form105.rm.base.query;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;

import net.form105.rm.base.service.IResult;

public class RMIQueryHandler<T> extends UnicastRemoteObject implements IQueryHandler<T> {

	private static final long serialVersionUID = 1L;

	private QueryResult<T> result = new QueryResult<T>();
	private final String name = "QueryHandler";

	public RMIQueryHandler() throws RemoteException {
		super();
	}

	@Override
	public void executeQuery(IQuery<T> query) throws RemoteException {

		try {
			Collection<T> queryResult = query.execute();
			result.setResultList(new ArrayList<T>(queryResult));
		} catch (Exception ex) {
			result.setException(ex);
		}

	}

	@Override
	public IResult<T> getResult() throws RemoteException {
		return result;
	}

	/**
	 * Getting the name of this query handler. This query handler is used in the rmi registry 
	 * by the provided name
	 * @return
	 */
	public String getName() {
		return name;
	}

}
