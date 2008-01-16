/* 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.dao;

import com.form105.rm.base.model.image.Image;
import org.hibernate.SessionFactory;


public class ImageDao extends BasicDBDaoImpl<Image, Long>{
  
  public ImageDao(SessionFactory factory) {
    super(Image.class, factory);
  }

}
