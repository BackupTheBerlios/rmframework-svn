/*
 * XMLReader.java, Oct 13, 2007, 11:17:52 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.helper;

import java.io.File;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.dom.DOMDocument;
import org.dom4j.io.SAXReader;

public class XMLReader {
  
  private static Logger logger = Logger.getLogger(XMLReader.class);
  
  public Document getDocumentByFile(File file) {
    
    Document document = new DOMDocument();
    
    try {
      SAXReader reader = new SAXReader();
      document = reader.read(file);
      return reader.read(file);
    } catch (DocumentException ex) {
      logger.error("File not found to load xml document: "+file.getName());
      logger.error(ex, ex);
    }
    
    return document;
  }

}
