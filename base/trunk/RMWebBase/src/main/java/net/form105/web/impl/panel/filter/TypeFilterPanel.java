package net.form105.web.impl.panel.filter;

import java.util.List;

import net.form105.web.base.model.filter.AbstractFilterSequence;
import net.form105.web.base.model.filter.AbstractUIFilter;
import net.form105.web.base.model.filter.TypeFilter;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.ResourceModel;

public class TypeFilterPanel<I> extends AbstractFilterPanel<I, List<String>> {
	
	public static Logger logger = Logger.getLogger(TypeFilterPanel.class);
	


	public TypeFilterPanel(String id, TypeFilter<I> filter, AbstractFilterSequence<I> filterSequence, List<String> inputList) {
		super(id, filter, filterSequence);

		// Using the saved filter if there is one configured before
		AbstractUIFilter<I, ?> savedFilter = filterSequence.getConfiguredFilter(filter.getId());
		CompoundPropertyModel model;
		if (savedFilter != null) {
			model = new CompoundPropertyModel(savedFilter);
		} else {
			model = new CompoundPropertyModel(filter);
		}
		getForm().setModel(model);
		
		ListMultipleChoice mChoice = new ListMultipleChoice("configParameter", inputList);
		int rowSize = 5;
		if (inputList.size() < 5 ) {
			rowSize = inputList.size();
		}
		
		mChoice.setMaxRows(rowSize);
		getForm().add(mChoice);
		
		
		SubmitLink link = new SubmitLink("link.submitFilter");
		Label label = new Label("label.submitFilter", new ResourceModel("link.label.submit"));
		link.add(label);
		getForm().add(link);
		
		
		getForm().add(new Label("filterDescription", new ResourceModel("label.description.filter.type")));
		
	}

	private static final long serialVersionUID = 1L;

	protected void onFormSubmit() {
		TypeFilter<I> filter = (TypeFilter<I>) getForm().getModelObject();
		if (filter.getConfigParameter().size() == 0) return;
		getFilterSequence().save(filter);
		setResponsePage(getPage().getClass());
		
	}
	
	private class FilterChoiceRenderer implements IChoiceRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Object getDisplayValue(Object object) {
			logger.info(object);
			return object;
		}

		@Override
		public String getIdValue(Object object, int index) {
			logger.info(object+":"+index);
			return "Object: "+object+" index: "+index;
		}
		
	}

}
