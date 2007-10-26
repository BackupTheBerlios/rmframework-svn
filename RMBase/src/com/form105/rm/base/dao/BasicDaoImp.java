/**
 * 
 * @author Sebastian Hennebrueder
 * created Feb 14, 2006
 * copyright 2006 by http://www.laliluna.de
 */
package com.form105.rm.base.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

public class BasicDaoImp<T, ID extends Serializable> implements BasicDao<T, ID> {

	protected Class<T> clazz;

	private SessionFactory factory;

	public BasicDaoImp(Class<T> clazz, SessionFactory factory) {
		this.clazz = clazz;
		this.factory = factory;
	}

	protected Session getSession() {
		return factory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		T result = (T) getSession().get(clazz, id);
		return result;

	}

	/**
     * reattaches a object from an older session to the current session. Uses
     * LockMode.Read to verifiy if the object does exist.
     * 
     * @param object
     */
	public void reattach(T object) {
		getSession().lock(object, LockMode.READ);
	}

	public void save(T object) {
		getSession().saveOrUpdate(object);
	}

	public void update(T object) {
		getSession().update(object);
	}

	public T merge(T object) {
		return (T) getSession().merge(object);
	}

	public void saveOrUpdate(T object) {
		getSession().saveOrUpdate(object);

	}

	public void delete(T object) {

		getSession().delete(object);

	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> result = getSession().createCriteria(clazz).list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criterion... criterion) {
		Criteria criteria = getSession().createCriteria(clazz);
		for (Criterion c : criterion)
			criteria.add(c);
		List<T> result = criteria.list();

		return result;
	}

}
