package com.form105.rm.base.query;

import java.util.Collection;
import java.util.List;

import com.form105.rm.base.query.filter.IFilter;
import com.form105.rm.base.selection.ISelection;

public class FilteredQuery<T> extends AbstractFilterQuery<T> {

	public FilteredQuery(List<IFilter> filterList, ISelection<T> selection) {
		super(filterList, selection);
	}
	
	public FilteredQuery(ISelection<T> selection) {
		super(selection);
	}

	public Collection<T> execute() {
		return super.execute();
	}
}
