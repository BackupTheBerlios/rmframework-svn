package net.form105.web.impl.page.userManagement;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.IAuthenticatedPage;
import net.form105.web.base.action.IModelAction;
import net.form105.web.base.component.command.CommandPanel;
import net.form105.web.base.component.table.DataTablePanel;
import net.form105.web.base.template.DefaultMainTemplate;
import net.form105.web.impl.action.ContributionAddUserAction;
import net.form105.web.impl.action.RemoveUserAction;
import net.form105.web.impl.page.resources.AllResourcesPage;
import net.form105.web.impl.panel.ConfigurationSubMenuPanel;
import net.form105.web.impl.panel.contribution.NoContributionPanel;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

//TODO: implement IAuthenticatedPage
@AuthorizeInstantiation("admin")
public class UsersPage extends DefaultMainTemplate implements IAuthenticatedPage {




	public UsersPage() {
		super(new ConfigurationSubMenuPanel("panel.subNavigation", "menuItem", AllResourcesPage.class), new NoContributionPanel("panel.contribution"));
		//add(new StyleSheetReference("styleSheetUsers", new ResourceReference(UsersPage.class, "UsersPage.css")));
		
		DataTablePanel<User> dataTablePanel = new DataTablePanel<User>("panel.userTable", "userTable", new UserDataProvider(), 20, createColumns(), true);
		add(dataTablePanel);
		
		ArrayList<IModelAction> commandList = new ArrayList<IModelAction>();
		commandList.add(new RemoveUserAction(dataTablePanel.getActionForm(), new ResourceModel("label.action.remove")));
		commandList.add(new ContributionAddUserAction(UsersPage.this, new ResourceModel("label.action.add")));
		CommandPanel commandPanel = new CommandPanel("panel.command", commandList);
		add(commandPanel);
		
		
		

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
}
