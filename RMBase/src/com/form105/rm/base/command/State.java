/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.base.command;

/**
 *
 * @author heiko
 */
public enum State {

    START(),
    INTRANSITION(),
    FINISH();
    
    public State nextState() {
        int ordinal = this.ordinal();
        return this.values()[ordinal + 1];
    }
}
