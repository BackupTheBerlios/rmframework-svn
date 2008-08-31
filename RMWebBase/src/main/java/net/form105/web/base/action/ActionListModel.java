package net.form105.web.base.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.wicket.model.IModel;

public class ActionListModel implements IModel {
	
	public static Logger logger = Logger.getLogger(ActionListModel.class);
	
	private static final long serialVersionUID = 1L;
	
	private List<IPageAction> actions;

	public ActionListModel(List<IPageAction> pageActions) {
		this.actions = pageActions;
	}

	@Override
	public Object getObject() {
		return actions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setObject(Object object) {
		if (object instanceof IPageAction) {
			actions = (List<IPageAction>) object;
		} else {
			logger.error("Object is not of the generic type: IPageAction");
		}
	}

	@Override
	public void detach() {}

}
