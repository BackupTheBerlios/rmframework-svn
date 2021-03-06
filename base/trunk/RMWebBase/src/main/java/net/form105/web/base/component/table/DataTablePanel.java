package net.form105.web.base.component.table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.form105.web.base.action.ActionForm;
import net.form105.web.base.model.provider.AbstractDataProvider;
import net.form105.web.base.page.BasePage;
import net.form105.web.base.type.EventType;

import org.apache.log4j.Logger;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class DataTablePanel<T> extends Panel {

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(DataTablePanel.class);

	private AbstractDataProvider<T> provider;
	private String tableId;
	private List<IColumn<T>> columns = new ArrayList<IColumn<T>>();
	private int rowsPerPage;

	private boolean selectable = false;

	private final List<T> selectedList = new ArrayList<T>();

	private ActionForm<T> form;

	/**
	 * 
	 * @param id The panel id
	 * @param tableId The tableId
	 * @param provider The data provider for the table which includes the input data
	 * @param columns The columns of the table provided by a list
	 * @param rowsPerPage Amount of rows shown per page
	 */
	public DataTablePanel(String panelId, String tableId, AbstractDataProvider<T> provider, int rowsPerPage,
			List<IColumn<T>> columns, boolean selectable) {
		super(panelId);

		this.provider = provider;
		this.tableId = tableId;
		this.selectable = selectable;
		this.rowsPerPage = rowsPerPage;
		this.columns = columns;
		addCheckBoxColumn(columns);

		add(new StyleSheetReference("dataTableStylesheet", new ResourceReference(DataTablePanel.class,
				"DataTablePanel.css")));

		final DataTable table = createTable();

		form = new ActionForm<T>("tableSelectionForm") {
			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				if (getAction() != null) {
					for (T object : selectedList) {
						getAction().setContext(object);
						getAction().doAction();
					}
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
					page.ajaxRequestReceived(target, modelObject, EventType.CONTRIBUTION_EDIT_EVENT);
				}
			}
		};
		return dataTable;
	}

	private void addCheckBoxColumn(List<IColumn<T>> columns) {
		if (!selectable) {
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

	public ActionForm getActionForm() {
		return form;
	}
	
	public AbstractDataProvider getDataProvider() {
		return provider;
	}

}
