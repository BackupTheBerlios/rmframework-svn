package net.form105.web.impl.action;

import net.form105.rm.base.service.IResult;
import net.form105.web.base.action.IAjaxLinkToPanelAction;

public class ContributionAddUserAction implements IAjaxLinkToPanelAction {
	
	private static final long serialVersionUID = 1L;
	private String name;
	
	public ContributionAddUserAction(String name) {
		this.name = name;
	}

	@Override
	public IResult<?> doAction() {

		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	
	
}
