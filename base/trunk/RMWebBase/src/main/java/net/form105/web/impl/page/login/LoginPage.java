package net.form105.web.impl.page.login;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;
import net.form105.web.base.HomePage;
import net.form105.web.base.action.AuthenticationAction;
import net.form105.web.base.component.login.authorize.DefaultUser;
import net.form105.web.base.template.DefaultPageTemplate;

import org.apache.log4j.Logger;
import org.apache.wicket.Component;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;
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
import org.apache.wicket.model.StringResourceModel;

/**
 * The login page consists of a username and a password field. The user fills out the form and after submitting the
 * login button the <code>AuthorizationAction</code> will be executed. The AuthorizationAction turns back with an
 * <code>IResult</code> which should include a state for success or fail of the authentication process.  
 * @author hk
 */
public class LoginPage extends DefaultPageTemplate {

	public static Logger logger = Logger.getLogger(LoginPage.class);

	private static final long serialVersionUID = 1L;

	private DefaultUser user = new DefaultUser();

	public LoginPage() {

		LoginForm loginForm = new LoginForm("loginForm");
		loginForm.add(createLoginButton("saveButton", "button.login"));

		add(loginForm);
		add(new Image("loginLogo"));
		add(new StyleSheetReference("styleSheetLoginPage", new ResourceReference(LoginPage.class, "LoginPage.css")));

		FeedbackPanel feedback = new FeedbackPanel("warning.input");
		add(feedback);
	}

	protected class LoginForm extends Form {

		private static final long serialVersionUID = 1L;

		public LoginForm(String name) {
			super(name, new CompoundPropertyModel(user));

			RequiredTextField personName = new RequiredTextField("userId");
			personName.setLabel(new Model("usernameField"));
			add(personName);
			personName.add(new FocusOnLoadBehavior());

			PasswordTextField firstName = new PasswordTextField("password");
			firstName.setLabel(new Model("passwordField"));
			add(firstName);

		}

		protected void onSubmit() {
			AuthenticationAction action = new AuthenticationAction(user.getUserId(), user.getPassword());
			IResult<User> result = action.doAction();
			if (result.getStatus() == ResultStatus.SUCCESS) {
				setResponsePage(HomePage.class);
			} else {
				// Gets the instance of this page. Shows the previously typed in user name again in the user name field. 
				setResponsePage(this.getPage());
				StringResourceModel rModel = new StringResourceModel("message.error.notAuthenticated", this.getPage(), this.getModel());
				warn(rModel.getString());
				
				
			}
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
	public Button createLoginButton(String id, String resource) {
		Button button = new Button(id, new ResourceModel(resource)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				
			}
		};
		return button;
	}
	
	public class FocusOnLoadBehavior extends AbstractBehavior
	{
	    private Component component;

	    public void bind( Component component )
	    {
	        this.component = component;
	        component.setOutputMarkupId(true);
	    }

	    public void renderHead( IHeaderResponse iHeaderResponse )
	    {
	        super.renderHead(iHeaderResponse);
	        iHeaderResponse.renderOnLoadJavascript("document.getElementById('" + component.getMarkupId() + "').focus()");
	    }

	    public boolean isTemporary()
	    {
	        // remove the behavior after component has been rendered       
	        return true;
	    }
	}

}
