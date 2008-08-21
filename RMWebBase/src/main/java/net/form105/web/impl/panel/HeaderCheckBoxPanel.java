package net.form105.web.impl.panel;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * This panel is used for editable tables as the select and deselect all component. It works with a javascript
 * which will be called by an ajax request. 
 * @author hk
 *
 */
public class HeaderCheckBoxPanel extends Panel {

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(HeaderCheckBoxPanel.class);
	
	public HeaderCheckBoxPanel(String id) {
		super(id);
		setOutputMarkupId(true);
		//CheckBox checkbox = new CheckBox("selectAllCheckbox", new LocalCheckboxModel());
		AjaxCheckBox checkbox = new AjaxCheckBox("selectAllCheckbox", new LocalCheckboxModel()) {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.appendJavascript(getSelectAllScript(getMarkupId()));
				
			}
		};
		add(checkbox);
	}
	
	/**
	 * Use the wicket internal javascript to access the component you need with <code>wicketGet('markupId')</code>
	 * where markupId can be got by @see getMarkupId() by its component
	 * @param markupId
	 * @return
	 */
	private String getSelectAllScript(String markupId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("var element = wicketGet('"+markupId+"');");
		buffer.append("var form = element.form, z=0;");
		buffer.append("for(z=0; z<form.length;z++){");
		buffer.append("if(form[z].type == 'checkbox' && form[z].name != 'checkall'){");
		buffer.append("form[z].checked = element.checked;");
		buffer.append("}}");
		return buffer.toString();
	}
	
	/**
	 * The model special for the select all checkbox as a model is required by the @see AjaxCheckBox
	 * @author heiko
	 *
	 */
	private class LocalCheckboxModel implements IModel {
		
		private Boolean selected;

		@Override
		public Object getObject() {
			return selected;
		}

		@Override
		public void setObject(Object object) {
			this.selected = (Boolean) object;
			
		}

		@Override
		public void detach() {
			selected = false;
			
		}
		
		
		
	}

}
