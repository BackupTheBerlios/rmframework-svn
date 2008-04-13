/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.lookup;

import java.util.List;

/**
 *
 * @author Heiko Kundlacz
 */
public interface ILookupListener<T> {
    
    public void updateItem(T object);
    
    public void updateItems(List<T> list);
    
    public void removeItem(T object);
    
    public void removeItems(List<T> list);
    
    public void addItem(T object);
    
    public void addItems(List<T> list);
    
}
