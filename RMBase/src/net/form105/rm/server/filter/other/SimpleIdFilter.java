package net.form105.rm.server.filter.other;

import net.form105.rm.base.filter.IFilter;

/**
 * This is only a dummy to provide an id. The filter isn't used but it integrates smoothly in the query model
 * @author hk
 *
 */
public class SimpleIdFilter implements IFilter<String> {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public SimpleIdFilter(String id) {
		this.id = id;
	}

	@Override
	public boolean filter(String object) {
		return false;
	}

}
