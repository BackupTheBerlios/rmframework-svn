package net.form105.web.impl.action;

import net.form105.rm.base.service.IResult;
import net.form105.web.base.action.IAjaxLinkToPanelAction;

import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;

public class IconContributionAction implements IAjaxLinkToPanelAction {
	
	private static final long serialVersionUID = 1L;
	private String id = "DEFAULT_ICON_CONTRIBUTION_ACTION";
	private String name;
	private String classAttributeValue;
	
	public IconContributionAction(Page thisPage, String name, String classAttributeValue) {
		this.name = name;
		this.classAttributeValue = classAttributeValue;
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



	@Override
	public String getName() {
		return name;
	}

}
