/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.lookup;

/**
 *
 * @author heiko
 */
public class LookupItem<T> implements ILookupItem {
    
    private T content;
    
    public T getContent() {
        return this.content;
    }

}
