package net.form105.web.impl.panel.contribution;

import net.form105.rm.base.model.user.User;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

public class UserContributionPanel extends Panel {

	private static final long serialVersionUID = 1L;
	
	private boolean editable;
	private User user;

	public UserContributionPanel(String id, User user, boolean editable) {
		super(id);
		this.editable = editable;
		this.user = user;
		
		LoginForm form = new LoginForm("userContributionForm");
		form.add(createLoginButton("saveButton", "button.save"));
		add(form);
	}
	
	public UserContributionPanel(String id, User user) {
		this(id, user, false);
	}
	
	
	protected class LoginForm extends Form {

		private static final long serialVersionUID = 1L;

		public LoginForm(String name) {
			super(name, new CompoundPropertyModel(user));

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
	}
	
	public Button createLoginButton(String id, String resource) {
		Button button = new Button(id, new ResourceModel(resource)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				
			}
			
			@Override
			public boolean isVisible() {
				return editable;
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
	
	public AttributeModifier addReadonlyAttribute() {
		AttributeModifier attModifier = new AttributeModifier("readonly", ! editable, new Model("readonly"));
		return attModifier;
	}
	
	

}
