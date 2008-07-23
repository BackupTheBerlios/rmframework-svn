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
 * @param <T>
 */
public class DefaultFilterQuery<T> extends FilterQuery<T> {

	public DefaultFilterQuery(List<IFilter> filterList, ISelection<T> selection) {
		super(filterList, selection);
	}

	public DefaultFilterQuery(IFilter filter, ISelection<T> selection) {
		super(filter, selection);
	}

	@Override
	public Collection<T> execute() {
		return super.execute();
	}

}
