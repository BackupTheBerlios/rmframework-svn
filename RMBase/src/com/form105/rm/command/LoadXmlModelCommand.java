/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.command;

import com.form105.rm.base.Agent;
import com.form105.rm.base.command.AbstractCommand;
import com.form105.rm.base.exception.RMException;
import com.form105.rm.base.model.Resource;
import com.form105.rm.base.model.xml.ResourceXMLConverter;
import com.form105.rm.base.util.xml.XMLModelLoader;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Element;
import org.dom4j.Element;

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
