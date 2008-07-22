/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package net.form105.rm.base.command;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author heiko
 */
public class CommandHandler {
    
    //private ICommandGroup group = SequenceGroupHandler;
    
    public CommandHandler() {
        
    }
    
    public CommandHandler(ICommandGroup group) {
        
    }
    
    public void handle(List<AbstractCommand> commands) {
        for (AbstractCommand command : commands) {
            command.execute();
            
        }
    }
    
    public void handle(Collection<ICommand> commands, GroupHandlerType groupType) {
        ICommandGroup group = groupType.getObject(commands);
        
    }

}
