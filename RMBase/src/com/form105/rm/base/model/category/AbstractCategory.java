/*
 * AbstractCategory.java, Sep 30, 2007, 6:53:09 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.model.category;

/**
 *
 * @author Heiko Kundlacz
 */
class AbstractCategory implements ICategory {
  
  private long oid;
  private String name;
  private Category parent;
  
  public long getOid() {
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
  
  public Category getParent() {
    return parent;
  }

  public void setParent(Category parent) {
    this.parent = parent;
  }

}
