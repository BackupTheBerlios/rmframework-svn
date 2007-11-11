/*
 * TablePictureContentProvider.java, Nov 11, 2007, 5:48:26 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.web.ui.table.provider;

import com.form105.rm.web.base.component.table.ITableContentProvider;
import com.form105.rm.web.ui.delegator.Picture;
import java.util.List;

/**
 *
 * @author heiko
 */
public class TablePictureContentProvider implements ITableContentProvider {

  public List getElements(Object object) {
    List<Picture> list = (List) object;
    return list;
  }

}
