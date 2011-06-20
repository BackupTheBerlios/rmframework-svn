package net.form105.web.impl.action;

import net.form105.web.base.action.IPageAction;

import org.apache.wicket.MarkupContainer;

/**
 * The AbstractAction provides a way to access the MarkupContainer. It is used to identify the action in
 * the action registry.
 * @author heikok
 *
 */
public abstract class AbstractAction implements IPageAction {
	
	private static final long serialVersionUID = 1L;
	
	private MarkupContainer markupContainer;
	
	public AbstractAction(MarkupContainer markupContainer) {
		this.markupContainer = markupContainer;
	}
	
	protected MarkupContainer getMarkupContainer() {
		return markupContainer;
	}

}
