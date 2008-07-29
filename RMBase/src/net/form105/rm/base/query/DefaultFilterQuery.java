package net.form105.rm.base.query;

import java.util.Collection;
import java.util.List;

import net.form105.rm.base.query.filter.IFilter;
import net.form105.rm.base.selection.ISelection;


/**
 * A default implementation of the AbstractFilteredQuery. Filters can be added by constructor
 * or the super implementation
 * @author hk
 *
 * @param <T> Type of object get back by the query
 */
public class DefaultFilterQuery<T> extends FilterQuery<T> {

	public DefaultFilterQuery(ISelection<T> selection, List<IFilter> filterList) {
		super(selection, filterList);
	}

	public DefaultFilterQuery(ISelection<T> selection, IFilter filter) {
		super(selection, filter);
	}

	@Override
	public Collection<T> execute() {
		return super.execute();
	}

}
