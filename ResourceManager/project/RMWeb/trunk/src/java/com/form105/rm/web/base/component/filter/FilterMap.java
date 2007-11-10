package com.form105.rm.web.base.component.filter;

import com.form105.rm.web.base.component.filter.IFilterMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FilterMap implements IFilterMap {
	
	private Map<String, IViewFilter> filterMap = new HashMap<String, IViewFilter>();
	private List<String> selectedFilterIds = new ArrayList<String>();

	public FilterMap() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.rsp.web.base.component.table.IControlFilter#addFilter(java.lang.String, com.rsp.web.base.component.IViewFilter)
	 */
	public void addFilter(String id, IViewFilter filter) {
		filterMap.put(id, filter);
	}

	/* (non-Javadoc)
	 * @see com.rsp.web.base.component.table.IFilterMap#addFilter(com.rsp.web.base.component.IViewFilter)
	 */
	public void addFilter(IViewFilter filter) {
		this.filterMap.put(filter.getId(), filter);
	}

	/* (non-Javadoc)
	 * @see com.rsp.web.base.component.table.IControlFilter#removeFilterById(java.lang.String)
	 */
	public void removeFilterById(String id) {
		filterMap.remove(id);
	}

	/* (non-Javadoc)
	 * @see com.rsp.web.base.component.table.IControlFilter#getFilterById(java.lang.String)
	 */
	public IViewFilter getFilterById(String id) {
		return filterMap.get(id);
	}
	
	/*public Map<String, IViewFilter> getFilterMap() {
		return filterMap;
	}*/

	/* (non-Javadoc)
	 * @see com.rsp.web.base.component.table.IControlFilter#getSelectedFilter()
	 */
	public List<String> getSelectedFilter() {
		return selectedFilterIds;
	}

	/* (non-Javadoc)
	 * @see com.rsp.web.base.component.table.IControlFilter#setSelectedFilter(java.util.List)
	 */
	public void setSelectedFilter(List<String> selectedFilter) {
		this.selectedFilterIds = selectedFilter;
	}

	public String getFirstSelectedFilterId() {
		if (selectedFilterIds.size() > 0) {
			return selectedFilterIds.get(0);
		} else {
			return "";
		}
	}


	
	

}
