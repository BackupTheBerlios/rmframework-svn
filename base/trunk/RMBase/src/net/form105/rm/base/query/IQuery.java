package net.form105.rm.base.query;

import java.io.Serializable;
import java.util.List;

import net.form105.rm.base.service.IResult;

public interface IQuery<T> extends Serializable {
	
	public List<T> execute();
	
	public IResult<T> getQueryResult();

}
