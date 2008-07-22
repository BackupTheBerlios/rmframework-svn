package com.form105.rm.base.query;

import java.rmi.Remote;

import com.form105.rm.base.service.IResult;

public interface IQueryHandler<T> extends Remote {
	
	public void executeQuery(IQuery<T> query);
	
	public IResult<T> getResultList();

}
