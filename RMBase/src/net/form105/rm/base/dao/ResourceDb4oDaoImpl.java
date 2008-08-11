package net.form105.rm.base.dao;

import java.util.List;

import net.form105.rm.base.Container;
import net.form105.rm.base.container.DBContainer;
import net.form105.rm.base.model.Resource;

import com.db4o.ObjectContainer;

public class ResourceDb4oDaoImpl implements IBasicDao<Resource, Long> {
	
	ObjectContainer db;
	
	public ResourceDb4oDaoImpl() {
		super();
		DBContainer dbContainer = (DBContainer) Container.getContainer().getComponent(DBContainer.class);
		db = dbContainer.getDb();
	}

	@Override
	public void delete(Resource object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Resource merge(Resource object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Resource object) {
		

	}

	@Override
	public void saveOrUpdate(Resource object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Resource object) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Resource> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
