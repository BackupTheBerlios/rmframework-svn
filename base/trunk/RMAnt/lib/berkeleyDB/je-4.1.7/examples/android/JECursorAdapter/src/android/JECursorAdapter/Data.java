/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 * $Id: Data.java,v 1.1 2010/03/05 08:09:36 eric Exp $
 */
 
package android.JECursorAdapter;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;

@Entity
public class Data {
    @PrimaryKey
    private Integer key;
    
    private String data;
    
    public void setKey(Integer key) {
        this.key = key;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public Integer getKey() {
        return key;
    }

    public String getData() {
        return data;
    }
    
    public String toString() {
        return new String(String.valueOf(key) + ". " + data);
    }
}
