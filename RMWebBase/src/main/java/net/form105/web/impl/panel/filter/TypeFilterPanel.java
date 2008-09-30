package net.form105.web.impl.panel.filter;

import java.util.List;

import net.form105.web.base.model.filter.AbstractFilterSequence;
import net.form105.web.base.model.filter.AbstractUIFilter;
import net.form105.web.base.model.filter.TypeFilter;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.ResourceModel;

public class TypeFilterPanel<I> extends AbstractFilterPanel<I, List<String>> {
	


	public TypeFilterPanel(String id, TypeFilter<I> filter, AbstractFilterSequence<I> filterSequence, List<String> inputList) {
		super(id, filter, filterSequence);

		
		CompoundPropertyModel model = new CompoundPropertyModel(filter);
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
		// TODO Auto-generated method stub
		
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
