package com.form105.rm.web.base.component.table;

import java.util.ArrayList;
import java.util.List;

public interface ITableLabelProvider {

	public List getColumnText(List list);
	
	/**
	 * Getting the content of each row. The content es splittet by an array which
	 * represents a column
	 * @param object
	 * @return
	 */
	public List getContent(Object object);
	
}
