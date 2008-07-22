package net.form105.rm.base.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.form105.rm.base.query.filter.IFilter;
import net.form105.rm.base.selection.ISelection;


/**
 * Multiple filters are allowed. The filters are sequenced as an AND-Implementation
 * @author heiko
 *
 * @param <T>
 */
public abstract class AbstractFilterQuery<T> implements IQuery<T> {
	
	private Collection<IFilter> filterList = new ArrayList<IFilter>();
	private ISelection<T> selection;
	
	
	public AbstractFilterQuery(Collection<IFilter> filterList, ISelection<T> selection) {
		this.selection = selection;
		this.filterList = filterList;
	}
	
	public AbstractFilterQuery(IFilter filter, ISelection<T> selection) {
		this.selection = selection;
		filterList.add(filter);
	}
	
	public AbstractFilterQuery(ISelection<T> selection) {
		this.selection = selection;
	}
	
	@Override
	public Collection<T> execute() {
		List<T> tempList = new ArrayList<T>();
		Collection<T> result = selection.select();
		
		if (filterList.size() == 0) {
			return result;
		}
		
		for (T object : result) {
			boolean filtered = true;
			for (IFilter filter : filterList) {
					filtered = (filtered && filter.filter(object));
					if (! filtered) break;
			}
			if (filtered) {
				tempList.add(object);
			}
		}
		return tempList;
	}
	
	public void addFilter(IFilter filter) {
		filterList.add(filter);
	}
	
	/**
	 * Getting all filters that have been registered
	 * @return
	 */
	protected Collection<IFilter> getFilters() {
		return filterList;
	}

	public ISelection<T> getSelection() {
		return selection;
	}

}
