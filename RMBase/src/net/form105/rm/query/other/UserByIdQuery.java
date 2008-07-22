package net.form105.rm.query.other;

import java.util.Collection;
import java.util.List;

import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.AbstractFilterQuery;
import net.form105.rm.base.query.filter.IFilter;
import net.form105.rm.base.selection.ISelection;

public class UserByIdQuery<T extends User> extends AbstractFilterQuery<T> {
	
	

	public UserByIdQuery(List<IFilter> filterList, ISelection<T> selection) {
		super(filterList, selection);
	}

	@Override
	public Collection<T> execute() {
		return super.execute();
	}

}
