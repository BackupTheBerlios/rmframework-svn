/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.command;

import com.form105.rm.base.exception.RMException;
import java.util.List;

/**
 * Interface to implement by commands. Commands should be executed by the 
 * CommandHandler which handles exception
 * @author heiko
 */
public interface ICommand {
    
    public void execute() throws RMException;
    
    /**
     * Getting the exceptions thrown by the execution of this command. A command
     * can throw multiple exceptions.
     * @return
     */
    public List<Exception> getExceptions();

}
