/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model;

import net.form105.rm.base.model.parameter.AbstractParameter;
import net.form105.rm.base.model.parameter.BooleanParameter;
import net.form105.rm.base.model.parameter.FloatParameter;
import net.form105.rm.base.model.parameter.IntParameter;
import net.form105.rm.base.model.parameter.StringParameter;
import net.form105.xml.schema.model.ResourceDocument;
import net.form105.xml.schema.model.ParameterDocument.Parameter;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;


public class Resource extends ParameterizedElement implements IXmlObjectLoadable<Resource> {
    
    public static Logger logger = Logger.getLogger(Resource.class);

    private static final long serialVersionUID = 1L;

    public Resource() {
    }
    
    public Resource(String elementId, String name, String type) {
    	setElementId(elementId);
    	setName(name);
    	setType(type);
    }

    /**
     * 
     * static final int INT_STRING = 1;
     * static final int INT_INTEGER = 2;
     * static final int INT_FLOAT = 3;
     * static final int INT_BOOLEAN = 4;
     * @param xmlObject
     * @return
     */
    public Resource loadFromXml(XmlObject xmlObject) {
        ResourceDocument.Resource xmlResource = (ResourceDocument.Resource) xmlObject;

        setElementId(xmlResource.getId());
        setName(xmlResource.getName());
        Parameter[] xmlParameters = xmlResource.getParameterArray();
        for (Parameter xmlParameter : xmlParameters) {
            AbstractParameter<?> parameter = null;
            switch (xmlParameter.getType().intValue()) {
            case 1:
                parameter = new StringParameter();
            case 2:
                parameter = new IntParameter();
            case 3:
                parameter = new FloatParameter();
            case 4:
                parameter = new BooleanParameter();
            }
            
            if (parameter != null) {
                parameter.loadFromXml(xmlParameter);
                this.addParameter(parameter);
            }
        }

        return this;
    }

}
