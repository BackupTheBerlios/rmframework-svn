package net.form105.web.impl.panel;

import java.util.List;

import net.form105.web.base.page.BasePage;
import net.form105.web.base.type.AjaxEventType;

import org.apache.log4j.Logger;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.LoadableDetachableModel;

public class DataTablePanel extends Panel {
	
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(DataTablePanel.class);
	
	private ISortableDataProvider provider;
	private String tableId;
	private List<IColumn> columns;
	private int rowsPerPage;
	private Label sampleLabel;

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
	
	
	/**
	 * Creates a DataTable which overwrites a mouse event. The event is delegated to the page which sets a new 
	 * panel for the context.
	 * @return
	 */
	private DataTable createTable() {
		ClickableDataTable dataTable = new ClickableDataTable(tableId, columns, provider, rowsPerPage) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void doubleClickEvent(AjaxRequestTarget target, Object modelObject) {
				BasePage page = (BasePage) getPage();
				page.ajaxRequestReceived(target, modelObject, AjaxEventType.DOUBLE_CLICK);
			}
			
			
		};
		
		return dataTable;
	}

}
