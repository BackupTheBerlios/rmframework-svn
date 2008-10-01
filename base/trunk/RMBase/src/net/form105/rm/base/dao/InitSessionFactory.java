/*
 * HibernateHandler.java, Sep 22, 2007, 6:13:24 PM
 *
 * Copyright (c) 2007, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package net.form105.rm.base.dao;

import javax.naming.InitialContext;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;

/**
 *
 * @author Heiko Kundlacz
 */
public class InitSessionFactory {

    /**
     * Default constructor.
     */
    private InitSessionFactory() {
    }
    /**
     * Location of hibernate.cfg.xml file. NOTICE: Location should be on the
     * classpath as Hibernate uses #resourceAsStream style lookup for its
     * configuration file. That is place the config file in a Java package - the
     * default location is the default Java package.
     */
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    /** The single instance of hibernate configuration */
    private static final AnnotationConfiguration cfg = new AnnotationConfiguration();
    /** The single instance of hibernate SessionFactory */
    private static org.hibernate.SessionFactory sessionFactory;

    /**
     * initialises the configuration if not yet done and returns the current
     * instance
     * 
     * @return
     */
    public static SessionFactory getInstance() {
        if (sessionFactory == null) {
            initSessionFactory();
        }
        return sessionFactory;
    }

    /**
     * Returns the ThreadLocal Session instance. Lazy initialize the
     * <code>SessionFactory</code> if needed.
     * 
     * @return Session
     * @throws HibernateException
     */
    public Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * The behaviour of this method depends on the session context you have
     * configured. This factory is intended to be used with a hibernate.cfg.xml
     * including the following property <property
     * name="current_session_context_class">thread</property> This would return
     * the current open session or if this does not exist, will create a new
     * session
     * 
     * @return
     */
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * initializes the sessionfactory in a safe way even if more than one thread
     * tries to build a sessionFactory
     */
    private static synchronized void initSessionFactory() {

        Logger logger = Logger.getLogger(InitSessionFactory.class);
        if (sessionFactory == null) {
            try {
                cfg.configure(CONFIG_FILE_LOCATION);
                String sessionFactoryJndiName = cfg.getProperty(Environment.SESSION_FACTORY_NAME);
                if (sessionFactoryJndiName != null) {
                    cfg.buildSessionFactory();
                    logger.debug("get a jndi session factory");
                    sessionFactory = (SessionFactory) (new InitialContext()).lookup(sessionFactoryJndiName);
                } else {
                    logger.debug("classic factory");
                    sessionFactory = cfg.buildSessionFactory();
                }

            } catch (Exception e) {
                logger.error("Error Creating HibernateSessionFactory");
                logger.error(e, e);
                throw new HibernateException("Could not initialize the Hibernate configuration");
            }
        }
    }

    public static void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        sessionFactory = null;

    }
}
