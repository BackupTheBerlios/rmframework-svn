/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.model;

import java.io.Serializable;
import javax.persistence.Entity;

import net.form105.rm.base.model.xml.IXmlConverter;
import net.form105.rm.base.model.xml.IXmlLoadable;

import org.dom4j.Element;

@Entity
public class Resource extends ParameterizedElement implements IXmlLoadable<Resource>, Serializable {

    public Resource load(IXmlConverter converter, Element element) {
        converter.convert(this, element);
        return this;
    }
    
}
