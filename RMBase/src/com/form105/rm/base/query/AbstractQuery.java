package com.form105.rm.base.query;

import java.util.List;

public abstract class AbstractQuery<T> implements IQuery<T> {
	
	public abstract List<T> execute();

}
