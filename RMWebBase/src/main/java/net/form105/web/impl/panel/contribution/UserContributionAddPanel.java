package net.form105.web.impl.panel.contribution;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.type.EventType;
import net.form105.web.impl.form.AddUserForm;

import org.apache.log4j.Logger;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class UserContributionAddPanel extends ContributionPanel {
	
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(UserContributionAddPanel.class);
	
	public UserContributionAddPanel(String id, EventType eventType) {
		super(id, eventType);
		
		IModel loadableModel = new LoadableDetachableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected Object load() {
				return new User();
			}
		};
		
		AddUserForm form = new AddUserForm("userContributionAddForm", loadableModel, eventType);
		form.add(createButton("submitButton", "button.create"));
		add(form);
		
	}

}
