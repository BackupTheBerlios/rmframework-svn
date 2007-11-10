package com.form105.rm.web.base.component.table;

import java.util.List;

public interface ITableContentProvider {
	
	/**
	 * Resolve the object to a list
	 * @param object
	 * @return
	 */
	public List getElements(Object object);

}
