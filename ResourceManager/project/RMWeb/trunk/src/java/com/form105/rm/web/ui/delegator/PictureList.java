/*
 * PictureList.java, Nov 10, 2007, 5:40:53 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.web.ui.delegator;

import com.form105.rm.web.base.component.table.ITableContentProvider;
import com.form105.rm.web.base.component.table.ITableLabelProvider;
import com.form105.rm.web.base.component.table.TableControl;
import com.form105.rm.web.ui.table.provider.TablePictureContentProvider;
import com.form105.rm.web.ui.table.provider.TablePictureLabelProvider;
import java.util.ArrayList;
import java.util.List;
import org.richfaces.component.html.HtmlDataTable;

/**
 *
 * @author heiko
 */
public class PictureList {

  private List<Picture> pictureList = new ArrayList<Picture>();
  private HtmlDataTable table = new HtmlDataTable();
  private TableControl tableControl;

  public PictureList() {
    
    table = new HtmlDataTable();
		tableControl = new TableControl(table);
    
    
    pictureList = new ArrayList<Picture>();
    for (int i = 0; i < 26; i++) {
      Picture pic = new Picture();
      pic.setId("00" + i);
      pic.setName("Picture 00" + i);
      pic.setPath("/Users/home/heiko/pic00" + i);
      pictureList.add(pic);

    }
  }

  public List getList() {
    return tableControl.getRowsList();
  }

  public HtmlDataTable getTable() {
    
    ArrayList headerList = new ArrayList();
    headerList.add("Column1");
    headerList.add("Column2");
    headerList.add("Column3");
    
    ITableLabelProvider labelProvider = new TablePictureLabelProvider();
		ITableContentProvider contentProvider = new TablePictureContentProvider();
		tableControl.setLabelProvider(labelProvider);
		tableControl.setContentProvider(contentProvider);
		tableControl.setInput(pictureList);
    
    tableControl.setHeaderList(headerList);
		tableControl.createTable();
    
    return table;
  }

  public void setTable(HtmlDataTable table) {
    this.table = table;
  }

  
}
