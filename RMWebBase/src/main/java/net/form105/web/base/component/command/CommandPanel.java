package net.form105.web.base.component.command;

import java.util.List;

import net.form105.web.base.action.AbstractFormAction;
import net.form105.web.base.action.IModelAction;
import net.form105.web.base.component.border.BorderedPanel;

import org.apache.log4j.Logger;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

public class CommandPanel<T> extends BorderedPanel {
	
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(CommandPanel.class);
	
	public CommandPanel(String id, List<IModelAction> linkList) {
		super(id);
		
		add(new StyleSheetReference("commandPanelStylesheet", new ResourceReference(CommandPanel.class,"CommandPanel.css")));
		
		ListView lView = new ListView("commandLabels", linkList) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem item) {
				IModelAction action = (IModelAction) item.getModelObject();
				SubmitLink submitLink;
				if (action instanceof AbstractFormAction) {
					AbstractFormAction<T> formAction = (AbstractFormAction<T>) action;
					submitLink = new SubmitLink("commandLink", formAction.getForm());
					
					Label label = new Label("commandLabel", formAction.getModel());
					submitLink.add(label);
					item.add(submitLink);
				} 
			}
		};
		add(lView);	
	}
}
