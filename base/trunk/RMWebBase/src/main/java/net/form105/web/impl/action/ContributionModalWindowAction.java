package net.form105.web.impl.action;

import org.apache.wicket.MarkupContainer;

import net.form105.rm.base.service.IResult;
import net.form105.web.base.action.IAjaxLinkToModalWindowAction;
import net.form105.web.base.action.IAjaxLinkToPanelAction;

public class ContributionModalWindowAction extends AbstractAction implements IAjaxLinkToModalWindowAction {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public ContributionModalWindowAction(MarkupContainer markup, String name) {
		super(markup);
		this.name = name;
	}

	@Override
	public IResult doAction() {
		
		return null;
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

}
