package net.form105.web.base.page.login;

import net.form105.web.base.action.AuthenticationAction;
import net.form105.web.base.component.login.authorize.DefaultUser;
import net.form105.web.base.template.DefaultMainTemplate;

import org.apache.log4j.Logger;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

/**
 * @author hk
 */
public class LoginPage extends DefaultMainTemplate {

	public static Logger logger = Logger.getLogger(LoginPage.class);

	private static final long serialVersionUID = 1L;

	private DefaultUser user = new DefaultUser();

	public LoginPage() {

		LoginForm loginForm = new LoginForm("loginForm");
		loginForm.add(createLoginButton("saveButton", "button.login"));

		add(loginForm);
		add(new Image<String>("loginLogo"));
		add(new StyleSheetReference("styleSheet", new ResourceReference(LoginPage.class, "LoginPage.css")));

		FeedbackPanel feedback = new FeedbackPanel("warning.input");
		add(feedback);

	}

	public final ResourceReference getMainStyle() {
		return new ResourceReference(LoginPage.class, "LoginPage.css");
	}

	protected class LoginForm extends Form<Void> {

		private static final long serialVersionUID = 1L;

		public LoginForm(String name) {
			super(name, new CompoundPropertyModel<Void>(user));

			RequiredTextField<String> personName = new RequiredTextField<String>("userId");
			personName.setLabel(new Model<String>("usernameField"));
			add(personName);

			PasswordTextField firstName = new PasswordTextField("password");
			firstName.setLabel(new Model<String>("passwordField"));
			add(firstName);

		}

		protected void onSubmit() {
			AuthenticationAction action = new AuthenticationAction(this.getPage(), user.getUserId(), user.getPassword());
			action.doAction();
		}

	}

	/**
	 * Creating the button to check the login
	 * 
	 * @param id
	 *            The wicket button id
	 * @param resource
	 *            The resource bundle key which holds the label of the button
	 * @return The wicket button component
	 */
	public Button<String> createLoginButton(String id, String resource) {
		Button<String> button = new Button<String>(id, new ResourceModel(resource)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				
			}
		};
		return button;
	}

}
