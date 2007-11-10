package com.form105.rm.web.base.component.filter;

import com.form105.rm.web.base.component.filter.IViewFilter;
import java.util.List;


/**
 * Adds filter functions to a control. Filters are registered on a control. A list of
 * filters can than be selected. The filters should be executed on the input of
 * the control.
 * @author Heiko Kundlacz
 *
 */
public interface IFilterMap {

	/**
	 * Adding a filter to a control. The id identifies the filter.
	 * @param id The id of the filter (must be unique)
	 * @param filter The filter to add
	 */
	public abstract void addFilter(String id, IViewFilter filter);
	
	/**
	 * Adding a filter to a control.
	 * @param filter The filter to add
	 */
	public void addFilter(IViewFilter filter);

	/**
	 * Removes a filter by the id
	 * @param id of the filter
	 */
	public abstract void removeFilterById(String id);

	/**
	 * Getting a filter by its id
	 * @param id of the filter
	 * @return The filter
	 */
	public abstract IViewFilter getFilterById(String id);

	/**
	 * Getting the selected filter which are executed on the input. Usually only
	 * the first filter is used. For later purposes the filter can be concatenated 
	 * @return The selected filters
	 */
	public abstract List<String> getSelectedFilter();

	/**
	 * Setting the filters which are executed on the input
	 * @param selectedFilter
	 */
	public abstract void setSelectedFilter(List<String> selectedFilter);
	
	/**
	 * Getting the first filter from the list
	 * @return
	 */
	public abstract String getFirstSelectedFilterId();

}