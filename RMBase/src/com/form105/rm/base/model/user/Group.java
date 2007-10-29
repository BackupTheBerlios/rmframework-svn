/*
 * Group.java, Oct 26, 2007, 7:59:33 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.model.user;

import com.form105.rm.base.model.AgentObject;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


/**
 *
 * @author Heiko Kundlacz
 */
@Entity(name="t_group")
@Inheritance(strategy=InheritanceType.JOINED)
public class Group extends AgentObject implements Serializable {

  @OneToMany
  private Set<String> accessIds = new HashSet<String>();
  
  public void addAccessId(String accessId) {
    accessIds.add(accessId);
  }
  
  public void removeAccessId(String accessId) {
    accessIds.remove(accessId);
  }
  
  public boolean accessAllowed(String accessId) {
    return accessIds.contains(accessId);
  }
  
  public boolean accessDenied(String accessId) {
    return ! accessIds.contains(accessId);
  }
  
}