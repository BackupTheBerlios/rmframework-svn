package net.form105.web.impl.panel.contribution;

import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.FindByIdDaoQuery;
import net.form105.rm.base.query.LocalQueryHandler;
import net.form105.rm.base.service.IResult;
import net.form105.web.base.component.contribution.ContributionPanel;
import net.form105.web.base.type.EventType;
import net.form105.web.impl.form.EditUserForm;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.ResourceModel;

public class UserContributionPanel extends ContributionPanel {

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(UserContributionPanel.class);

	public UserContributionPanel(String id, final User selectedUser, EventType eventType) {
		super(id, eventType);

		IModel loadableModel = new LoadableDetachableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected Object load() {
				// working with a copy of the model object
				User backendUser = getUserById(selectedUser.getId());
				return backendUser.getCopy();
			}
		};

		EditUserForm form = new EditUserForm("userContributionForm", loadableModel, eventType);
		form.add(createSaveButton("saveButton", "button.save"));
		add(form);

	}

	public Button createSaveButton(String id, String resource) {
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

	private User getUserById(long userId) {
		LocalQueryHandler<User> queryHandler = new LocalQueryHandler<User>();
		FindByIdDaoQuery<User> query = new FindByIdDaoQuery<User>(XMLUserObjectDAO.class, userId);
		queryHandler.executeQuery(query);
		IResult<User> result = queryHandler.getResult();
		return result.getResultList().get(0);
	}

}
