package net.form105.web.base.component.table;

import java.util.List;

import net.form105.web.base.model.provider.AbstractDataProvider;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * A datatable which throws an double-click event when clicking on a row.
 * @author hk
 *
 */
public abstract class ClickableDataTable<T> extends DefaultDataTable<T> {
	
	public static Logger logger = Logger.getLogger(ClickableDataTable.class);

	private static final long serialVersionUID = 1L;
	
	private AbstractDataProvider<T> provider;

	public ClickableDataTable(String id, List<IColumn<T>> columns, AbstractDataProvider<T> dataProvider, int rowsPerPage) {
		super(id, columns, dataProvider, rowsPerPage);
		this.provider = dataProvider;
		
	}

	@Override
	protected Item<T> newRowItem(String id, int index, IModel<T> model) {
		final Item<T> item = super.newRowItem(id, index, model);
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
	
	public AbstractDataProvider<T> getCustomProvider() {
		return provider;
	}
	
	public void addObject(T object) {
		getCustomProvider().addInput(object);
	}
	
	public void removeObject(T object) {
		getCustomProvider().removeInput(object);
	}
	
	public void updateObject(T sourceObject, T targetObject) {
		getCustomProvider().changeInput(sourceObject, targetObject);
	}
	
	

}
