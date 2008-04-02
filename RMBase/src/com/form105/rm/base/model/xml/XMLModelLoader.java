/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.model.xml;

import com.form105.rm.base.model.Resource;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 *
 * @author heiko
 */
public class XMLModelLoader extends XMLLoader {
    
    List<Resource> resourceList = new ArrayList<Resource>();
    
    public XMLModelLoader(String filePath) {
        super(filePath);
    }
    
    public void load() {
        
        Document document = super.getDocument();
        Element root = document.getRootElement();
  
        List<Element> rootChilds = root.elements();

        for (Element element : rootChilds) {          
            if (element.getName().equals("resource")) {
                Resource resource = new Resource();
                resource.fromDom(element);
                resourceList.add(resource);
            }

        }

    }

}
