package net.form105.rm.base.dao.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.model.Resource;

import org.apache.log4j.Logger;

import com.db4o.foundation.NotSupportedException;

/**
 * The dao which is used as the map in transient mode or dual mode.
 * @author hk
 *
 */
public class ResourceMapDao extends AbstractAgentObjectDao<Resource> {
	
	public static Logger logger = Logger.getLogger(ResourceMapDao.class);
	
	private Map<String,Resource> resourceMap = Collections.synchronizedMap(new HashMap<String,Resource>());

	@Override
	public void delete(Resource object) {
		resourceMap.remove(object.getElementId());
	}

	@Override
	public List<Resource> findAll() {
		return new ArrayList<Resource>(resourceMap.values());
		
	}

	@Override
	public Resource findById(Long id) {
	    throw new NotSupportedException();
	}

	@Override
	public Resource merge(Resource object) {
		logger.warn("Invoked merge ... returning the same object that we received");
		return object;
	}

	@Override
	public void save(Resource object) {
		resourceMap.put(object.getElementId(), object);
		
	}

	@Override
	public void saveOrUpdate(Resource object) {
		resourceMap.put(object.getElementId(), object);
	}

	@Override
	public void update(Resource object) {
		resourceMap.put(object.getElementId(), object);
	}

	@Override
	public Resource findByElementId(String elementId) {
		return resourceMap.get(elementId);
	}

}
