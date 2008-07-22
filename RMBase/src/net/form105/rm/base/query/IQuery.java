package net.form105.rm.base.query;

import java.util.Collection;

public interface IQuery<T> {
	
	public Collection<T> execute();

}
