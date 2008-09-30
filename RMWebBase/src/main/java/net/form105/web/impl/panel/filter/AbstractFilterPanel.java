package net.form105.web.impl.panel.filter;

import net.form105.web.base.model.filter.AbstractFilterSequence;
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
 * html: <div class="filterContent" />
 * 
 * @author heiko
 *
 * @param <T>
 * @param <V>
 */
public abstract class AbstractFilterPanel<I, C> extends Panel {

	private static final long serialVersionUID = 1L;
	
	private Form form;
	private AbstractFilterSequence<I> filterSequence;

	public AbstractFilterPanel(String id, AbstractUIFilter<I, C> filter, AbstractFilterSequence<I> filterSequence) {
		super(id);
		
		this.filterSequence = filterSequence;
		
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
		this(id, null, null);
	}
	
	protected Form getForm() {
		return form;
	}
	
	/**
	 * On form submit register the filter in session context and reloads the page.
	 */
	protected abstract void onFormSubmit();
	
	/**
	 * Accessing the filterSequence to save and access filters.
	 * @return
	 */
	protected AbstractFilterSequence<I> getFilterSequence() {
		return filterSequence;
	}
	
}
