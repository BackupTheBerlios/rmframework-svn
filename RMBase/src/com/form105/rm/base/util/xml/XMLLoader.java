/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form105.rm.base.util.xml;

import com.form105.rm.base.ILifeCycle;
import com.form105.rm.base.command.ResultType;
import com.form105.rm.base.exception.RMException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author heiko
 */

/**
 * Loads a xml document and generates model objects.
 * @author heiko
 */
public class XMLLoader implements ILifeCycle {

    private static Logger logger = Logger.getLogger(XMLLoader.class);
    private Document document;
    
    private String filePath;
    private InputStream inStream;
    
    public XMLLoader(String filePath) {
        this.filePath = filePath;
    }
    

    /**
     * 
     * @param filePath
     */
    public Document parseFile() throws RMException {

        try {
            inStream = new FileInputStream(filePath);
            setDocument(parseStream(inStream));
            return getDocument();
        } catch (DocumentException docException) {
            logger.error("Exception processing of a xml document", docException);
            throw(new RMException("DocumentException occured while trying to parse xml document", docException));
        } catch (FileNotFoundException fnfe) {
            logger.error("can't find xml file for parsing: "+filePath);
            throw(new RMException("Xml file to parse not found", fnfe));
        }
    }

    public Document parseStream(InputStream stream) throws DocumentException {
        SAXReader reader = new SAXReader();

        setDocument(reader.read(stream));
        Element element = getDocument().getRootElement();
        logger.info("Loading document: " + element.getName());
        return getDocument();

    }

    public ResultType init() {
        try {
            parseFile();
        } catch (RMException rmE) {
            logger.error(rmE, rmE);
            return ResultType.ERROR;
        }
        return ResultType.SUCCESS;
        
    }

    public ResultType start() {
        return ResultType.SUCCESS;
    }

    public ResultType stop() {
            try {
                inStream.close();
                document = null;
                filePath = null;
                inStream = null;
            } catch (IOException ex) {
            }
        return ResultType.SUCCESS;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
