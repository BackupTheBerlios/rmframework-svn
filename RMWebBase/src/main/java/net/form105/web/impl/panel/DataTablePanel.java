package net.form105.web.impl.panel;

import java.util.List;

import net.form105.rm.base.model.user.User;
import net.form105.web.impl.page.userManagement.UsersPage;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

public class DataTablePanel extends Panel implements IContextPanel{
	
	private static final long serialVersionUID = 1L;
	
	private ISortableDataProvider provider;
	private String tableId;
	private List columns;
	private DataTable table;
	private int rowsPerPage;
	private Label sampleLabel;
	private Panel context;

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
		sampleLabel = new Label("sampleLabel", "sampleLabel1");
		sampleLabel.setOutputMarkupPlaceholderTag(true);
		sampleLabel.setVisible(false);
		add(sampleLabel);
		add(createTable());
		
	}
	
	
	private DataTable createTable() {
		ClickableDataTable dataTable = new ClickableDataTable(tableId, columns, provider, 10) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void doubleClickEvent(AjaxRequestTarget target, Object modelObject) {
				if (getContext() == null) {
					return;
				}
				
				
				
				logger.info("Creating contextPanel based on doubleClickEvent");
				logger.info("Page: "+getPage());
				
				UsersPage page = (UsersPage) getPage();
				page.ajaxRequestReceived(target, modelObject);
			}
			
		};
		return dataTable;
	}


	@Override
	public Panel getContext() {
		return context;
	}


	@Override
	public void setContext(Panel contextPanel) {
		this.context = contextPanel;
	}
	
	
	

	
	

}
