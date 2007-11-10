package com.form105.rm.web.base.component.table;

import com.form105.rm.web.base.component.filter.IFilterMap;
import com.form105.rm.web.base.component.filter.AbstractInputFilter;
import com.form105.rm.web.base.component.filter.FilterMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


public abstract class TableFilterHandler {

	protected Logger logger = Logger.getLogger(TableFilterHandler.class);

	private String executedFilter;
	private String filterInput;
	private String selectedFilter;

	private IFilterMap controlFilter;
	
	
	public TableFilterHandler() {
		controlFilter = new FilterMap();
	}

	/**
	 * The action executed on committing a filter. The filter works on
	 * t:panelStack. Each registered filter is viewed on its own panel.
	 * Unfortunately if a submit is commited also the empty input fields of each
	 * stack are saved with empty strings.
	 * 
	 * @return The outcome for navigation
	 */
	public String doFilterSelected() {
		// Check if we got an empty input field
		if (controlFilter.getFilterById(selectedFilter) instanceof AbstractInputFilter) {
			AbstractInputFilter filter = (AbstractInputFilter) controlFilter.getFilterById(selectedFilter);
			if (filter.getInput().equals(""))
				return "";

		}

		executedFilter = getSelectedFilter();
		if (controlFilter.getFilterById(selectedFilter) instanceof AbstractInputFilter) {
			AbstractInputFilter iFilter = (AbstractInputFilter) controlFilter.getFilterById(selectedFilter);
			filterInput = (String) iFilter.getInput();
		}

		ArrayList<String> filterList = new ArrayList<String>();
		filterList.add(getSelectedFilter());

		controlFilter.setSelectedFilter(filterList);
		return "";
	}

	/**
	 * @return the select
	 */
	public String getSelectedFilter() {
		if (selectedFilter == null) {
			return "noSelection";
		}
		return selectedFilter;
	}

	/**
	 * The filter that is selected.
	 * 
	 * @param select
	 */
	public void setSelectedFilter(String select) {
		logger.info("filter selected: " + select);

		if (select.equals("noSelection")) {
			controlFilter.setSelectedFilter(new ArrayList());
			executedFilter = null;
			filterInput = null;
		}

		this.selectedFilter = select;
	}

	/**
	 * Getting the executed filter which we want to save longer than request
	 * scope
	 * 
	 * @return
	 */
	public String getExecutedFilter() {
		return executedFilter;
	}

	/**
	 * Setting the executed filter. Need for restore the state.
	 * 
	 * @param executedFilter
	 */
	public void setExecutedFilter(String executedFilter) {
		this.executedFilter = executedFilter;
	}

	/**
	 * Getting the filter input. The filter input is saved longer than request
	 * scope. This method is used for the t:saveState tag in views to save the
	 * input of a filter
	 * 
	 * @return
	 */
	public String getFilterInput() {
		return filterInput;
	}

	/**
	 * Setting the filter input. This methode is used by the t:saveState
	 * component to restore the input of a filter.
	 * 
	 * @param filterInput
	 */
	public void setFilterInput(String filterInput) {
		this.filterInput = filterInput;
	}
	
	/**
	 * Getting the control filter. The control filter is the object used to add filter
	 * to a control and set the selected filter which is used by the input. The input
	 * of a control is filtered by the @see IControlFilter.
	 * @return
	 */
	public IFilterMap getControlFilter() {
		return controlFilter;
	}

	public void setControlFilter(IFilterMap controlFilter) {
		this.controlFilter = controlFilter;
	}
	
	public abstract Map<String, String> getFilters();
	
	public abstract List getTable();

}
