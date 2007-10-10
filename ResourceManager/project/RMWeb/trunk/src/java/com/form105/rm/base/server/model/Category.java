/*
 * Category.java, Oct 5, 2007, 10:11:25 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.server.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Heiko Kundlacz
 */

@Entity
public class Category implements Serializable {

  @Id
  private long oid;
  private String name;
  @OneToMany(mappedBy="parent", cascade=CascadeType.ALL)
  private Set<Category> children = new HashSet<Category>();
  
  @ManyToOne
  @JoinColumn(name="parent_id")
  private Category parent;

  public long getOid() {
    return oid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Category> getChildren() {
    return children;
  }

  public void setChildren(Set<Category> children) {
    this.children = children;
  }

  public Category getParent() {
    return parent;
  }

  public void setParent(Category parent) {
    this.parent = parent;
  }
  
  
}
