/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.form105.rm.base.command;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author heiko
 */
public enum GroupHandlerType {
    
    SEQUENCE("sequence");
    
    String id;
    
    private GroupHandlerType(String id) {
        this.id = id;
    }
    
    public ICommandGroup getObject(Collection<ICommand> commands) {
        if (id.equals("sequence")) {
            return new SequenceCommandGroup(commands);
        } else {
            return new SequenceCommandGroup(new ArrayList<ICommand>());
        }
        
    }

}
