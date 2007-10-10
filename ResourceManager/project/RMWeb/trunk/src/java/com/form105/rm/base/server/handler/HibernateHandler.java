/*
 * HibernateHandler.java, Sep 22, 2007, 6:13:24 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */

package com.form105.rm.base.server.handler;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Heiko Kundlacz
 */
public class HibernateHandler {

  private static Logger logger = Logger.getLogger(HibernateHandler.class);
  private static final SessionFactory sessionFactory;
  static {
    final AnnotationConfiguration cfg = new AnnotationConfiguration();
    cfg.configure("/hibernate.cfg.xml");
    sessionFactory = cfg.buildSessionFactory();
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  /**
   * Closes the Hibernate Session.  Users must call this method after calling
   * @throws HibernateException if session has problem closing.
   */
  public static void closeSessionFactory() throws HibernateException {
    sessionFactory.close();
  }
}