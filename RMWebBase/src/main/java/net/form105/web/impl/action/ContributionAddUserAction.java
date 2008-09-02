package net.form105.web.impl.action;

import net.form105.rm.base.service.IResult;
import net.form105.web.base.action.IAjaxLinkToPanelAction;
import net.form105.web.base.page.BasePage;

import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;

public class ContributionAddUserAction implements IAjaxLinkToPanelAction {
	
	private Page thisPage;
	private IModel model;
	
	public ContributionAddUserAction(Page thisPage, IModel model) {
		this.thisPage = thisPage;
		this.model = model;
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
		return model;
	}

	
	
}
