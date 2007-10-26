/*
 * Group.java, Oct 26, 2007, 7:59:33 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.model.user;

import javax.persistence.Id;

/**
 *
 * @author heiko
 */
public class Group {

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