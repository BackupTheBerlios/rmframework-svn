/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.model.xml;

import java.util.List;

import net.form105.rm.base.model.AgentObject;

import org.dom4j.Element;

/**
 *
 * @author heiko
 */
public interface IXmlConverter<T extends AgentObject> extends IConverter<T, Element> {
    
    public T convert(T result, Element element);
    
    public void processChilds(T source, Element parent);

}
