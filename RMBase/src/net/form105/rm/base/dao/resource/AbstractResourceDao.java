package net.form105.rm.base.dao.resource;

import java.util.List;

import net.form105.rm.base.dao.IBasicDao;
import net.form105.rm.base.model.Resource;

public abstract class AbstractResourceDao implements IBasicDao<Resource, Long> {

	AbstractResourceDao transientDao;

	/**
	 * Use this constructor if we are in dual mode (transient and transactional)
	 * @param readDao
	 */
	public AbstractResourceDao(AbstractResourceDao readDao) {
		this.transientDao = readDao;
	}
	
	/**
	 * Use this constructor if we are in transactional mode. Than this is also the transient dao
	 * which means there isn't one.
	 */
	public AbstractResourceDao() {
		this.transientDao = this;
	}

	@Override
	public abstract void delete(Resource object);

	@Override
	public abstract List<Resource> findAll();

	@Override
	public abstract Resource findById(Long id);

	@Override
	public abstract Resource merge(Resource object);

	@Override
	public abstract void save(Resource object);

	@Override
	public abstract void saveOrUpdate(Resource object);

	@Override
	public abstract void update(Resource object);
	
	public AbstractResourceDao getTransientDao() {
		return transientDao;
	}

}
