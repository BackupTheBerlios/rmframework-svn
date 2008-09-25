package net.form105.web.impl.panel.filter;

import net.form105.web.base.model.filter.AbstractUIFilter;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * This is the abstract implementation for all UI filters. It predefines a form and the submit
 * action that will save the filter to 
 * 
 * Important Ids used in the html context:
 * 
 * form: #filterConfigurationForm
 * The id used for all filter forms
 * 
 * @author heiko
 *
 * @param <T>
 * @param <V>
 */
public abstract class AbstractFilterPanel<T, V> extends Panel {

	private static final long serialVersionUID = 1L;
	
	private Form form;

	public AbstractFilterPanel(String id, AbstractUIFilter<T, V> filter) {
		super(id);
		
		form = new Form("filterConfigurationForm") {
			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				onFormSubmit();
			}
		};
		add(form);
		
	}
	
	/**
	 * This constructor is used for the NoFilterPanel which is a placeholder for the ajaxified
	 * filter panels.
	 * @param id
	 */
	public AbstractFilterPanel(String id) {
		this(id, null);
	}
	
	protected Form getForm() {
		return form;
	}
	
	protected void saveFilter() {
		
	}
	
	protected abstract void onFormSubmit();
	
}
