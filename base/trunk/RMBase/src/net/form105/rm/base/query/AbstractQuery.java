package net.form105.rm.base.query;

import java.util.List;

import net.form105.rm.base.service.IResult;

public abstract class AbstractQuery<T> implements IQuery<T> {
    
    private QueryResult<T> result = new QueryResult<T>();
	
	private static final long serialVersionUID = 1L;

	public abstract List<T> execute();
	
	public IResult<T> getQueryResult() {
	    return result;
	}

}
