package net.form105.rm.base.query.filter;

/**
 * A filter implementing this interface returns true if the object can be filtered out.
 * @author heiko
 *
 */
public interface IFilter {

	/**
	 * Filter the object. If the object can be filtered return true
	 * @param object
	 * @return
	 */
	public boolean filter(Object object);
	
}
