package net.form105.web.impl.action;

import net.form105.rm.base.service.IResult;
import net.form105.web.base.action.IAjaxLinkToPanelAction;
import net.form105.web.base.page.BasePage;

import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;

public class ContributionAddUserAction implements IAjaxLinkToPanelAction {
	
	private Page thisPage;
	
	public ContributionAddUserAction(Page thisPage) {
		this.thisPage = thisPage;
	}

	@Override
	public IResult doAction() {

		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
