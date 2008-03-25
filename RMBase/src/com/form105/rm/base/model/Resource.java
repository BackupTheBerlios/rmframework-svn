/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.model;

import com.form105.rm.base.model.parameter.IntParameter;
import com.form105.rm.base.model.parameter.StringParameter;
import com.form105.rm.base.model.xml.IXmlConverter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import org.dom4j.Element;

@Entity
public class Resource extends ParameterizedElement implements IXmlConverter, Serializable {

    public void fromDom(Element resourceElement) {
        String id = resourceElement.attributeValue("id");
        String name = resourceElement.attributeValue("name");
        
        setElementId(id);
        setName(name);
        
        
        List<Element> sParamElements = resourceElement.selectNodes("/parameter[@type='string']");
        for (Element sParam : sParamElements) {
            StringParameter sParameter = new StringParameter();
            sParameter.fromDom(sParam);
            this.addParameter(sParameter);
        }
        
        List<Element> iParamElements = resourceElement.selectNodes("/parameter[@type='int']");
        for (Element sParam : iParamElements) {
            IntParameter iParameter = new IntParameter();
            iParameter.fromDom(sParam);
            this.addParameter(iParameter);
        }
        
        resourceElement.elements();
        
        
    }
    
    
    
    
}
