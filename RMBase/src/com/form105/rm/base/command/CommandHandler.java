/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.command;

import java.util.List;

/**
 *
 * @author heiko
 */
public class CommandHandler {
    
    public void handle(List<AbstractCommand> commands) {
        for (AbstractCommand command : commands) {
            command.execute();
            
        }
    }

}
