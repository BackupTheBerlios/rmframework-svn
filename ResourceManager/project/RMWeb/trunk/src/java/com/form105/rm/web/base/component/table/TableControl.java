package com.form105.rm.web.base.component.table;

import com.form105.rm.web.base.component.filter.IFilterMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIColumn;
import javax.faces.component.UIData;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;

import org.apache.log4j.Logger;

public class TableControl {
	// Logger
	Logger logger = Logger.getLogger(TableControl.class);

	// Declaration
	private Object input;

	private List headerList = new ArrayList();

	private UIData dynamicDataTable;

	private ITableLabelProvider labelProvider;

	private ITableContentProvider contentProvider;
	private IFilterMap filter;

	/**
	 * Setting the object of the table
	 * 
	 * @param dynamicDataTable
	 *            The object of a table
	 */
	public TableControl(UIData dynamicDataTable) {
		this.dynamicDataTable = dynamicDataTable;
	}

	/**
	 * @return the labelProvider
	 */
	public ITableLabelProvider getLabelProvider() {
		return labelProvider;
	}

	/**
	 * @param labelProvider
	 *            the labelProvider to set
	 */
	public void setLabelProvider(ITableLabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	/**
	 * Getting the output of the table
	 */
	public Object getInput() {
		return input;
	}

	/**
	 * Setting the input of the table
	 * 
	 * @param input
	 *            the input of a table
	 */
	public void setInput(Object input) {
		this.input = input;
	}

	/**
	 * Create the table with an action. When the sAction is empty then will be
	 * not create an action
	 */
	public void createTable(String sAction) {

		int iColumns; // Count columns

		List rowsList = getRowsList();

		// Get the columns (count)
		if (rowsList.size() > 0) {
			ArrayList value = (ArrayList) rowsList.get(0);
			// The last column is for the object resource
			iColumns = (value.size() - 1);
		} else {
			iColumns = 0;
		}

		// Any columns defined
		if ((rowsList.size() > 0) && (iColumns > 0)) {
			// Set columns
			for (int i = 0; i < iColumns; i++) {
				// Command component with action
				UIOutput headerColumn = new UIOutput();
				headerColumn.setId("Button" + i);
				headerColumn.setTransient(false);
				if (headerList != null) {
					if (i < headerList.size()) {
						headerColumn.setValue(headerList.get(i));
					}// endif
				}// endif
				// Bind the value and var to the output
				if (sAction.length() > 0) {
					// Command object
					if (sAction.charAt(0) == '#') {
						UIOutput output = new UIOutput();
						ValueBinding myItem = FacesContext.getCurrentInstance()
								.getApplication().createValueBinding(
										"#{data[" + i + "]}");
						output.setValueBinding("value", myItem);
						output.setId("Output" + i);
						MethodBinding mbButton = FacesContext
								.getCurrentInstance().getApplication()
								.createMethodBinding(sAction, null);
						output.setRendererType("javax.faces.Link");
						// Set column
						UIColumn column = new UIColumn();
						column.setHeader(headerColumn);
						column.getChildren().add(output);
						// Add column
						dynamicDataTable.getChildren().add(column);
					} else {
						UIOutput output = new UIOutput();
						ValueBinding myItem = FacesContext.getCurrentInstance()
								.getApplication().createValueBinding(
										"#{data[" + i + "]}");
						output.setValueBinding("value", myItem);
						output.setId("OutputText" + i);
						// Set column
						UIColumn column = new UIColumn();
						column.setHeader(headerColumn);
						column.getChildren().add(output);
						// Add column
						dynamicDataTable.getChildren().add(column);
					}
				}
			}
		}
	}

	/**
	 * Set the labels for the columns
	 * 
	 * @return the inputLabelProvider
	 */
	public List getHeaderList() {
		return headerList;
	}

	/**
	 * Get the labels from the columns
	 * 
	 * @param inputLabelProvider
	 *            the inputLabelProvider to set
	 */
	public void setHeaderList(List headerList) {
		this.headerList = headerList;
	}

	/**
	 * @return the contentProvider
	 */
	public ITableContentProvider getContentProvider() {
		return contentProvider;
	}

	/**
	 * @param contentProvider
	 *            the contentProvider to set
	 */
	public void setContentProvider(ITableContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	/**
	 * @return the rowsList
	 */
	public List getRowsList() {
		
		List rowsList = new ArrayList();
//		 filteredInput will be set to inputList if we haven't a filter
		List filteredInput = new ArrayList();
		
		List inputList = contentProvider.getElements(input);

		//filter input
		if (filter != null && filter.getSelectedFilter() != null && filter.getSelectedFilter().size() > 0) {
			logger.debug("amount of selected filters is: "+filter.getSelectedFilter().size());
			String filterId = filter.getFirstSelectedFilterId();
			for (Object inputObject : inputList) {
				if (filter.getFilterById(filterId).select(inputObject)) {
					filteredInput.add(inputObject);
				}
			}
			
		} else {
			filteredInput = inputList;
		}
		
		// Take the labels from the provider
		headerList.clear();
		labelProvider.getColumnText(headerList);

		// Set the list for the table
		rowsList.clear();
		if(filteredInput != null) {
			for (Iterator iter = filteredInput.iterator(); iter.hasNext();) {
				rowsList.add(labelProvider.getContent(iter.next()));
			}
		} else {	
			rowsList.add(labelProvider.getContent(filteredInput));	
		}
		
		return rowsList;
	}
	
	public void setFilter(IFilterMap filter) {
		this.filter = filter;
	}
	
	public IFilterMap getFilter() {
		return filter;
	}

	
}
