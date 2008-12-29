/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model;

import javax.persistence.Entity;

import net.form105.rm.base.helper.UniqueIdHelper;
import net.form105.rm.base.model.parameter.AbstractParameter;
import net.form105.rm.base.model.parameter.StringParameter;
import net.form105.xml.schema.model.ResourceDocument;
import net.form105.xml.schema.model.ParameterDocument.Parameter;

import org.apache.xmlbeans.XmlObject;

@Entity
public class Resource extends ParameterizedElement implements IXmlObjectLoadable<Resource> {

    private static final long serialVersionUID = 1L;

    public Resource() {
        setOid(UniqueIdHelper.getId());
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
        ResourceDocument document = (ResourceDocument) xmlObject;
        String id = document.getResource().getId();
        String name = document.getResource().getName();
        Parameter[] xmlParameters = document.getResource().getParameterArray();
        for (Parameter xmlParameter : xmlParameters) {

            AbstractParameter<?> parameter = null;

            switch (xmlParameter.getType().intValue()) {
            case 1:
                parameter = new StringParameter();

                if (parameter != null) {
                    parameter.loadFromXml(xmlParameter);
                    this.addParameter(parameter);
                }
            }
        }

        return this;
    }

    private void delegateXmlObject(XmlObject[] objects) {
        for (XmlObject object : objects) {

        }
    }

}
