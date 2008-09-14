package net.form105.rm.server.command;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.dao.resource.AbstractResourceDao;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.Resource;

/**
 * Saves a resource by saving to all resource daos registered in the lookup
 * @author hk
 *
 */
public class SaveResourceCommand extends AbstractCommand {
	
	private final String id = "SAVE_RESOURCE_COMMAND";
	private ILookup lookup;
	private Resource resource;
	
	public SaveResourceCommand(Resource resource) {
		super();
		this.resource = resource;
		lookup = Agent.getLookup();
	}

	@Override
	public void execute() throws RMException {
		
		List<AbstractResourceDao<Resource, Long>> daoList = (List<AbstractResourceDao<Resource, Long>>) lookup.getEntryAsList(AbstractResourceDao.class);
		
		for (AbstractResourceDao<Resource, Long> dao : daoList) {
			dao.save(resource);
		}
		
	}

	@Override
	public String getId() {
		return id;
	}
	
	

}
