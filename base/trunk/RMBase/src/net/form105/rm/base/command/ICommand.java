/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.command;

import net.form105.rm.base.exception.RMException;

/**
 * Interface to implement by commands. Commands should be executed by the 
 * CommandHandler which handles exception
 * @author heiko
 */
public interface ICommand {
    
    public void execute() throws RMException;
    
    public String getOid();
    
    /**
     * The name of the command.
     * @return
     */
    public String getName();

}
