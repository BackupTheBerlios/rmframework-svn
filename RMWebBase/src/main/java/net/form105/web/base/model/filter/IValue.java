package net.form105.web.base.model.filter;

import java.io.Serializable;

public interface IValue<T, V> extends Serializable {
	
	public T getValue(V object);

}
