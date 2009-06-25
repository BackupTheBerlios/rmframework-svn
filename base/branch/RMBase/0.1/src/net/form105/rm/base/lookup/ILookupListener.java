/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.lookup;

import java.util.List;

/**
 *
 * @author Heiko Kundlacz
 */
public interface ILookupListener {
    
    public void updateItem(Object object);
    
    public void updateItems(List<?> list);
    
    public void removeItem(Object object);
    
    public void removeItems(List<?> list);
    
    public void addItem(Object object);
    
    public void addItems(List<?> list);
    
}
