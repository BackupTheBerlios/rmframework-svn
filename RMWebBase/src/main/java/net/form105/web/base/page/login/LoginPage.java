package net.form105.web.base.page.login;


import net.form105.web.base.model.DefaultLoginModel;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

/**
 * @author heiko
 */
public class LoginPage extends WebPage<Void> {
	
	public static Logger logger = Logger.getLogger(LoginPage.class);
	
	private static final long serialVersionUID = 1L;

	public LoginPage() {

		LoginForm loginForm = new LoginForm("loginForm");
		
		loginForm.add(createLoginButton("saveButton", "button.login"));
		
		add(loginForm);
		add(new Image<String>("loginLogo"));
		
		add(new StyleSheetReference("styleSheet", this.getClass(), "LoginPage.css"));
		
		
	}
	
	protected class LoginForm extends Form {

        public LoginForm(String name) {
            super(name, new CompoundPropertyModel<Void>(new DefaultLoginModel()));
            
            RequiredTextField<String> personName = new RequiredTextField<String>("username");
            personName.setLabel(new Model<String>("usernameField"));
            add(personName);

            PasswordTextField firstName = new PasswordTextField("password");
            firstName.setLabel(new Model("passwordField"));
            add(firstName);

        }

        protected void onSubmit() {
            logger.info("Form.onSubmit executed");
        }
        
    }
	
	public Button createLoginButton(String id, String resource) {
		Button button = new Button(id, new ResourceModel(resource)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				logger.info("login button pressed");
			}
		};
		return button;
	}

}

