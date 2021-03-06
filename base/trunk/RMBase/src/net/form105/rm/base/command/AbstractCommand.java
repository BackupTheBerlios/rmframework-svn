/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.command;

import java.util.List;

import net.form105.rm.base.auth.AbstractIdentity;
import net.form105.rm.base.exception.RMException;

import org.apache.log4j.Logger;

/**
 *
 * @author hk
 */
public abstract class AbstractCommand implements ICommand {
    
    protected static Logger logger = Logger.getLogger(AbstractCommand.class);

    private List<Exception> exceptions;
    @SuppressWarnings("unused")
    private AbstractIdentity identity;
    private String group;
    
    public AbstractCommand(AbstractIdentity identity, String group) {
    	this.identity = identity;
    	this.group = group;
    }
    
    public AbstractCommand(String group) {
    	this.group = group;
    }
    
    public AbstractCommand() {
    	this.group = "";
    }
    
    public abstract void execute() throws RMException;

    public List<Exception> getExceptions() {
        return exceptions;
    }
    
    public String getName() {
    	return this.getClass().getName();
    }
    
    public String getGroup() {
    	return group;
    }
    
    public void setGroup(String group) {
    	this.group = group;
    }
}
