package net.form105.web.base.model.filter;

import net.form105.rm.base.filter.IActivateFilter;

public abstract class AbstractUIFilter<T> implements IActivateFilter<T> {
	
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
		
}
