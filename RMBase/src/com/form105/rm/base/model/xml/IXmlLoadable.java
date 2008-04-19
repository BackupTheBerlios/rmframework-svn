/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.model.xml;

import java.util.List;
import org.dom4j.Element;

/**
 *
 * @author heiko
 */
public interface IXmlLoadable<T> {
    
    public T load(IXmlConverter converter, Element element);

}
