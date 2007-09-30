/*
 * HibernateListener.java
 * 
 * Created on Sep 22, 2007, 5:38:49 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.server.listener;

import com.form105.rm.base.server.handler.HibernateHandler;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Heiko Kundlacz
 */
public class HibernateListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent arg0) {
        HibernateHandler.getSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        HibernateHandler.closeSessionFactory();
    }
    
}
