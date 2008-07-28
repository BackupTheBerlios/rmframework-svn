package net.form105.rm.base.query;

import java.util.Collection;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.lookup.EntryLookupRegistry;

/**
 * This is a common Query to access Daos that implement the IBasicDao interface. You get back all objects
 * which can be accessed by the dao. 
 * @author hk
 *
 * @param <T> The class which is accessed by the dao
 */
public class FindAllDaoQuery<T> extends AbstractSimpleQuery<T> {

	private static final long serialVersionUID = 1L;
	private Class<?> daoClass;
	
	
	public FindAllDaoQuery(Class<?> daoClass) {
		this.daoClass = daoClass;
	}
	
	@Override
	public Collection<T> execute() {
		EntryLookupRegistry lookup = Agent.getLookup();
		IBasicDao<T, Long> dao = (IBasicDao<T,Long>) lookup.getContent(daoClass);
		Collection<T> results = dao.findAll();
		return results;
	}

}
