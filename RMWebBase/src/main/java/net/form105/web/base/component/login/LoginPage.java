package net.form105.web.base.component.login;


import net.form105.web.base.model.DefaultLoginModel;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

/**
 * @author heiko
 */
public class LoginPage extends WebPage {
	
	private static final long serialVersionUID = 1L;

	public LoginPage() {
		LoginForm loginForm = new LoginForm("loginForm");
		add(loginForm);
		loginForm.add(new Button<String>("saveButton"));
		
	}
	
	protected class LoginForm extends Form {

        public LoginForm(String name) {
            super(name, new CompoundPropertyModel(new DefaultLoginModel()));
            
            RequiredTextField personName = new RequiredTextField("username");
            personName.setLabel(new Model("usernameField"));
            add(personName);

            PasswordTextField firstName = new PasswordTextField("password");
            firstName.setLabel(new Model("passwordField"));
            add(firstName);

        }

        protected void onSubmit() {
            info("Form.onSubmit executed");
        }
        
    }

}

