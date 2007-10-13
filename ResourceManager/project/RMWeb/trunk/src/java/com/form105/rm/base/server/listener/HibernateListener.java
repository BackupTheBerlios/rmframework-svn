/*
 * HibernateListener.java
 * 
 * Created on Sep 22, 2007, 5:38:49 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.form105.rm.base.server.listener;

import com.form105.rm.base.server.handler.InitSessionFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Heiko Kundlacz
 */
public class HibernateListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent arg0) {
        InitSessionFactory.getInstance();
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        InitSessionFactory.close();
    }
    
}
