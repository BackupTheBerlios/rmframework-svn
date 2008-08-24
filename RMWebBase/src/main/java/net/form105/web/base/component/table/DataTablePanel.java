package net.form105.web.base.component.table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.form105.web.base.page.BasePage;
import net.form105.web.base.type.AjaxEventType;

import org.apache.log4j.Logger;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilteredColumn;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class DataTablePanel extends Panel {

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(DataTablePanel.class);

	private ISortableDataProvider provider;
	private String tableId;
	private List<IColumn> columns = new ArrayList<IColumn>();
	private int rowsPerPage;

	private boolean selectable = false;

	private final List<Object> selectedList = new ArrayList<Object>();
	
	private Form form;

	/**
	 * 
	 * @param id
	 *            The panel id
	 * @param tableId
	 *            The tableId
	 * @param provider
	 *            The data provider for the table which includes the input data
	 * @param columns
	 *            The columns of the table provided by a list
	 * @param rowsPerPage
	 *            Amount of rows shown per page
	 */
	public DataTablePanel(String panelId, String tableId, ISortableDataProvider provider, int rowsPerPage, List<IColumn> columns, boolean selectable) {
		super(panelId);

		this.provider = provider;
		this.tableId = tableId;
		this.selectable = selectable;
		this.rowsPerPage = rowsPerPage;
		this.columns = columns;
		addCheckBoxColumn(columns);
		
		
		add(new StyleSheetReference("dataTableStylesheet", new ResourceReference(DataTablePanel.class,"DataTablePanel.css")));

		
		final DataTable table = createTable();

		form = new Form("tableSelectionForm") {
			protected void onSubmit() {

				for (Object object : selectedList) {
					logger.info(object);
				}
				// clear out the set, we no longer need the selection
				selectedList.clear();

			}
		};

		form.add(table);
		add(form);
		
	}

	/**
	 * Creates a DataTable which overwrites a mouse event. The event is
	 * delegated to the page which sets a new panel for the context.
	 * 
	 * @return
	 */
	private DataTable createTable() {
		ClickableDataTable dataTable = new ClickableDataTable(tableId, columns, provider, rowsPerPage) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void doubleClickEvent(AjaxRequestTarget target, Object modelObject) {
				if (getPage() instanceof BasePage) {
					BasePage page = (BasePage) getPage();
					page.ajaxRequestReceived(target, modelObject, AjaxEventType.DOUBLE_CLICK);
				}
			}
		};
		return dataTable;
	}

	private void addCheckBoxColumn(List<IColumn> columns) {
		if (! selectable) {
			return;
		}
		CheckBoxColumn checkBoxColumn = new CheckBoxColumn(new PropertyModel(this, "selectedList")) {

			private static final long serialVersionUID = 1L;

			@Override
			protected Serializable getModelObjectToken(IModel model) {
				return (Serializable) model.getObject();
			}

		};
		columns.add(0, checkBoxColumn);
	}

}
