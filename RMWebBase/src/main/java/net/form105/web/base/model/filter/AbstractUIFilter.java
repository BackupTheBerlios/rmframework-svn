package net.form105.web.base.model.filter;

import net.form105.rm.base.filter.IActivateFilter;

/**
 * 
 * @author hk
 *
 * @param <T> The object type the filter is executed on
 * @param <V> The configuration type of the filter
 */
public abstract class AbstractUIFilter<T, V> implements IActivateFilter<T> {
	
	private static final long serialVersionUID = 1L;
	private boolean activated;

	@Override
	public abstract boolean filter(T object);
	
	public boolean isActivated() {
		return activated;
	}
	
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	/**
	 * The id of a filter. Can be used for registration
	 * @return
	 */
	public abstract String getId();
	
	public abstract String getName();
	
	/**
	 * Getting the configuration parameter which is defined by the user. If a user configures a filter an input is
	 * required to filter some datasets. The configuration would usually be a pattern or choices can made from a drop down
	 * list to filter objects in 
	 * @return
	 */
	public abstract V getConfigParameter();
	
	public abstract void setConfigParameter(V object);
		
}
