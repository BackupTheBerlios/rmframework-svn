/*
 * TablePictureLabelProvider.java, Nov 11, 2007, 6:03:38 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.web.ui.table.provider;

import com.form105.rm.web.base.component.table.ITableLabelProvider;
import com.form105.rm.web.ui.delegator.Picture;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heiko
 */
public class TablePictureLabelProvider implements ITableLabelProvider {

  public List getColumnText(List<String> list) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public List getContent(Object object) {
    Picture picture = (Picture) object;
    
    
    ArrayList list = new ArrayList();
    list.add(picture.getId());
    list.add(picture.getName());
    list.add(picture.getPath());
    
    return list;
  }

}
