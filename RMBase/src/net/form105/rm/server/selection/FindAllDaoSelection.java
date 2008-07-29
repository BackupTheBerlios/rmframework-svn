package net.form105.rm.server.selection;

import java.util.Collection;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.lookup.EntryLookupRegistry;
import net.form105.rm.base.selection.AbstractSelection;

/**
 * A selection which returns all users
 * @author hk
 *
 */
public class FindAllDaoSelection<T> extends AbstractSelection<T> {
	
	private Class<?> daoClass;
	
	public FindAllDaoSelection(Class<?> daoClass) {
		this.daoClass = daoClass;
	}

	@Override
	public Collection<T> select() {		
		EntryLookupRegistry lookup = Agent.getLookup();
		IBasicDao<T, Long> dao = (IBasicDao<T,Long>) lookup.getContent(daoClass);
		return dao.findAll();
	}

}
