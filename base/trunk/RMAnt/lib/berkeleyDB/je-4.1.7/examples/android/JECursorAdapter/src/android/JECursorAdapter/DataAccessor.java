/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 * $Id: DataAccessor.java,v 1.1 2010/03/05 08:09:36 eric Exp $
 */
 
package android.JECursorAdapter;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.PrimaryIndex;

public class DataAccessor {
    public PrimaryIndex<Integer, Data> dataByKey;
    
    public DataAccessor(EntityStore store)
        throws DatabaseException {
        
        /* Primary key for Data classes. */
        dataByKey = store.getPrimaryIndex(Integer.class, Data.class);
    }
}
