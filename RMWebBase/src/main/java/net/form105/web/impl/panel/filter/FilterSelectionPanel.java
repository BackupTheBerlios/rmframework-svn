package net.form105.web.impl.panel.filter;

import java.util.ArrayList;
import java.util.Collection;

import net.form105.rm.base.model.user.User;
import net.form105.web.base.model.filter.AbstractFilterSequence;
import net.form105.web.base.model.filter.AbstractUIFilter;
import net.form105.web.base.model.filter.StringPatternFilter;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

/**
 * The panel which includes the choice component to select a filter. The filters are registered in a 
 * {@link AbstractFilterSequence} and should extend the {@link AbstractUIFilter}. After selection of
 * a filter the panel shows the configurable filter that have been chosen.
 * @author heiko
 *
 * @param <T> The filter configuration class
 */
public class FilterSelectionPanel<T> extends Panel {
	
	public static Logger logger = Logger.getLogger(FilterSelectionPanel.class);

	private static final long serialVersionUID = 1L;
	
	private Model model;
	
	private Panel filterPanel;
	
	public FilterSelectionPanel(String id, AbstractFilterSequence<T> filterSequence) {
		super(id);
		
		add(new Label("filterHeader", new ResourceModel("header.filter.label")));
		
		add(new Label("filterDescriptionForSelection", new ResourceModel("label.description.filter.selection")));

		Form form = new Form("filterForm") {

			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				logger.info("Form submitted");
			}
		};

		Collection<AbstractUIFilter<T,?>> filterList = filterSequence.getFilterAsCollection();
		
		model = new Model();
		final DropDownChoice choice = new DropDownChoice("filterChoice", model, new ArrayList<AbstractUIFilter<T,?>>(filterList), new FilterChoiceRenderer());
		form.add(choice);
		
		choice.add(new AjaxFormComponentUpdatingBehavior("onchange") {

			private static final long serialVersionUID = 1L;

			public void onUpdate(AjaxRequestTarget target) {
				logger.info(choice.getModelObject());
				if (choice.getModelObject() instanceof StringPatternFilter) {
					StringPatternFilter<String> selectedFilter = (StringPatternFilter<String>) choice.getModelObject();
					RegExpressionFilterPanel<String> selectedFilterPanel = new RegExpressionFilterPanel<String>("panel.filterConfiguration", selectedFilter);
					selectedFilterPanel.setOutputMarkupId(true);
					filterPanel.replaceWith(selectedFilterPanel);
					filterPanel = selectedFilterPanel;
					target.addComponent(selectedFilterPanel);
				}
			}
		});
		
		add(form);
		
		filterPanel = new NoFilterPanel<Object>("panel.filterConfiguration");
		filterPanel.setOutputMarkupId(true);
		add(filterPanel);
		
		FeedbackPanel feedback = new FeedbackPanel("warning.input");
		add(feedback);
	}
	
	public class FilterChoiceRenderer implements IChoiceRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Object getDisplayValue(Object object) {
			if (object instanceof AbstractUIFilter) {
				return ((AbstractUIFilter) object).getName();
			}
			return object;
		}

		@Override
		public String getIdValue(Object object, int index) {
			return "Object: "+object+" index: "+index;
		}
		
	}
	
	

	

}
