/*
 * Category.java, Oct 5, 2007, 10:11:25 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base.model.category;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Heiko Kundlacz
 */

public class Category implements Serializable {
    
    private Long id;
    
    private Set<Category> children = new HashSet<Category>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
