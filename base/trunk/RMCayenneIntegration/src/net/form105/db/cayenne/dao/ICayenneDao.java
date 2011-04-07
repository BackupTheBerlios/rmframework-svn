package net.form105.db.cayenne.dao;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;

public interface ICayenneDao<T extends CayenneDataObject> {

	/**
	 * finds an object given by the id, returns null when the object was not
	 * found
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Long id);

	/**
	 * saves an object 
	 * 
	 * @param object
	 */
	public void save(T object);
	
	/**
	 * updates an object
	 * @param object
	 */
	public void update(T object);
	
	/**
	 * saves or updates an object, depending if the primary key is set
	 * @param object
	 */
	public void saveOrUpdate(T object);
	
	/**
	 * gets an object from the session, cache or db (in this order) and merges 
	 * the passed objects values into the found object.
	 * 
	 * @param object
	 * @return the found object
	 */
	public T merge(T object);

	/**
	 * deletes object in the database and sets primary key to null
	 * 
	 * @param object
	 */
	public void delete(T object);

	/**
	 * returns all instances
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * returns a java.util.List of the objects fitting the specified criterias
	 * 
	 * @param criteria
	 * @return
	 */
	//public List<T> findByCriteria(Criterion... criterion);

	
}
