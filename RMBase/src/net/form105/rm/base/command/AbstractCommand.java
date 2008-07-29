/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.command;

import java.util.List;

import net.form105.rm.base.exception.RMException;

import org.apache.log4j.Logger;

/**
 *
 * @author heiko
 */
public abstract class AbstractCommand implements ICommand {
    
    protected static Logger logger = Logger.getLogger(AbstractCommand.class);

    private List<Exception> exceptions;
    
    public abstract void execute() throws RMException;

    public List<Exception> getExceptions() {
        return exceptions;
    }

}