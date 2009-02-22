/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.server.command;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.Container;
import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.dao.resource.AbstractAgentObjectDao;
import net.form105.rm.base.exception.FileNotFoundRMException;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.lookup.ILookup;
import net.form105.rm.base.model.AgentObject;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.util.helper.FileHelper;
import net.form105.xml.schema.model.ModelDocument;
import net.form105.xml.schema.model.ResourceDocument;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

/**
 *
 * @author hk
 */
public class LoadXmlModelCommand extends AbstractCommand {
    
    public static Logger logger = Logger.getLogger(LoadXmlModelCommand.class);

    private final String id = "LOAD_XML_MODEL_COMMAND";

    private final String DEFAULT_NAME = "model.xml";

    private ModelDocument modelDocument;

    private String file;

    /**
     * The import file will be loaded from the import file defined in the configuration
     * @param fileName
     */
    public LoadXmlModelCommand(String fileName) {
        String importDir = Container.getInstance().getConfiguration().getImportDirectory();
        file = FileHelper.appendFileSeparator(importDir) + DEFAULT_NAME;
    }

    /**
     * The import file will be loaded from the property defined by the key server.model.name
     */
    public LoadXmlModelCommand() {
        String modelDir = Container.getInstance().getConfiguration().getModelDirectory();
        String modelFileName = Agent.getRMProperty("server.model.name");
        file = FileHelper.appendFileSeparator(modelDir) + modelFileName;
    }

    @Override
    public final String getId() {
        return id;
    }

    @Override
    public void execute() throws RMException {
        ILookup daoLookup = Agent.getDaoLookup();
        for (Resource resource : loadResources(loadXmlModelFile(file))) {
            List daos = daoLookup.getEntryAsList(Resource.class);
            for (AbstractAgentObjectDao dao : daos) {
                logger.info("Saving resource to dao: "+resource.getElementId());
                dao.save(resource);
            }

        }

    }

    private List<Resource> loadResources(ModelDocument modelDocument) {
        List<Resource> resourceList = new ArrayList<Resource>();

        ResourceDocument.Resource[] resources = modelDocument.getModel().getResourceArray();
        for (ResourceDocument.Resource xmlResource : resources) {
            net.form105.rm.base.model.Resource modelResource = new net.form105.rm.base.model.Resource();
            modelResource.loadFromXml(xmlResource);
            resourceList.add(modelResource);
            logger.info("Resource with id: " + modelResource.getElementId() + " loaded.");
        }
        return resourceList;
    }

    protected ModelDocument loadXmlModelFile(String fileName) {
        ModelDocument modelDocument = null;
        String importDir = Container.getInstance().getConfiguration().getImportDirectory();
        try {
            File file = FileHelper.getFile(fileName);
            modelDocument = ModelDocument.Factory.parse(file);
            return modelDocument;
        } catch (XmlException e) {
            logger.error(e, e);
        } catch (IOException e) {
            throw new FileNotFoundRMException(importDir + fileName);
        }
        return modelDocument;

    }

}