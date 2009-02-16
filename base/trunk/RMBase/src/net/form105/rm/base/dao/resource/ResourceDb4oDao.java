package net.form105.rm.base.dao.resource;

import java.util.List;

import net.form105.rm.base.model.Resource;

import org.apache.log4j.Logger;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.foundation.NotSupportedException;
import com.db4o.query.Predicate;

public class ResourceDb4oDao extends AbstractAgentObjectDao<Resource> {
	
	public static Logger logger = Logger.getLogger(ResourceDb4oDao.class);
	
	private ObjectContainer db;
	
	/**
	 * The constructor used for dual mode operation. In dual mode a transient map is available
	 * for fast access. 
	 * @param transientDao
	 */
	public ResourceDb4oDao(AbstractAgentObjectDao<Resource> transientDao, ObjectContainer objectContainer) {
		super(transientDao);
		db = objectContainer;
		
	}
	
	public ResourceDb4oDao() {
		super();
	}

	@Override
	public void delete(Resource object) {
		db.delete(object);

	}

	@Override
	public Resource merge(Resource object) {
		logger.warn("Invoked merge ... returning the same object that we received");
		return object;
	}

	@Override
	public void save(Resource object) {
		db.store(object);
	}

	@Override
	public void saveOrUpdate(Resource object) {
		db.store(object);
	}

	@Override
	public void update(Resource object) {
		db.store(object);
	}

	@Override
	public List<Resource> findAll() {
		ObjectSet<Resource> resources = db.query(Resource.class);
		return resources;
	}

	@Override
	public Resource findById(final Long id) {
	    throw new NotSupportedException();
	}

	@Override
	public Resource findByElementId(final String elementId) {
		List<Resource> results = db.query(new Predicate<Resource>() {
			private static final long serialVersionUID = 1L;
		    public boolean match(Resource resource){
		        return resource.getElementId().equals(elementId);
		    }
		});
		return results.get(0);
	}
}
