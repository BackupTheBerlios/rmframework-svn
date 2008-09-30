package net.form105.web.impl.page.userManagement;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.ApplicationSession;
import net.form105.web.base.IAuthenticatedPage;
import net.form105.web.base.action.IModelAction;
import net.form105.web.base.action.IPageAction;
import net.form105.web.base.component.command.CommandPanel;
import net.form105.web.base.component.command.IconPanel;
import net.form105.web.base.component.table.DataTablePanel;
import net.form105.web.base.model.filter.AbstractFilterSequence;
import net.form105.web.base.model.filter.StringPatternFilter;
import net.form105.web.base.model.filter.TypeFilter;
import net.form105.web.base.model.provider.FilterDataProvider;
import net.form105.web.base.template.DefaultMainTemplate;
import net.form105.web.base.type.EventType;
import net.form105.web.impl.action.ContributionAddUserAction;
import net.form105.web.impl.action.IconContributionAction;
import net.form105.web.impl.action.RemoveUserAction;
import net.form105.web.impl.panel.ConfigurationSubMenuPanel;
import net.form105.web.impl.panel.contribution.NoContributionPanel;
import net.form105.web.impl.panel.contribution.TabbedUserContributionPanel;
import net.form105.web.impl.panel.filter.FilterSelectionPanel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

//TODO: implement IAuthenticatedPage
@AuthorizeInstantiation("admin")
public class UsersPage extends DefaultMainTemplate implements IAuthenticatedPage {
	
	private AbstractFilterSequence<User> filterSequence;
	
	private FilterDataProvider<User> filterProvider;

	public UsersPage() {
		super(new ConfigurationSubMenuPanel("panel.subNavigation", "menuItem", UsersPage.class), new NoContributionPanel("panel.contribution"));
		//add(new StyleSheetReference("styleSheetUsers", new ResourceReference(UsersPage.class, "UsersPage.css")));
		
		filterSequence = getFilterSequence();
		
		filterProvider = new UserDataProvider(filterSequence);
		
		DataTablePanel<User> dataTablePanel = new DataTablePanel<User>("panel.userTable", "userTable", filterProvider, 20, createColumns(), true);
		add(dataTablePanel);
		
		ArrayList<IPageAction> commandList = new ArrayList<IPageAction>();
		
		commandList.add(new RemoveUserAction(dataTablePanel.getActionForm(), getString("label.action.remove")));
		commandList.add(new ContributionAddUserAction(getString("label.action.add")));
		CommandPanel<User> commandPanel = new CommandPanel<User>("panel.command", commandList);
		add(commandPanel);
		
		String filterLabel = getString("label.action.filter")+filterSequence.getConfiguredSizeAsString();
		
		ArrayList<IPageAction> iconList = new ArrayList<IPageAction>();
		iconList.add(new IconContributionAction(UsersPage.this, filterLabel, "filterIcon"));
		
		IconPanel iconPanel = new IconPanel("panel.icon", iconList);
		add(iconPanel);
	}

	
	
	private List<IColumn> createColumns() {
		List<IColumn> list = new ArrayList<IColumn>();
		list.add(new PropertyColumn(new Model("Id"), "id"));
		list.add(new TextFilteredPropertyColumn(new Model("EMail"), UserDataProvider.SortColumnId.EMAIL.name(), "eMail"));
		list.add(new PropertyColumn(new Model("Shortname"), UserDataProvider.SortColumnId.SHORTNAME.name(),	"shortName"));
		list.add(new PropertyColumn(new Model("Sir Name"), UserDataProvider.SortColumnId.SIRNAME.name(), "sirName"));
		list.add(new PropertyColumn(new Model("First Name"), "firstName"));
		return list;
	}
	
	public void ajaxRequestReceived(AjaxRequestTarget target, Object modelObject, EventType type) {
		User user = null; 
		
		switch (type) {
		case CONTRIBUTION_EDIT_EVENT:
			user = (User) modelObject;
			TabbedUserContributionPanel panel = new TabbedUserContributionPanel("panel.contribution", user, type);
			panel.setOutputMarkupId(true);
			
			getContextPanel().replaceWith(panel);
			contextPanel = panel;
			target.addComponent(panel);
			break;
		case ADD_EVENT:
			TabbedUserContributionPanel addPanel = new TabbedUserContributionPanel("panel.contribution", user, type);
			addPanel.setOutputMarkupId(true);
			getContextPanel().replaceWith(addPanel);
			contextPanel = addPanel;
			target.addComponent(addPanel);
			
		case ADD_FILTER_EVENT:
			logger.info("ADD_FILTER_EVENT occured");
			FilterSelectionPanel<User> filterPanel = new FilterSelectionPanel<User>("panel.contribution", filterSequence, filterProvider);
			filterPanel.setOutputMarkupId(true);
			getContextPanel().replaceWith(filterPanel);
			contextPanel = filterPanel;
			target.addComponent(filterPanel);

		default:
			break;
		}	
	}
	
	public AbstractFilterSequence<User> getFilterSequence() {
		ApplicationSession session = (ApplicationSession) getSession();
		UserFilterSequence sequence = new UserFilterSequence(session.getLookup());
		sequence.add(new StringPatternFilter<User>("USER_EMAIL_FILTER", new UserEmailValue(), getString("filter.name.userEmail")));
		sequence.add(new TypeFilter<User>("ROLE_TYPE_FILTER", new UserRoleValue(), getString("filter.name.userRole")));
		
		return sequence;
	}
	
	
}
