package net.form105.rm.base.dao.resource;

import java.io.Serializable;
import java.util.List;

import net.form105.rm.base.dao.IBasicDao;

public abstract class AbstractResourceDao<T, ID extends Serializable> implements IBasicDao<T, ID> {

	private IBasicDao<T, ID> transientDao;
	
	public AbstractResourceDao(IBasicDao<T, ID> transientDao) {
		this.transientDao = transientDao;
	}
	
	public AbstractResourceDao() {
		
	}
	
	@Override
	public abstract void delete(T object);

	@Override
	public abstract List<T> findAll();

	@Override
	public abstract T findById(ID id);

	@Override
	public abstract T merge(T object);

	@Override
	public abstract void save(T object);

	@Override
	public abstract void saveOrUpdate(T object);

	@Override
	public abstract void update(T object);
	
	public IBasicDao<T, ID> getTransientDao() {
		return transientDao;
	}
	
	public void setTransientDao(IBasicDao<T, ID> transientDao) {
		this.transientDao = transientDao;
	}
	
	public IBasicDao<T, ID> getReadDao() {
		if (transientDao == null) {
			return this; 
		} else {
			return transientDao;
		}
	}

}
