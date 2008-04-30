/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.dao;

import com.form105.rm.base.model.Resource;
import java.util.List;

/**
 * This class is intended to use for Resources. The readDao should eb on all
 * derived classes equal. This is a special behaviour as all ResourceDaos 
 * should provide the same read mechanism. 
 *
 * @author heiko
 */
public abstract class AbstractResourceDao implements IBasicDao<Resource, Long> {
    
    AbstractResourceDao readDao;
    
    public AbstractResourceDao(AbstractResourceDao readDao) {
        this.readDao = readDao;
    }

    /**
     * Delegate read to the readDao
     * @param id
     * @return
     */
    public Resource findById(Long id) {
        return readDao.findById(id);
    }

    public abstract void save(Resource object);

    public abstract void update(Resource object);

    public abstract void saveOrUpdate(Resource object);

    public abstract Resource merge(Resource object);

    public abstract void delete(Resource object);

    /**
     * Delegate read access to the read Dao
     * @return
     */
    public List<Resource> findAll() {
        return readDao.findAll();
    }

}
