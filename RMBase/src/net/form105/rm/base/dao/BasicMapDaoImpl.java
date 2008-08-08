/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author heiko
 */
public class BasicMapDaoImpl<T, ID extends Serializable> implements IBasicDao<T, ID> {

    public T findById(ID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void save(T object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(T object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveOrUpdate(T object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T merge(T object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(T object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<T> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
