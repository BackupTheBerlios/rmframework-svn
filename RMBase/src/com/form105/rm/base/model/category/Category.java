/*
 * Category.java, Oct 5, 2007, 10:11:25 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.model.category;

import com.form105.rm.base.model.AgentObject;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Heiko Kundlacz
 */

@Entity
@PrimaryKeyJoinColumn(name="AGENTOBJECT_ID")
public class Category extends AgentObject implements Serializable {

  @OneToMany(mappedBy="parent", cascade=CascadeType.ALL)
  private Set<Category> children = new HashSet<Category>();
  
  @ManyToOne
  @JoinColumn(name="parent_id")
  private Category parent;



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
