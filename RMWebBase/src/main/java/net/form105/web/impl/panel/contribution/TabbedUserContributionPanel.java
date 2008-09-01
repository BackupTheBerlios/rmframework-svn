package net.form105.web.impl.panel.contribution;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.type.EventType;

import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class TabbedUserContributionPanel extends AbstractContributionPanel {

	private static final long serialVersionUID = 1L;

	public TabbedUserContributionPanel(String id, final User user, EventType eventType) {
		super(id);

		List<AbstractTab> tabs = new ArrayList<AbstractTab>();

		if (user != null) {
			tabs.add(new AbstractTab(new Model("Show")) {
				private static final long serialVersionUID = 1L;

				public Panel getPanel(String panelId) {
					return new UserContributionPanel(panelId, user, EventType.CONTRIBUTION_SHOW_EVENT);
				}
			});

			tabs.add(new AbstractTab(new Model("Edit")) {
				private static final long serialVersionUID = 1L;

				public Panel getPanel(String panelId) {
					return new UserContributionPanel(panelId, user, EventType.CONTRIBUTION_EDIT_EVENT);
				}
			});
		} else {
			User userToAdd = new User();
			tabs.add(new AbstractTab(new Model("Add")) {
				public Panel getPanel(String panelId) {
					return new UserContributionPanel(panelId, user, EventType.ADD_EVENT);
				}
			});
		}

		add(new AjaxTabbedPanel("tabs", tabs));

	}

}
