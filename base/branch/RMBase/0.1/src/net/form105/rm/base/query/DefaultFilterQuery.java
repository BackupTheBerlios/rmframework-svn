package net.form105.rm.base.query;

import java.util.List;

import net.form105.rm.base.filter.IFilter;
import net.form105.rm.base.selection.ISelection;


/**
 * A default implementation of the AbstractFilteredQuery. Filters can be added by constructor
 * or the super implementation
 * @author hk
 *
 * @param <T> Type of object get back by the query
 */
public class DefaultFilterQuery<T> extends FilterQuery<T> {

	private static final long serialVersionUID = 1L;

	public DefaultFilterQuery(ISelection<T> selection, List<IFilter<T>> filterList) {
		super(selection, filterList);
	}
	
	public DefaultFilterQuery(ISelection<T> selection) {
	    super(selection);
	}

	public DefaultFilterQuery(ISelection<T> selection, IFilter<T> filter) {
		super(selection, filter);
	}

	@Override
	public List<T> execute() {
		return super.execute();
	}

}
