package net.form105.web.impl.action;

import net.form105.rm.base.service.IResult;
import net.form105.web.base.action.IAjaxLinkToPanelAction;

import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;

public class IconContributionAction implements IAjaxLinkToPanelAction {
	
	private static final long serialVersionUID = 1L;
	private String id = "DEFAULT_ICON_CONTRIBUTION_ACTION";
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
		return null;
	}

	@Override
	public String getId() {
		return id;
	}
	
	public String getClassAttributeValue() {
		return classAttributeValue;
	}

}
