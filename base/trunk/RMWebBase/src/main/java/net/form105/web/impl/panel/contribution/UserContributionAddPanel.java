package net.form105.web.impl.panel.contribution;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.component.contribution.ContributionPanel;
import net.form105.web.base.type.EventType;
import net.form105.web.impl.form.AddUserForm;

import org.apache.log4j.Logger;

public class UserContributionAddPanel extends ContributionPanel {
	
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(UserContributionAddPanel.class);
	
	public UserContributionAddPanel(String id, EventType eventType) {
		super(id, eventType);
		
		AddUserForm form = new AddUserForm("userContributionAddForm", getLoadableModel(), eventType);
		form.add(createButton("submitButton", "button.create"));
		add(form);
		
	}
	
	protected Object getLoadableObject() {
		return new User();
	}

}
