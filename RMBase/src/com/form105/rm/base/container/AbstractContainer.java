package com.form105.rm.base.container;

import org.apache.log4j.Logger;
import org.picocontainer.Startable;

/**
 *
 * @author hh
 */
public abstract class AbstractContainer implements Startable {
    
    public static Logger logger = Logger.getLogger(AbstractContainer.class);
    
    public AbstractContainer() {
    	logger.info("Instantiating container: "+getClass().getSimpleName());
    }
}
