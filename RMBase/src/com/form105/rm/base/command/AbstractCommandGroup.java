/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.base.command;

import com.form105.rm.base.exception.RMCommandException;
import com.form105.rm.base.exception.RMException;
import java.util.Collection;

/**
 *
 * @author heiko
 */
public abstract class AbstractCommandGroup implements ICommandGroup {

    private State state;
    private Collection<ICommand> commands;
    
    public AbstractCommandGroup(Collection<ICommand> commands) {
        this.commands = commands;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public abstract void performGroup() throws RMException;

    public void perform() {
        setState(State.START);
        try {
            setState(State.INTRANSITION);
            performGroup();
        } catch (RMCommandException ex) {
            
        } finally {
            setState(State.FINISH);
        }
        

    }

    public Collection<ICommand> getCommands() {
        return commands;
    }

    public void setCommands(Collection<ICommand> commands) {
        this.commands = commands;
    }
    
    public void rollback() {
        
    }
}
