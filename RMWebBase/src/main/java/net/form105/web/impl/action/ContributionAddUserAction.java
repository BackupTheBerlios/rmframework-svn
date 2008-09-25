package net.form105.web.impl.action;

import net.form105.rm.base.service.IResult;
import net.form105.web.base.action.IAjaxLinkToPanelAction;

import org.apache.wicket.model.IModel;

public class ContributionAddUserAction implements IAjaxLinkToPanelAction {
	
	private static final long serialVersionUID = 1L;
	private IModel model;
	
	public ContributionAddUserAction(IModel model) {
		this.model = model;
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
	public IModel getModel() {
		return model;
	}

	
	
}
