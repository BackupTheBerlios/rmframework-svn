package net.form105.web.base.model.provider;

import java.util.ArrayList;
import java.util.List;

import net.form105.web.base.model.filter.AbstractFilterSequence;
import net.form105.web.base.model.filter.AbstractUIFilter;

import org.apache.wicket.model.IModel;

/**
 * The FilterDataProvider gives the feasibility to filter entities from a given input. This class
 * must be derived to implement the important <code>getInput()</code> method which is used by the
 * <code>getFilteredInput()</code> method. Each input object is traversed by the filters if any
 * is registered. 
 * Filters are registered at the {@link AbstractFilterSequence} respectively in the lookup registry.
 * @author heiko
 *
 * @param <T>
 */
public abstract class FilterDataProvider<T> extends AbstractDataProvider<T> {
	
	private static final long serialVersionUID = 1L;
	
	private AbstractFilterSequence<T> filters;

	
	public FilterDataProvider(AbstractFilterSequence<T> filterSequence) {
		this.filters = filterSequence;
	}
	
	/**
	 * Get filters represented by a FilterSequence
	 * @return the filters
	 */
	public AbstractFilterSequence<T> getFilters() {
		return filters;
	}

	/**
	 * @param filters the filters to set
	 */
	public void setFilters(AbstractFilterSequence<T> filters) {
		this.filters = filters;
	}


	
	public List<T> getFilteredInput() {
		
		
		if ( filters == null || filters.getConfiguredFilters().size() == 0 ) {
			return getInput();
		}
		
		List<AbstractUIFilter<T,?>> confFilters = filters.getConfiguredFilters();
		
		ArrayList<T> filteredList = new ArrayList<T>();
		
		for (T object : getInput()) {
			
			for (AbstractUIFilter<T, ?> filter : confFilters) {
				if (filter.filter(object)) {
					filteredList.add(object);
					break;
				}
			}
		}
		
		return filteredList;
	}



	@Override
	public abstract IModel<T> model(Object object);

	@Override
	public abstract int size();
	

}
