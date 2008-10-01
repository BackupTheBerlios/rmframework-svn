/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.command;

import java.util.Collection;

import net.form105.rm.base.exception.RMCommandException;

/**
 *
 * @author heiko
 */
/**
 * A command group which handles its commands in sequence
 * @author heiko
 */
public class SequenceCommandGroup extends AbstractCommandGroup {
    
    public SequenceCommandGroup(Collection<ICommand> commands) {
        super(commands);
    }
    

    public void performGroup() {
        for (ICommand command : getCommands()) {
            try {
                command.execute();
            } catch (Exception ex) {
                throw new RMCommandException(command, "", ex);
            }
        }
    }

}
