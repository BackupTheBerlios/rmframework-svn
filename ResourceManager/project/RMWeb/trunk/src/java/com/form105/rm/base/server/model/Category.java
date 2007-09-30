/*
 * Category.java, Sep 22, 2007, 6:32:37 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.server.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heiko
 */
public class Category extends AbstractCategory {
  
  private long oid;
  
  private List<Category> children = new ArrayList<Category>();
  private String testName;
  
  public long getOid() {
    return oid;
  }
  
  public void setOid(Long oid) {
    this.oid = oid;
  }
  
  public void addChild(Category category) {
    category.setParent(this);
    getChildren().add(category);
  }
  
  private void removeChild(Category category) {
    getChildren().remove(category);
  }

  public List<Category> getChildren() {
    return children;
  }

  public void setChildren(List<Category> children) {
    this.children = children;
  }

  public String getTestName() {
    return testName;
  }

  public void setTestName(String testName) {
    this.testName = testName;
  }
}
