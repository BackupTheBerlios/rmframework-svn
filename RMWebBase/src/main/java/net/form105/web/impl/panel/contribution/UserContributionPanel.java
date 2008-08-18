package net.form105.web.impl.panel.contribution;

import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.FindByIdDaoQuery;
import net.form105.rm.base.query.LocalQueryHandler;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.LocalServiceHandler;
import net.form105.rm.base.service.Status;
import net.form105.rm.server.service.UpdateUserService;

import org.apache.log4j.Logger;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

public class UserContributionPanel extends Panel {

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(UserContributionPanel.class);

	private boolean editable;
	private User user;

	public UserContributionPanel(String id, final User selectedUser, boolean editable) {
		super(id);
		this.user = selectedUser;
		this.editable = editable;
		
		logger.info(user);

		
		IModel model = new LoadableDetachableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected Object load() {
				// working with a copy of the model object
				User backendUser = getUserById(selectedUser.getId());
				return backendUser.getCopy();
			}
			
		};
		
		LoginForm form = new LoginForm("userContributionForm", model);
		form.add(createSaveButton("saveButton", "button.save"));
		add(form);
		
	}
	

	protected class LoginForm extends Form {

		private static final long serialVersionUID = 1L;

		public LoginForm(String name, IModel model) {
			//super(name, new CompoundPropertyModel(oldUser));
			
			super(name, new CompoundPropertyModel(model));

			TextField userId = new TextField("id");
			userId.setLabel(new Model("userId"));
			userId.add(new FocusOnLoadBehavior());
			userId.add(addReadonlyAttribute());
			add(userId);

			TextField email = new TextField("eMail");
			email.setLabel(new Model("userEmail"));
			email.add(addReadonlyAttribute());
			add(email);

			TextField sirName = new TextField("sirName");
			sirName.setLabel(new Model("userSirName"));
			sirName.add(addReadonlyAttribute());
			add(sirName);

			TextField firstName = new TextField("firstName");
			firstName.setLabel(new Model("userFirstName"));
			firstName.add(addReadonlyAttribute());
			add(firstName);

			TextField shortName = new TextField("shortName");
			shortName.setLabel(new Model("userShortName"));
			shortName.add(addReadonlyAttribute());
			add(shortName);
		}

		protected void onSubmit() {
			User user = (User) getModelObject();
			
			LocalServiceHandler handler = new LocalServiceHandler();
			UpdateUserService uService = new UpdateUserService();
			UpdateUserService.ServiceArgument arg = uService.getArgument();
			arg.id = user.getId();
			arg.firstName = user.getFirstName();
			arg.email = user.getEMail();
			arg.isAdmin = user.isAdmin();
			arg.name = user.getSirName();
			arg.password = user.getPassword();
			arg.shortName = user.getShortName();
			handler.executeService(uService);
			if (handler.getResult().getStatus() == Status.FAIL) {
				// add message to a panel -> model window
				
			}
		}
		
	}

	public Button createSaveButton(String id, String resource) {
		Button button = new Button(id, new ResourceModel(resource)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				// super.onSubmit();
				logger.info("button submitted");
			}

			@Override
			public boolean isVisible() {
				return editable;
			}
		};
		return button;
	}

	public class FocusOnLoadBehavior extends AbstractBehavior {
		private static final long serialVersionUID = 1L;
		private Component component;

		public void bind(Component component) {
			this.component = component;
			component.setOutputMarkupId(true);
		}

		public void renderHead(IHeaderResponse iHeaderResponse) {
			super.renderHead(iHeaderResponse);
			iHeaderResponse
					.renderOnLoadJavascript("document.getElementById('" + component.getMarkupId() + "').focus()");
		}

		public boolean isTemporary() {
			// remove the behavior after component has been rendered
			return true;
		}
	}

	public AttributeModifier addReadonlyAttribute() {
		AttributeModifier attModifier = new AttributeModifier("readonly", !editable, new Model("readonly"));
		return attModifier;
	}
	
	private User getUserById(long userId) {
		LocalQueryHandler<User> queryHandler = new LocalQueryHandler<User>();
		FindByIdDaoQuery<User> query = new FindByIdDaoQuery<User>(XMLUserObjectDAO.class, userId);
		queryHandler.executeQuery(query);
		IResult<User> result = queryHandler.getResult();
		logger.info(result.getResultList().get(0));
		return result.getResultList().get(0);
	}

}
