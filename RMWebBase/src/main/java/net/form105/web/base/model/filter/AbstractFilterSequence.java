package net.form105.web.base.model.filter;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.lookup.ILookup;

/**
 * The AbstractFilterSequence provides a way to access registered filters.
 * Filters can be registered and unregistered dependent on the UI filters that
 * should be used. The filters behave like a configuration that can be accessed
 * across sessions. This is necessary to provide a filter that has configured
 * on the page before. The sequence class itself is the key in the lookup.
 * 
 * @author hk
 * 
 * @param <T> The base object type the filters act on
 */
public abstract class AbstractFilterSequence<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, AbstractUIFilter<T,?>> filters = new HashMap<String, AbstractUIFilter<T,?>>();

	private ILookup lookup;

	/**
	 * Constructs a sequence by providing a local lookup. For web application a local lookup is needed because
	 * it is stored in the session context.
	 * @param lookup
	 */
	public AbstractFilterSequence(ILookup lookup) {
		this.lookup = lookup;
	}

	/**
	 * Add a filter by its id to the filter map.
	 * @param filter
	 */
	public void add(AbstractUIFilter<T, ?> filter) {
		filters.put(filter.getId(), filter);
	}

	/**
	 * Remove a filter
	 * @param filter
	 */
	public void remove(AbstractUIFilter<T, ?> filter) {
		filters.remove(filter.getId());
	}

	/**
	 * Remove a filter by its id.
	 * @param id
	 */
	public void removeById(String id) {
		filters.remove(id);
	}

	/**
	 * Get all registered filters as a list.
	 * @return
	 */
	public Collection<AbstractUIFilter<T,?>> getFilterAsCollection() {
		return filters.values();
	}

	/**
	 * Get the filters which are configured and therefor registered in the lookup.
	 * @return
	 */
	public List<AbstractUIFilter<T,?>> getConfiguredFilters() {
		List<AbstractUIFilter<T,?>> configuredFilterList = (List<AbstractUIFilter<T,?>>) lookup.getEntryAsList(this.getClass());
		return configuredFilterList;
	}
	
	public AbstractUIFilter<T,?> getConfiguredFilter(String id) {
		for (AbstractUIFilter filter : getConfiguredFilters()) {
			if (filter.getId().equals(id)) {
				return filter;
			}
		}
		return null;
	}

	/**
	 * Get the filters which are registered. Gets all filters which are available to the users choices.
	 * @return
	 */
	public Map<String, AbstractUIFilter<T,?>> getFilters() {
		return filters;
	}

	/**
	 * Check if a filter already exist in the entry. If so, dann remove it first and add the new filter
	 * @param filter
	 */
	public void save(AbstractUIFilter<T,?> filter) {
		List items = lookup.getEntry(this.getClass()).getItems();
		AbstractUIFilter tempItem = null;
		for (Object object : items) {
			AbstractUIFilter entryFilter = (AbstractUIFilter) object;
			if (entryFilter.getId().equals(filter.getId())) {
				tempItem = entryFilter;
				break;
			}
		}
		
		if (tempItem != null) {
			lookup.getEntry(this.getClass()).removeItem(tempItem);
		}
		
		lookup.addEntry(this.getClass(), filter);
	}
	
	public String getConfiguredSizeAsString() {
		StringBuffer sBuffer = new StringBuffer().append("(").append(getConfiguredFilters().size()).append(")");
		return sBuffer.toString();
	}

}
