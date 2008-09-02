package net.form105.web.impl.panel.contribution;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.type.EventType;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;

public class ContributionPanel extends Panel {
	
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

}
