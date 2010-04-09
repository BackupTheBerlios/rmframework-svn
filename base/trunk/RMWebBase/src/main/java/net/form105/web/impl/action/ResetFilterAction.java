package net.form105.web.impl.action;

import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.web.base.ApplicationSession;
import net.form105.web.base.action.DefaultActionResult;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.Page;

/**
 * A action which resets filters by removing an entry in the lookup registry.
 * @author heiko
 *
 */
public class ResetFilterAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private final String id = "RESET_FILTER_ACTION";
	private String name;
	private Page page;
	private Class<?> filterClazz;

	public ResetFilterAction(MarkupContainer markup, String name, Page page, Class filterClazz) {
		super(markup);
		this.name = name;
		this.page = page;
		this.filterClazz = filterClazz;
	}

	@Override
	public IResult doAction() {

		DefaultActionResult<Void> actionResult = new DefaultActionResult<Void>();

		try {
			ApplicationSession session = (ApplicationSession) page.getSession();
			ILookup lookup = session.getLookup();
			lookup.removeEntry(filterClazz);
		} catch (Exception ex) {
			actionResult.setException(ex);
			actionResult.setStatus(ResultStatus.FAIL);
			return actionResult;
		}
		
		actionResult.setStatus(ResultStatus.SUCCESS);
		return actionResult;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

}
