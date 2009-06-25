/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.util.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.form105.rm.base.model.Resource;

import org.dom4j.Element;

/**
 *
 * @author heiko
 */
public class XMLModelLoader extends XMLLoader {
    
    List<Resource> resourceList = new ArrayList<Resource>();
    Element root;
    
    
    public XMLModelLoader(String modelName) {
        this("model", modelName);
    }
    
    public XMLModelLoader(String modelName, String path) {
        super(path + File.separator + modelName);
        parseFile();
    }
    
    public Element getRootElement() {
        return getDocument().getRootElement();
    }

}
