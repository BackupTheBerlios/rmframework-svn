/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.model.xml;

/**
 *
 * @author heiko
 */
public interface IConverter<T, V> {
    
    public T convert(T result, V convertable);

}
