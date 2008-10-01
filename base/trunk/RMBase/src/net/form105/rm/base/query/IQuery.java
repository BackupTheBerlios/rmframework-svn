package net.form105.rm.base.query;

import java.io.Serializable;
import java.util.List;

public interface IQuery<T> extends Serializable {
	
	public List<T> execute();

}
