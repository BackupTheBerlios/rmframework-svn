package net.form105.web.impl.panel.filter;

import net.form105.web.base.HomePage;
import net.form105.web.base.model.filter.StringPatternFilter;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.PageLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.ResourceModel;


public class RegExpressionFilterPanel<T> extends AbstractFilterPanel<T, String> {
	
	public static Logger logger = Logger.getLogger(RegExpressionFilterPanel.class);

	private static final long serialVersionUID = 1L;
	
	public RegExpressionFilterPanel(String id, StringPatternFilter<T> filter) {
		super(id, filter);
		
		

		//getForm().add(new Label("filterDescriptionForRegexFilter", new ResourceModel("label.description.filter.regExpression")));
		
		CompoundPropertyModel model = new CompoundPropertyModel(filter);
		getForm().setModel(model);
		
		
		// id of TextField = wicket:id of html input tag
		TextField regExpressionField = new TextField("configParameter");
		regExpressionField.setLabel(new ResourceModel("label.regexField"));
		getForm().add(regExpressionField);
		
		SubmitLink link = new SubmitLink("link.submitFilter");
		Label label = new Label("label.submitFilter", new ResourceModel("link.label.submit"));
		link.add(label);
		getForm().add(link);
		
		//PageLink bLink = new PageLink("myId", HomePage.class);
		//bLink.add(new Label("filterDescription", new ResourceModel("label.description.filter.regExpression")));
		getForm().add(new Label("filterDescription", new ResourceModel("label.description.filter.regExpression")));
		
		
	}


	@Override
	protected void onFormSubmit() {
		StringPatternFilter<T> filter = (StringPatternFilter<T>) getForm().getModelObject();
		logger.info(filter.getConfigParameter());
		
	}
	
	
	
	

}
