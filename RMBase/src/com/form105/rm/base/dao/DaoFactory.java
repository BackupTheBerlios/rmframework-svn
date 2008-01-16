package com.form105.rm.base.dao;

public class DaoFactory {

  private DaoFactory() {
  }

  public static CategoryDao getCategoryDao() {
    return new CategoryDao(InitSessionFactory.getInstance());
  }
  
  public static ImageDao getImageDao() {
    return new ImageDao(InitSessionFactory.getInstance());
  }
  
  
}