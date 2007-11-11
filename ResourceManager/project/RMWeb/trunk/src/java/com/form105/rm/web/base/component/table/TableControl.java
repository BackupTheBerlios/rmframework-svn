package com.form105.rm.web.base.component.table;

import com.form105.rm.web.base.component.filter.IFilterMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIColumn;
import javax.faces.component.UIData;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
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
	 * Create the table and set the ui components
	 */
  public void createTable() {

    // the colums of the input list must match the column size
    

    List<List> rowsList = getRowsList();
    
    int colOfHeader = getHeaderList().size();
    int colOfRows = rowsList.get(0).size();
    
    if (colOfRows != colOfHeader) {
      logger.error("Number of colums of header and content doesn't match");
    }
    

    if ((rowsList.size() > 0) && (colOfRows > 0)) {
      // Set columns
      for (int i = 0; i < colOfRows; i++) {
        
        UIOutput headerColumn = new UIOutput();
        headerColumn.setId("Button" + i);
        headerColumn.setTransient(false);
        if (headerList != null) {
          if (i < headerList.size()) {
            headerColumn.setValue(headerList.get(i));
          }
        }

        UIOutput output = new UIOutput();
        ValueBinding myItem = FacesContext.getCurrentInstance().getApplication().createValueBinding("#{row[" + i + "]}");
        output.setValueBinding("value", myItem);
        output.setId("OutputText" + i);

        UIColumn column = new UIColumn();
        column.setHeader(headerColumn);
        column.getChildren().add(output);

        dynamicDataTable.getChildren().add(column);

      }

    }
  }

  /**
	 * Set the labels for the columns
	 * 
	 * @return the inputLabelProvider
	 */
  public List<String> getHeaderList() {
    return headerList;
  }

  /**
	 * Get the labels from the columns
	 * 
	 * @param inputLabelProvider
	 *            the inputLabelProvider to set
	 */
  public void setHeaderList(List<String> headerList) {
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
  public List<List> getRowsList() {

    List rowsList = new ArrayList();
    //		 filteredInput will be set to inputList if a filter isn't given
    List filteredInput = new ArrayList();
    List inputList = contentProvider.getElements(input);

    // filter the input list
    if (filter != null && filter.getSelectedFilter() != null && filter.getSelectedFilter().size() > 0) {
      logger.debug("amount of selected filters is: " + filter.getSelectedFilter().size());
      String filterId = filter.getFirstSelectedFilterId();
      for (Object inputObject : inputList) {
        if (filter.getFilterById(filterId).select(inputObject)) {
          filteredInput.add(inputObject);
        }
      }

    } else {
      filteredInput = inputList;
    }

    // Set the list for the table
    rowsList.clear();

    for (Iterator iter = filteredInput.iterator(); iter.hasNext();) {
      rowsList.add(labelProvider.getContent(iter.next()));
    }

    return rowsList;
  }

  public void setFilter(IFilterMap filter) {
    this.filter = filter;
  }

  public IFilterMap getFilter() {
    return filter;
  }

  private void createComplexBinding() {
  /**UIOutput output = new UIOutput();
    ValueBinding myItem = FacesContext.getCurrentInstance().getApplication().createValueBinding("#{data[" + i + "]}");
    output.setValueBinding("value", myItem);
    output.setId("Output" + i);
    MethodBinding mbButton = FacesContext.getCurrentInstance().getApplication().createMethodBinding(sAction, null);
    output.setRendererType("javax.faces.Link");
    // Set column
    UIColumn column = new UIColumn();
    column.setHeader(headerColumn);
    column.getChildren().add(output);
    // Add column
    dynamicDataTable.getChildren().add(column);**/
  }
}
