package net.form105.web.impl.panel;

import java.util.List;

import net.form105.rm.base.model.user.User;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

public abstract class ClickableDataTable extends DefaultDataTable {
	
	public static Logger logger = Logger.getLogger(ClickableDataTable.class);

	private static final long serialVersionUID = 1L;

	public ClickableDataTable(String id, List<?> columns, ISortableDataProvider dataProvider, int rowsPerPage) {
		super(id, columns, dataProvider, rowsPerPage);
	}

	protected Item newRowItem(String id, int index, IModel model) {
		final Item item = super.newRowItem(id, index, model);
		item.add(new AjaxEventBehavior("ondblclick") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onEvent(AjaxRequestTarget target) {
				Object modelObject = item.getModelObject();
				doubleClickEvent(target, modelObject);
			}
			
		});
		return item;
	}
	
	protected abstract void doubleClickEvent(AjaxRequestTarget target, Object modelObject);

}
