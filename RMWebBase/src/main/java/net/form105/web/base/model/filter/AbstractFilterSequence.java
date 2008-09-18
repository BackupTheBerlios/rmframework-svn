package net.form105.web.base.model.filter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.Agent;
import net.form105.rm.base.lookup.ILookup;

/**
 * The AbstractFilterSequence provides a way to access registered filters.
 * Filters can be registered and unregistered dependent on the UI filters that
 * should be used. The filters behave like a configuration that can be accessed
 * across sessions. This is necessary to provide a filter that has configured
 * on the page before. The sequence class itself is the key in the lookup
 * 
 * @author hk
 * 
 * @param <T> The base object type the filters act on
 */
public abstract class AbstractFilterSequence<T> {

	private Map<String, AbstractUIFilter<T>> filters = new HashMap<String, AbstractUIFilter<T>>();

	private ILookup lookup;

	public AbstractFilterSequence() {
		lookup = Agent.getLookup();
	}

	public void add(AbstractUIFilter<T> filter) {
		filters.put(filter.getId(), filter);
	}

	public void remove(AbstractUIFilter<T> filter) {
		filters.remove(filter.getId());
	}

	public void removeById(String id) {
		filters.remove(id);
	}

	public Collection<AbstractUIFilter<T>> getFilterAsCollection() {
		return filters.values();
	}

	public List<AbstractUIFilter<T>> getConfiguredFilters() {
		List<AbstractUIFilter<T>> configuredFilterList = (List<AbstractUIFilter<T>>) lookup.getEntryAsList(this.getClass());
		return configuredFilterList;
	}

	public Map<String, AbstractUIFilter<T>> getFilters() {
		return filters;
	}

	public void save(AbstractUIFilter<T> filter) {
		lookup.addEntry(this.getClass(), filter);
	}

}
