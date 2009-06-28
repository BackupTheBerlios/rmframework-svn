package net.form105.rm.base.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.form105.rm.base.filter.IFilter;
import net.form105.rm.base.selection.ISelection;
import net.form105.rm.base.service.IResult;


/**
 * Multiple filters are allowed. The filters are sequenced as an AND-Implementation
 * @author heiko
 *
 * @param <T>
 */
public class FilterQuery<T> extends AbstractQuery<T> implements IQuery<T> {
	

	private static final long serialVersionUID = 1L;
	private List<IFilter<T>> filterList = new ArrayList<IFilter<T>>();
	private ISelection<T> selection;
	
	
	public FilterQuery(ISelection<T> selection, List<IFilter<T>> filterList) {
		this.selection = selection;
		this.filterList = filterList;
	}
	
	public FilterQuery(ISelection<T> selection, IFilter<T> filter) {
		this.selection = selection;
		filterList.add(filter);
	}
	
	public FilterQuery(ISelection<T> selection) {
		this.selection = selection;
	}
	
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
	protected Collection<IFilter<T>> getFilters() {
		return filterList;
	}

	public ISelection<T> getSelection() {
		return selection;
	}

}
