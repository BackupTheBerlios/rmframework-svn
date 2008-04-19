/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.model.xml;

import com.form105.rm.base.model.AgentObject;
import java.util.List;
import org.dom4j.Element;

/**
 *
 * @author heiko
 */
public interface IXmlConverter<T extends AgentObject> extends IConverter<T, Element> {
    
    public T convert(T result, Element element);
    
    public void processChilds(T source, Element parent);

}
