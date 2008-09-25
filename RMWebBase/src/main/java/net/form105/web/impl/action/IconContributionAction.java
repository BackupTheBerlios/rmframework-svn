package net.form105.web.impl.action;

import net.form105.rm.base.service.IResult;
import net.form105.web.base.action.IAjaxLinkToPanelAction;

import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;

public class IconContributionAction implements IAjaxLinkToPanelAction {
	
	private static final long serialVersionUID = 1L;
	private IModel labelModel;
	private String classAttributeValue;
	
	public IconContributionAction(Page thisPage, IModel labelModel, String classAttributeValue) {
		this.labelModel = labelModel;
		this.classAttributeValue = classAttributeValue;
	}

	@Override
	public IModel getModel() {
		return labelModel;
	}

	@Override
	public IResult doAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getClassAttributeValue() {
		return classAttributeValue;
	}

}
