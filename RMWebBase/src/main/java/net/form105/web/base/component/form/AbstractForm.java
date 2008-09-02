package net.form105.web.base.component.form;

import net.form105.web.base.type.EventType;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class AbstractForm extends Form {

	private static final long serialVersionUID = 1L;
	
	private EventType eventType;
	
	public AbstractForm(String id, IModel model, EventType eventType) {
		super(id, model);
		this.eventType = eventType;
	}
	
	public AttributeModifier addReadonlyAttribute() {
		boolean readonly = (eventType == EventType.CONTRIBUTION_SHOW_EVENT);
		AttributeModifier attModifier = new AttributeModifier("readonly", readonly, new Model("readonly"));
		return attModifier;
	}

	
	

}
