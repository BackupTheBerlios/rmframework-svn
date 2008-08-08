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
public class FilterQuery<T> implements IQuery<T> {
	

	private static final long serialVersionUID = 1L;
	private List<IFilter> filterList = new ArrayList<IFilter>();
	private ISelection<T> selection;
	
	
	public FilterQuery(ISelection<T> selection, List<IFilter> filterList) {
		this.selection = selection;
		this.filterList = filterList;
	}
	
	public FilterQuery(ISelection<T> selection, IFilter filter) {
		this.selection = selection;
		filterList.add(filter);
	}
	
	public FilterQuery(ISelection<T> selection) {
		this.selection = selection;
	}
	
	@Override
	public List<T> execute() {
		List<T> tempList = new ArrayList<T>();
		List<T> result = selection.select();
		
		if (filterList.size() == 0) {
			return result;
		}
		
		for (T object : result) {
			boolean filtered = true;
			for (IFilter<T> filter : filterList) {
					filtered = (filtered && filter.filter(object));
					if (! filtered) break;
			}
			if (filtered) {
				tempList.add(object);
			}
		}
		return tempList;
	}
	
	public void addFilter(IFilter<T> filter) {
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
