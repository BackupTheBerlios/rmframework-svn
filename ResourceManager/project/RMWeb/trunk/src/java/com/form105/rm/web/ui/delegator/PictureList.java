/*
 * PictureList.java, Nov 10, 2007, 5:40:53 PM
 * 
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.rm.web.ui.delegator;

import com.form105.rm.web.base.component.table.TableControl;
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

  public PictureList() {
    pictureList = new ArrayList<Picture>();
    for (int i = 0; i < 26; i++) {
      Picture pic = new Picture();
      pic.setId("00" + i);
      pic.setName("Picture 00" + i);
      pic.setPath("/Users/home/heiko/pic00" + i);
      pictureList.add(pic);
      
      
      TableControl control = new TableControl(getTable());
      
     
      
      
      
    } 
  }

  public List<Picture> getList() {
    return pictureList;
  }

  public HtmlDataTable getTable() {
    return table;
  }

  public void setTable(HtmlDataTable table) {
    this.table = table;
  }
  

public class Picture {

  private String id;
  private String name;
  private String path;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getPath() {
      return path;
    }

    public void setPath(String path) {
      this.path = path;
    }
  }

}
