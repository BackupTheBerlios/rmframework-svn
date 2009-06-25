/*
 * Group.java, Oct 26, 2007, 7:59:33 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base.model.user;

import java.io.Serializable;

import net.form105.rm.base.model.AgentObject;

/**
 *
 * @author Heiko Kundlacz
 */

public class Group extends AgentObject implements Serializable {

    private Long oid;
    private String name;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
