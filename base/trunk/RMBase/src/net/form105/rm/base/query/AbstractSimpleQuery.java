package net.form105.rm.base.query;

import java.util.List;

public abstract class AbstractSimpleQuery<T> implements IQuery<T> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public abstract List<T> execute();

}
