package net.form105.rm.base.query.filter;

import java.io.Serializable;

/**
 * A filter implementing this interface returns true if the object can be filtered out.
 * @author heiko
 *
 */
public interface IFilter<T> extends Serializable {

	/**
	 * Filter the object. If the object can be filtered return true
	 * @param object
	 * @return
	 */
	public boolean filter(T object);
	
}
