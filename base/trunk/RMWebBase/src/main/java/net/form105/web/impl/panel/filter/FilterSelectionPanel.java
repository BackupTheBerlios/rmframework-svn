package net.form105.web.impl.panel.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import net.form105.web.base.behaviour.IconAttributeAppender;
import net.form105.web.base.model.filter.AbstractFilterSequence;
import net.form105.web.base.model.filter.AbstractUIFilter;
import net.form105.web.base.model.filter.IValue;
import net.form105.web.base.model.filter.StringPatternFilter;
import net.form105.web.base.model.filter.TypeFilter;
import net.form105.web.base.model.provider.FilterDataProvider;
import net.form105.web.impl.action.ResetFilterAction;

import org.apache.log4j.Logger;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.link.Link;
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
 * @param <T> The input class for the filter
 */
public class FilterSelectionPanel<I> extends Panel {
	
	public static Logger logger = Logger.getLogger(FilterSelectionPanel.class);

	private static final long serialVersionUID = 1L;
	
	private Model model;
	
	private Panel filterPanel;
	private final Page targetPage; 
	
	
	
	
	public FilterSelectionPanel(String id, final AbstractFilterSequence<I> filterSequence, final FilterDataProvider<I> provider, Page page) {
		super(id);
		this.targetPage = page;
		
		add(new Label("filterHeader", new ResourceModel("header.filter.label")));
		
		add(new Label("filterDescriptionForSelection", new ResourceModel("label.description.filter.selection")));

		Form form = new Form("filterForm") {
			private static final long serialVersionUID = 1L;
		};
		add(form);
		
		// Creating action and Link
		final ResetFilterAction action = new ResetFilterAction(this, getString("label.link.resetFilter"), page, filterSequence.getClass());
		Link resetFilterLink = new Link("iconLink") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				action.doAction();
				setResponsePage(targetPage.getClass());
			}

			public boolean isVisible()
			{
				return (filterSequence.getConfiguredFilters().size() > 0);
			}
			
		};
		resetFilterLink.add(new IconAttributeAppender("resetIcon"));
	
		Label label = new Label("iconLabel", action.getName());
		resetFilterLink.add(label);
		form.add(resetFilterLink);

		Collection<AbstractUIFilter<I,?>> filterList = filterSequence.getFilterAsCollection();
		
		model = new Model();
		final DropDownChoice choice = new DropDownChoice("filterChoice", model, new ArrayList<AbstractUIFilter<I,?>>(filterList), new FilterChoiceRenderer(filterSequence));
		form.add(choice);
		
		choice.add(new AjaxFormComponentUpdatingBehavior("onchange") {

			private static final long serialVersionUID = 1L;

			public void onUpdate(AjaxRequestTarget target) {
				logger.info(choice.getModelObject());
				if (choice.getModelObject() instanceof StringPatternFilter) {
					StringPatternFilter<I> sPatternFilter = (StringPatternFilter<I>) choice.getModelObject();
					RegExpressionFilterPanel<I> selectedFilterPanel = new RegExpressionFilterPanel<I>("panel.filterConfiguration", sPatternFilter, filterSequence);
					selectedFilterPanel.setOutputMarkupId(true);
					filterPanel.replaceWith(selectedFilterPanel);
					filterPanel = selectedFilterPanel;
					target.addComponent(selectedFilterPanel);
				} else if (choice.getModelObject() instanceof TypeFilter) {
					TypeFilter<I> typeFilter = (TypeFilter<I>) choice.getModelObject();

					TreeSet<String> typeSet = new TreeSet<String>();
					IValue<List<String>, I> value = typeFilter.getValue();
					List<I> input = provider.getInput();
					for (I object : input) {
						List<String> inputList = value.getValue(object);
						for (String iS : inputList) {
							typeSet.add(iS);
						}
						
					}
					
					TypeFilterPanel<I> typeFilterPanel = new TypeFilterPanel<I>("panel.filterConfiguration", typeFilter, filterSequence, new ArrayList<String>(typeSet));
					typeFilterPanel.setOutputMarkupId(true);
					filterPanel.replaceWith(typeFilterPanel);
					filterPanel = typeFilterPanel;
					target.addComponent(typeFilterPanel);
				}
			}
		});
		
		
		
		filterPanel = new NoFilterPanel<Object>("panel.filterConfiguration");
		filterPanel.setOutputMarkupId(true);
		add(filterPanel);
		
		FeedbackPanel feedback = new FeedbackPanel("warning.input");
		add(feedback);
	}
	
	public class FilterChoiceRenderer implements IChoiceRenderer {

		private static final long serialVersionUID = 1L;
		private AbstractFilterSequence filterSequence;
		
		public FilterChoiceRenderer(AbstractFilterSequence filterSequence) {
			this.filterSequence = filterSequence;
		}

		@Override
		public Object getDisplayValue(Object object) {
			if (object instanceof AbstractUIFilter) {
				AbstractUIFilter filter = (AbstractUIFilter) object;
				if (filterSequence.getConfiguredFilter(filter.getId()) != null) {
					return filter.getName() + " (*)";
				}
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
