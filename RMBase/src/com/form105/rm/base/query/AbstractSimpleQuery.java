package com.form105.rm.base.query;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSimpleQuery<T> implements IQuery<T> {
	
	

	@Override
	public abstract List<T> execute();

}
