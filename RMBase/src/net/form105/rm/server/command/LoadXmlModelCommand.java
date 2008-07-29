/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.server.command;

import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.Agent;
import net.form105.rm.base.command.AbstractCommand;
import net.form105.rm.base.exception.RMException;
import net.form105.rm.base.model.Resource;
import net.form105.rm.base.model.xml.ResourceXMLConverter;
import net.form105.rm.base.util.xml.XMLModelLoader;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;

/**
 *
 * @author heiko
 */
public class LoadXmlModelCommand extends AbstractCommand {
    
    private String path = "model";
    private String model;
    
    public LoadXmlModelCommand() {
        model = Agent.getRMProperty("server.model.name");
    }
    
    public LoadXmlModelCommand(String model) {
        this.model = model;
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
            resource.load(new ResourceXMLConverter(), element);
            resources.add(resource);
        }
    }

}
