package com.form105.rm.base.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.form105.rm.base.exception.RMException;
import com.form105.rm.base.model.Resource;

/**
 * The implementation of the save and load mechanism. This class saves and
 * loads the resource objects from and to a HashMap. The access to the 
 * HashMap should never be allowed directly.
 * @author heiko
 */
public class ResourceDaoImpl extends AbstractResourceDao {
    
    private Map<Long, Resource> resourceMap = new HashMap<Long, Resource>();
    
    
    public Resource findById(Long id) {
        return resourceMap.get(id);
    }

    public ResourceDaoImpl(AbstractResourceDao readDao) {
        super(readDao);
    }

    public void save(Resource object) {
        if (resourceMap.get(object.getElementId()) != null) {
            throw new RMException(java.util.ResourceBundle.getBundle("BaseMessage").getString("Resource_already_exists:_Id_=_")+object.getElementId());
        }
        
    }

    public void update(Resource object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveOrUpdate(Resource object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Resource merge(Resource object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public synchronized void delete(Resource object) {
        
    }
    
    public Collection<Resource> findAll() {
        return readDao.findAll();
    }

}
