/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.form105.rm.base.util.xml;

import net.form105.rm.base.Container;
import net.form105.xml.schema.model.ModelDocument;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

/**
 * Parses an xml file and returns an xmlBean document object
 * @author heiko
 *
 */
public class XmlBeansModelLoader extends AbstractXmlBeansLoader<ModelDocument> {
    
    public static Logger logger = Logger.getLogger(XmlBeansModelLoader.class);

    private String importDir;
    private String fileName;
    
    public XmlBeansModelLoader() {
        this.importDir = Container.getInstance().getConfiguration().getImportDirectory();
        fileName = "model.xml";
    }
    
    public XmlBeansModelLoader(String fileName) {
        this.fileName = fileName;
    }
    
    public ModelDocument parse(String fileName) {
        
        ModelDocument document = null;
        
        try {
            document = ModelDocument.Factory.parse(importDir+fileName);
        } catch (XmlException e) {
            logger.error(e, e);
        }
        
        return document;
    }
    
    @Override
    public ModelDocument parse() {
        return parse(this.fileName);
    }

}
