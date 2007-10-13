/*
 * CategoryDao.java, Oct 10, 2007, 8:13:42 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.server.dao;

import com.form105.rm.base.server.model.Category;
import org.hibernate.SessionFactory;


public class CategoryDao extends BasicDaoImp<Category, Integer>{
  
  public CategoryDao(SessionFactory factory) {
    super(Category.class, factory);
  }

}
