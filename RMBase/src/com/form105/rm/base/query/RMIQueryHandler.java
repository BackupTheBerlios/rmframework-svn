package com.form105.rm.base.query;

import com.form105.rm.base.service.IResult;

public class RMIQueryHandler<T> implements IQueryHandler<T> {

	private QueryResult<T> result = new QueryResult<T>();
	
	private final String name = "RMIQueryHandler";

	@Override
	public void executeQuery(IQuery<T> query) {
		try {
			result.setResultList(query.execute());
		} catch (Exception ex) {
			result.setException(ex);
		}
	}

	@Override
	public IResult<T> getResultList() {
		return result;
	}
	
	public String getName() {
		return name;
	}

}
