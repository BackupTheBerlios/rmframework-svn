package net.form105.web.base.component.contribution;

import net.form105.web.base.type.EventType;
import net.form105.web.impl.panel.contribution.UserContributionAddPanel;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.ResourceModel;

public abstract class ContributionPanel extends Panel {
	
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(UserContributionAddPanel.class);
	
	private EventType eventType;
	
	public ContributionPanel(String id, EventType eventType) {
		super(id);
		this. eventType = eventType;
		
		
	}
	
	public EventType getEventType() {
		return eventType;
	}
	
	public Button createButton(String id, String resource) {
		Button button = new Button(id, new ResourceModel(resource)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
			}

			@Override
			public boolean isVisible() {
				boolean isEditEvent = (getEventType() == EventType.CONTRIBUTION_EDIT_EVENT);
				boolean isAddEvent = (getEventType() == EventType.ADD_EVENT);
				boolean isVisible = (isEditEvent || isAddEvent);
				return isVisible;
			}
		};
		return button;
	}
	
	protected abstract Object getLoadableObject();
	
	protected IModel getLoadableModel() {
		IModel loadableModel = new LoadableDetachableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected Object load() {
				return getLoadableObject();
			}
		};
		return loadableModel;
	}

}
