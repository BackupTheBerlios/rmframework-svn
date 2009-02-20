package net.form105.rm.base.query;

import java.util.List;

public abstract class AbstractQuery<T> implements IQuery<T> {
	
	private static final long serialVersionUID = 1L;

	public abstract List<T> execute();

}
