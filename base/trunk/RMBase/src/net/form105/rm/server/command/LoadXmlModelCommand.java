/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.server.command;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.auth.AbstractIdentity;
import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.util.xml.XMLModelLoader;

import org.dom4j.Element;

/**
 *
 * @author hk
 */
public class LoadXmlModelCommand extends AbstractCommand {
	
    private final String id = "LOAD_XML_MODEL_COMMAND";
    private String path = "model";
    private String model;
    
    public LoadXmlModelCommand(AbstractIdentity identity) {
    	this(Agent.getRMProperty("server.model.name"), identity);
    }
    
    public LoadXmlModelCommand(String model, AbstractIdentity identity) {
    	super(identity);
        this.model = model;
    }
    
    @Override
    public String getId() {
    	return id;
    }

    @Override
    public void execute() throws RMException {
        XMLModelLoader loader = new XMLModelLoader(model, path);
        Element rootElement = loader.getRootElement();
        loadResources(rootElement);
    }
    
    private void loadResources(Element parentElement) {
        
        List<Resource> resources = new ArrayList<Resource>();
        
        List<Element> elements = parentElement.elements("resource");
        logger.info("Loading resources ..."+elements.size());
        for (Element element : elements) {
            Resource resource = new Resource();
            //resource.load(new ResourceXMLConverter(), element);
            resources.add(resource);
        }
    }

}
