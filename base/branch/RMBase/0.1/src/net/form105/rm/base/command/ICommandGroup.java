/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.command;

/**
 *
 * @author heiko
 */
public interface ICommandGroup {
    
    /**
     * 
     * @param commands
     */
    public void performGroup();
    
    /**
     * Rollback all commands until an RMCommandException occured
     */
    public void rollback();

}
