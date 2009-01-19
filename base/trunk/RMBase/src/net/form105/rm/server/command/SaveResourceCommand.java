package net.form105.rm.server.command;

import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.dao.resource.AbstractAgentObjectDao;
import net.form105.rm.base.dao.resource.AbstractResourceDao;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.Resource;

import org.apache.log4j.Logger;

/**
 * Saves a resource by saving to all resource daos registered in the dao lookup
 * @author hk
 *
 */
public class SaveResourceCommand extends AbstractCommand {

    public static Logger logger = Logger.getLogger(SaveResourceCommand.class);

    private final String id = "SAVE_RESOURCE_COMMAND";

    private Resource resource;

    public SaveResourceCommand(Resource resource) {
        super();
        this.resource = resource;
    }

    @Override
    public void execute() throws RMException {

        ILookup<AbstractAgentObjectDao<? extends AgentObject>> lookup = Agent.getDaoLookup();
        List<AbstractAgentObjectDao<? extends AgentObject>> list = lookup.getEntryAsList(Resource.class);

        for (AbstractAgentObjectDao<? extends AgentObject> dao : list) {
            AbstractResourceDao resourceDao = (AbstractResourceDao) dao;
            resourceDao.save(resource);
        }
    }

    @Override
    public String getId() {
        return id;
    }

}
