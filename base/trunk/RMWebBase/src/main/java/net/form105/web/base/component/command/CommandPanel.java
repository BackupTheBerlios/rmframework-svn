/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.form105.web.base.component.command;

import java.util.ArrayList;
import java.util.List;

import net.form105.web.base.action.AbstractFormAction;
import net.form105.web.base.action.IAjaxLinkToModalWindowAction;
import net.form105.web.base.action.IAjaxLinkToPanelAction;
import net.form105.web.base.action.IPageAction;
import net.form105.web.base.page.BasePage;
import net.form105.web.base.type.EventType;

import org.apache.log4j.Logger;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * The command panel has a bunch of links which executes actions. The actions
 * can be added by the addAction() or provided by a list of actions in the
 * constructor. Following types of links are implemented:
 * <ul>
 * <li>FormAction</li>
 * <li>AjaxAction</li>
 * </ul>
 * 
 * @author heikok
 * 
 * @param <T>
 */
public class CommandPanel<T> extends Panel {

	private static final long serialVersionUID = 1L;

	public static Logger logger = Logger.getLogger(CommandPanel.class);

	private List<IPageAction> linkList;

	public CommandPanel(String id, List<IPageAction> linkList) {
		super(id);
		this.linkList = linkList;
		add(createListView());
	}

	public CommandPanel(String id) {
		this(id, new ArrayList<IPageAction>());
	}

	@SuppressWarnings("unchecked")
	private ListView createListView() {
		ListView lView = new ListView("commandLabels", linkList) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem item) {
				IPageAction action = (IPageAction) item.getModelObject();
				SubmitLink submitLink;
				if (action instanceof AbstractFormAction) {
					AbstractFormAction<T> formAction = (AbstractFormAction<T>) action;
					submitLink = new SubmitLink("commandLink", formAction.getForm()) {

						private static final long serialVersionUID = 1L;

						public void onSubmit() {
							setResponsePage(this.getPage());
						}
					};

					Label label = new Label("commandLabel", formAction.getName());
					submitLink.add(label);
					item.add(submitLink);

				} else if (action instanceof IAjaxLinkToPanelAction) {
					IAjaxLinkToPanelAction ajaxLinkAction = (IAjaxLinkToPanelAction) action;
					AjaxLink ajaxLink = new AjaxLink("commandLink") {

						private static final long serialVersionUID = 1L;

						@Override
						public void onClick(AjaxRequestTarget target) {
							Page page = getPage();
							((BasePage) page).ajaxRequestReceived(target, null, EventType.ADD_EVENT);

						}

					};
					Label label = new Label("commandLabel", ajaxLinkAction.getName());
					ajaxLink.add(label);
					item.add(ajaxLink);

				} else if (action instanceof IAjaxLinkToModalWindowAction) {
					IAjaxLinkToModalWindowAction ajaxModalAction = (IAjaxLinkToModalWindowAction) action;
					AjaxLink ajaxLink = new AjaxLink("commandLink") {

						private static final long serialVersionUID = 1L;

						@Override
						public void onClick(AjaxRequestTarget target) {
							Page page = getPage();
							((BasePage) page).ajaxRequestReceived(target, null, EventType.ADD_MODAL);
						}
					};
					Label label = new Label("commandLabel", ajaxModalAction.getName());
					ajaxLink.add(label);
					item.add(ajaxLink);
				}
			}
		};
		return lView;
	}

	public void addAction(IPageAction action) {
		this.linkList.add(action);
	}
}
