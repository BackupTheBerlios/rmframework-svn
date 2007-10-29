/*
 * AgentObject.java, Oct 28, 2007, 6:23:18 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Heiko Kundlacz
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AgentObject {
  
  @Id
  private Integer id;
  private String name;
  
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
