package net.form105.web.impl.page.userManagement;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.FindAllDaoQuery;
import net.form105.rm.base.query.LocalQueryHandler;
import net.form105.rm.base.service.IResult;
import net.form105.web.base.IAuthenticatedPage;
import net.form105.web.base.type.AjaxEventType;
import net.form105.web.impl.page.template.ConfigurationTemplate;
import net.form105.web.impl.panel.DataTablePanel;
import net.form105.web.impl.panel.contribution.NoContributionPanel;
import net.form105.web.impl.panel.contribution.UserContributionPanel;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.apache.wicket.model.Model;

//TODO: implement IAuthenticatedPage
@AuthorizeInstantiation("admin")
public class UsersPage extends ConfigurationTemplate implements IAuthenticatedPage {

	UserDataProvider provider;

	Panel contributionPanel;

	public UsersPage() {
		super();
		add(new StyleSheetReference("styleSheetUsers", new ResourceReference(UsersPage.class, "UsersPage.css")));

		provider = new UserDataProvider(createData());

		DataTablePanel tablePanel = new DataTablePanel("panel.userTable", "userTable", provider, createColumns(), 20);

		add(tablePanel);

		contributionPanel = new NoContributionPanel("panel.noContribution");
		contributionPanel.setOutputMarkupId(true);
		add(contributionPanel);

	}

	private List<User> createData() {
		LocalQueryHandler<User> queryHandler = new LocalQueryHandler<User>();
		FindAllDaoQuery<User> query = new FindAllDaoQuery<User>(XMLUserObjectDAO.class);
		queryHandler.executeQuery(query);
		IResult<User> result = queryHandler.getResult();
		List<User> users = result.getResultList();
		return users;
	}

	private List<IColumn> createColumns() {

		ArrayList<IColumn> list = new ArrayList<IColumn>();
		list.add(new PropertyColumn(new Model("Id"), "id"));
		list.add(new PropertyColumn(new Model("EMail"), UserDataProvider.SortColumnId.EMAIL.name(), "eMail"));
		list.add(new PropertyColumn(new Model("Shortname"), UserDataProvider.SortColumnId.SHORTNAME.name(), "shortName"));
		list.add(new PropertyColumn(new Model("Sir Name"), UserDataProvider.SortColumnId.SIRNAME.name(), "sirName"));
		list.add(new PropertyColumn(new Model("First Name"), "firstName"));
		return list;

	}

	public void ajaxRequestReceived(AjaxRequestTarget target, Object modelObject, AjaxEventType type) {
		if (type == AjaxEventType.DOUBLE_CLICK) {
			User user = (User) modelObject;
			UserContributionPanel panel = new UserContributionPanel("panel.noContribution", user);
			panel.setOutputMarkupId(true);
			contributionPanel.replaceWith(panel);
			contributionPanel = panel;
			target.addComponent(panel);
		}
	}

}
