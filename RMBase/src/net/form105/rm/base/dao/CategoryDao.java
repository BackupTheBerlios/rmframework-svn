/*
 * CategoryDao.java, Oct 10, 2007, 8:13:42 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.dao;

import net.form105.rm.base.model.category.Category;

import org.hibernate.SessionFactory;


public class CategoryDao extends BasicDBDaoImpl<Category, Integer>{
  
  public CategoryDao(SessionFactory factory) {
    super(Category.class, factory);
  }

}
