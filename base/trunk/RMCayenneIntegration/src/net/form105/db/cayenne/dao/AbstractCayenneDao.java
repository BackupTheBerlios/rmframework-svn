package net.form105.db.cayenne.dao;

import java.util.List;

import net.form105.db.cayenne.container.CayenneContainer;
import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.access.DataContext;


/**
 * The abstract class to acces Cayenne and underlying objects.
 * @author heikok
 *
 */
public abstract class AbstractCayenneDao<T extends CayenneDataObject> implements ICayenneDao<T> {
	
	private DataContext context;
	
	public AbstractCayenneDao() {
		CayenneContainer container = (CayenneContainer) Agent.getComponentById("cayenne");
        this.context = container.getContext();
	}

	@Override
	public abstract void delete(T object);

	@Override
	public abstract List<T> findAll();

	@Override
	public abstract T findById(Long id);

	@Override
	public abstract T merge(T object);

	@Override
	public abstract void save(T object);

	@Override
	public abstract void saveOrUpdate(T object);

	@Override
	public abstract void update(T object);
	
	/**
	 * Get the context of Cayenne to access the database
	 * @return
	 */
	public DataContext getContext()  {
		return context;
	}
	
	
}
