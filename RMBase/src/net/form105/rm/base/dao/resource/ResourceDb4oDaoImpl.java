package net.form105.rm.base.dao.resource;

import java.util.List;

import net.form105.rm.base.Container;
import net.form105.rm.base.container.DBContainer;
import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.model.Resource;

import org.apache.log4j.Logger;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

public class ResourceDb4oDaoImpl implements IBasicDao<Resource, Long> {
	
	public static Logger logger = Logger.getLogger(ResourceDb4oDaoImpl.class);
	
	ObjectContainer db;
	
	public ResourceDb4oDaoImpl() {
		super();
		
		// should use Db4o.newConfiguration()
		Db4o.configure().objectClass("net.form105.rm.base.model.Resource").cascadeOnDelete(true);
		
		DBContainer dbContainer = (DBContainer) Container.getContainer().getComponent(DBContainer.class);
		db = dbContainer.getDb();
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
		List<Resource> results = db.query(new Predicate<Resource>() {
			private static final long serialVersionUID = 1L;
			public boolean match(Resource resource){
		        return resource.getOid() == id;
		    }
		});
		return results.get(0);
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
