package net.form105.web.impl.panel;

import java.util.List;

import net.form105.web.impl.page.userManagement.UsersPage;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

public class DataTablePanel extends Panel {
	
	private static final long serialVersionUID = 1L;
	
	private ISortableDataProvider provider;
	private String tableId;
	private List columns;
	private DataTable table;
	private int rowsPerPage;

	/**
	 * 
	 * @param id The panel id
	 * @param tableId The tableId
	 * @param provider The data provider for the table which includes the input data
	 * @param columns The columns of the table provided by a list
	 * @param rowsPerPage Amount of rows shown per page
	 */
	public DataTablePanel(String id, String tableId, ISortableDataProvider provider, List<IColumn> columns, int rowsPerPage) {
		super(id);
		add(new StyleSheetReference("dataTableStylesheet", new ResourceReference(DataTablePanel.class, "DataTablePanel.css")));
		this.provider = provider;
		this.tableId = tableId;
		this.columns = columns;
		this.rowsPerPage = rowsPerPage;
		add(createTable());
	}
	
	
	private DataTable createTable() {
		ClickableDataTable dataTable = new ClickableDataTable(tableId, columns, provider, 10);
		return dataTable;
	}
	

	
	

}
