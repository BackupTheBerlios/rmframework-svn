/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.lookup;

import java.util.List;

/**
 *
 * @author heiko
 */
public interface IEntry {
    
    public List<Object> getItems();
    
    public Object getFirstItem();
    
    public void updateItem(Object object);
    
    public void updateItems(List<Object> list);
    
    public void removeItem(Object object);
    
    public void removeItems(List<Object> list);
    
    public void addItem(Object object);
    
    public void addItems(List<Object> list);
    
}
