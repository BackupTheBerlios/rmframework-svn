package net.form105.rm.base.query.filter;

import java.io.Serializable;

/**
 * A filter implementing this interface returns true if the object can be filtered out.
 * The filter can be registered and then activated. If a user selects a filter and configures
 * it, the filter will be activated.
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
