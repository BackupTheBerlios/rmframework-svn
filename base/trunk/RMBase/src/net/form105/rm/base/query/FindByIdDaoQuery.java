package net.form105.rm.base.query;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.IAgentObject;

/**
 * This is a common Query to access Daos that implement the IBasicDao interface. You get back all objects
 * which can be accessed by the dao. 
 * @author hk
 *
 * @param <T> The class which is accessed by the dao
 */
public class FindByIdDaoQuery<T extends IAgentObject> extends AbstractSimpleQuery<T> {

	private static final long serialVersionUID = 1L;
	private IBasicDao<T> dao;
	private long id;
	
	
	public FindByIdDaoQuery(IBasicDao<T> dao, Long id) {
		this.dao = dao;
		this.id = id;
	}
	
	
	@Override
	public List<T> execute() {
		T object = dao.findById(id);
		List<T> list = new ArrayList<T>();
		list.add(object);
		return list;
	}

}
