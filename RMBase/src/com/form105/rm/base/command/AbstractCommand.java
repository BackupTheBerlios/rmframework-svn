/*
* Copyright (c) 2008, form105 Heiko Kundlacz
* Licensed under the GNU GPL Version 3. For full terms see the file license.txt
*/

package com.form105.rm.base.command;

import com.form105.rm.base.exception.RMException;
import java.util.List;

/**
 *
 * @author heiko
 */
public abstract class AbstractCommand implements ICommand {

    private List<Exception> exceptions;
    
    public abstract void execute() throws RMException;

    public List<Exception> getExceptions() {
        return exceptions;
    }

}
