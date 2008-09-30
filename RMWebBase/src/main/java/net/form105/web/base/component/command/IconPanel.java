package net.form105.web.base.component.command;

import java.util.List;

import net.form105.web.base.action.IModelAction;
import net.form105.web.base.page.BasePage;
import net.form105.web.base.type.EventType;
import net.form105.web.impl.action.IconContributionAction;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class IconPanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	public IconPanel(String id, List<IModelAction> linkList) {
		super(id);
		
		ListView lView = new ListView("iconLinks", linkList) {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem item) {
				
				
				IModelAction action = (IModelAction) item.getModelObject();
				
				if (action instanceof IconContributionAction) {
					IconContributionAction contribAction = (IconContributionAction) action;
					
					AjaxLink ajaxLink = new AjaxLink("iconLink", contribAction.getModel()) {
					
						private static final long serialVersionUID = 1L;

						@Override
						public void onClick(AjaxRequestTarget target) {
							Page page = getPage();
							((BasePage) page).ajaxRequestReceived(target, null, EventType.ADD_FILTER_EVENT);
						};
					};
					
					AttributeAppender attModifier = new AttributeAppender("class", true, new Model(contribAction.getClassAttributeValue()), " ");
					item.add(attModifier);
					
					Label label = new Label("iconLabel", contribAction.getModel());
					ajaxLink.add(label);
					item.add(ajaxLink);
				}
				
			}
			
		};
		
		add(lView);
		
	}

}
