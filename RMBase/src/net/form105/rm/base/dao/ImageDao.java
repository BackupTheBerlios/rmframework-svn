/* 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package net.form105.rm.base.dao;

import net.form105.rm.base.model.image.ImageData;

import org.hibernate.SessionFactory;


public class ImageDao extends BasicDBDaoImpl<ImageData, Long>{
  
  public ImageDao(SessionFactory factory) {
    super(ImageData.class, factory);
  }

}
