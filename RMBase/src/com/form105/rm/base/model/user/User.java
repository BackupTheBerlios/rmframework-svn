package com.form105.rm.base.model.user;

import com.form105.rm.base.model.user.Group;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "SystemUser")
public class User implements Serializable {

  @Id
  private Integer id;
  private String name;
  private String sirName;
  private String eMail;
  
  @OneToMany
  private Set<Group> groups = new HashSet<Group>();

  public Set<Group> getGroups() {
    return groups;
  }

  public void setGroups(Set<Group> groups) {
    this.groups = groups;
  }
  
  
  
  
}