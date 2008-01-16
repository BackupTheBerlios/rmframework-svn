/*
 * Group.java, Oct 26, 2007, 7:59:33 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.base.model.user;

import com.form105.rm.base.model.AgentObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author Heiko Kundlacz
 */
@Entity(name = "t_group")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
