package net.form105.rm.base.query;

import java.util.List;

import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.model.AgentObject;

/**
 * This is a common Query to access Daos that implement the IBasicDao interface. You get back all objects
 * which can be accessed by the dao. 
 * @author hk
 *
 * @param <T> The class which is accessed by the dao
 */
public class FindAllDaoQuery<T extends AgentObject> extends AbstractSimpleQuery<T> {

	private static final long serialVersionUID = 1L;
	private IBasicDao<T> dao;
	
	
	public FindAllDaoQuery(IBasicDao<T> dao) {
		this.dao = dao;
	}
	
	@Override
	public List<T> execute() {
		return dao.findAll();
	}

}
