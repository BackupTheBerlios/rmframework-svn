/**
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
 

package net.form105.web.impl.panel.contribution;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.component.contribution.AbstractContributionPanel;
import net.form105.web.base.type.EventType;

import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;


public class TabbedUserContributionPanel extends AbstractContributionPanel {

	private static final long serialVersionUID = 1L;

	public TabbedUserContributionPanel(String id, final User user, EventType eventType) {
		super(id, new ResourceModel("header.context"));

		List<AbstractTab> tabs = new ArrayList<AbstractTab>();

		if (user != null) {
			tabs.add(new AbstractTab(new ResourceModel("tab.label.show")) {
				private static final long serialVersionUID = 1L;

				public Panel getPanel(String panelId) {
					return new UserContributionPanel(panelId, user, EventType.CONTRIBUTION_SHOW_EVENT);
				}
			});

			tabs.add(new AbstractTab(new ResourceModel("tab.label.edit")) {
				private static final long serialVersionUID = 1L;

				public Panel getPanel(String panelId) {
					return new UserContributionPanel(panelId, user, EventType.CONTRIBUTION_EDIT_EVENT);
				}
			});
		} else {
			tabs.add(new AbstractTab(new ResourceModel("tab.label.add")) {
				public Panel getPanel(String panelId) {
					return new UserContributionAddPanel(panelId, EventType.ADD_EVENT);
				}
			});
		}

		add(new AjaxTabbedPanel("tabs", tabs));
		
		FeedbackPanel feedback = new FeedbackPanel("warning.input");
		add(feedback);

	}

}
