package net.form105.rm.base.query;

import java.util.Collection;

public abstract class AbstractSimpleQuery<T> implements IQuery<T> {
	
	

	@Override
	public abstract Collection<T> execute();

}
