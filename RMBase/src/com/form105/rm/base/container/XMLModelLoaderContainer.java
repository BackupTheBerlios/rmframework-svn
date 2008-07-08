/* 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.base.container;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.picocontainer.Disposable;
import org.picocontainer.Startable;

/**
 * Loads the model from a xml file
 * 
 * @author Heiko Kundlacz
 */
public class XMLModelLoaderContainer extends AbstractContainer implements Startable, Disposable {
    
    PropertiesContainer propContainer;
    Document document;

    public XMLModelLoaderContainer(PropertiesContainer propContainer) {
    	super();
        this.propContainer = propContainer;
    }

    public void start() {
        File xmlModelFile;
        String fileName = "";
        try {

            fileName = propContainer.getProperties().getProperty("server.model.name");
            if (fileName == null) {
                fileName = "model.xml";
            }
            xmlModelFile = new File("config/" + fileName);
            document = parse(xmlModelFile);
        } catch (DocumentException ex) {
            logger.error("Can't parse document: config/"+fileName);
            logger.error(ex, ex);
        }
        
    }

    public void stop() {
        
    }

    public void dispose() {

    }
    
    public Document parse(File file) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        return document;
    }
    
    /**
     * Getting the xml document
     * @return The document
     */
    public Document getDocument() {
        return document;
    }
    
    /**
     * Getting the root element of the xml model implementation
     * @return
     */
    public Element getRootElement() {
        return document.getRootElement();
    }
    
}
