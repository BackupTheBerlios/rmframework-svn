package net.form105.rm.base.query;

import java.io.Serializable;
import java.util.Collection;

public interface IQuery<T> extends Serializable {
	
	public Collection<T> execute();

}
