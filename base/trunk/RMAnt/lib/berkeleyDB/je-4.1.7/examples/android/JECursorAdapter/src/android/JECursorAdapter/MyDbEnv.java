/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 * $Id: MyDbEnv.java,v 1.1 2010/03/05 08:09:36 eric Exp $
 */
 
package android.JECursorAdapter;

import java.io.File;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.EnvironmentStats;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.StoreConfig;

public class MyDbEnv {

    private Environment myEnv;
    private EntityStore store;

    public MyDbEnv() {}

    public void setup(File envHome, boolean readOnly) 
        throws DatabaseException {

        EnvironmentConfig myEnvConfig = new EnvironmentConfig();
        StoreConfig storeConfig = new StoreConfig();

        myEnvConfig.setReadOnly(readOnly);
        storeConfig.setReadOnly(readOnly);
        
        myEnvConfig.setAllowCreate(!readOnly);
        storeConfig.setAllowCreate(!readOnly);

        myEnv = new Environment(envHome, myEnvConfig);
        store = new EntityStore(myEnv, "EntityStore", storeConfig);
    }
    
    public EntityStore getEntityStore() {
        return store;
    }

    public Environment getEnv() {
        return myEnv;
    }

    public EnvironmentStats getEnvStats() 
        throws DatabaseException {
        
        StatsConfig config = new StatsConfig();
        config.setClear(true/*reset*/);
        EnvironmentStats envStats = myEnv.getStats(config);
        if (envStats != null) {
            System.out.println(envStats);
        }
        return envStats; 
    }
    
    public void close() {
        if (store != null) {
            try {
                store.close();
            } catch(DatabaseException dbe) {
                System.err.println("Error closing store: " + dbe.toString());
                System.exit(-1);
            }
        }

        if (myEnv != null) {
            try {
                myEnv.close();
            } catch(DatabaseException dbe) {
                System.err.println("Error closing MyDbEnv: " + dbe.toString());
                System.exit(-1);
            }
        }
    }
}
