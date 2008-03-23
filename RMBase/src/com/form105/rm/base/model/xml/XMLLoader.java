/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form105.rm.base.model.xml;

import com.form105.rm.base.exception.RMException;
import com.form105.rm.base.model.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author heiko
 */
public class XMLLoader {

    private static Logger logger = Logger.getLogger(XMLLoader.class);
    private static Document document;
    
    private List resourceList = new ArrayList<Resource>();
    

    /**
     * 
     * @param filePath
     */
    public Document parseFile(String filePath) {

        try {
            InputStream inStream = new FileInputStream(filePath);
            document = parseStream(inStream);
            return document;
        } catch (DocumentException docException) {
            logger.error("Exception at processing of a xml document", docException);
            throw(new RMException("DocumentException occured while trying to parse xml document", docException));
        } catch (FileNotFoundException fnfe) {
            logger.error("can't find xml file for parsing: "+filePath);
            throw(new RMException("Xml file to parse not found", fnfe));
        }
    }

    public Document parseStream(InputStream stream) throws DocumentException {
        SAXReader reader = new SAXReader();

        document = reader.read(stream);
        Element element = document.getRootElement();
        logger.info("Loading document: " + element.getName());
        return document;

    }

    public void load(Element root) {
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
