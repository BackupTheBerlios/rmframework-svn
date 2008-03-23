/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.exception;

import com.form105.rm.base.command.ICommand;

/**
 *
 * @author heiko
 */
public class RMCommandException extends RMException {

    private ICommand command;
    
    /**
     * Constructs an exception thrown by an command
     * @param command
     * @param defaultMessage
     * @param cause
     */
    public RMCommandException(ICommand command, String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
        this.command = command;
    }

    public ICommand getCommand() {
        return command;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }
    
}
