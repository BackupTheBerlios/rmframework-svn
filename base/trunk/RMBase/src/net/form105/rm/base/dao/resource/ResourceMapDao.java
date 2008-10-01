package net.form105.rm.base.dao.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.form105.rm.base.model.Resource;

import org.apache.log4j.Logger;

/**
 * The dao which is used as the map in transient mode or dual mode.
 * @author hk
 *
 */
public class ResourceMapDao extends AbstractResourceDao<Resource, Long> {
	
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
		for (Resource resource : resourceMap.values()) {
			if (resource.getOid() == id) return resource;
		}
		return null;
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
