package net.form105.rm.base.query;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.AgentObject;

/**
 * This is a common Query to access Daos that implement the IBasicDao interface. You get back all objects
 * which can be accessed by the dao. 
 * @author hk
 *
 * @param <T> The class which is accessed by the dao
 */
public class FindByIdDaoQuery<T extends AgentObject> extends AbstractSimpleQuery<T> {

	private static final long serialVersionUID = 1L;
	private Class<?> daoClass;
	private long id;
	
	
	public FindByIdDaoQuery(Class<?> daoClass, Long id) {
		this.daoClass = daoClass;
		this.id = id;
	}
	
	
	@Override
	public List<T> execute() {
		ILookup lookup = Agent.getLookup();
		@SuppressWarnings("unchecked")
		IBasicDao<T> dao = (IBasicDao<T>) lookup.getFirstContentObject(daoClass);
		T result = dao.findById(id);
		List<T> results = new ArrayList<T>();
		results.add(result);
		return results;
	}

}
