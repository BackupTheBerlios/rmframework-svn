package net.form105.rm.server.command;

import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.persistence.PersistenceHandler;

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
        
        PersistenceHandler pHandler = new PersistenceHandler();
        pHandler.saveAgentObject(resource);

        /*ILookup lookup = Agent.getDaoLookup();
        List<AbstractAgentObjectDao<Resource>> list = (List<AbstractAgentObjectDao<Resource>>) lookup.getEntryAsList(Resource.class);

        for (AbstractAgentObjectDao<? extends AgentObject> dao : list) {
            AbstractResourceDao resourceDao = (AbstractResourceDao) dao;
            resourceDao.save(resource);
        }*/
    }

    @Override
    public String getId() {
        return id;
    }

}
