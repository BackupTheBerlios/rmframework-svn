/*
 * An XML document type.
 * Localname: Notifications
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.NotificationsDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one Notifications(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class NotificationsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.NotificationsDocument
{
    private static final long serialVersionUID = 1L;
    
    public NotificationsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NOTIFICATIONS$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Notifications");
    
    
    /**
     * Gets the "Notifications" element
     */
    public net.form105.xml.schema.model.NotificationsDocument.Notifications getNotifications()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.NotificationsDocument.Notifications target = null;
            target = (net.form105.xml.schema.model.NotificationsDocument.Notifications)get_store().find_element_user(NOTIFICATIONS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Notifications" element
     */
    public void setNotifications(net.form105.xml.schema.model.NotificationsDocument.Notifications notifications)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.NotificationsDocument.Notifications target = null;
            target = (net.form105.xml.schema.model.NotificationsDocument.Notifications)get_store().find_element_user(NOTIFICATIONS$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.NotificationsDocument.Notifications)get_store().add_element_user(NOTIFICATIONS$0);
            }
            target.set(notifications);
        }
    }
    
    /**
     * Appends and returns a new empty "Notifications" element
     */
    public net.form105.xml.schema.model.NotificationsDocument.Notifications addNewNotifications()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.NotificationsDocument.Notifications target = null;
            target = (net.form105.xml.schema.model.NotificationsDocument.Notifications)get_store().add_element_user(NOTIFICATIONS$0);
            return target;
        }
    }
    /**
     * An XML Notifications(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class NotificationsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.NotificationsDocument.Notifications
    {
        private static final long serialVersionUID = 1L;
        
        public NotificationsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName COMMAND$0 = 
            new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Command");
        
        
        /**
         * Gets the "Command" element
         */
        public net.form105.xml.schema.model.CommandDocument.Command getCommand()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.CommandDocument.Command target = null;
                target = (net.form105.xml.schema.model.CommandDocument.Command)get_store().find_element_user(COMMAND$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "Command" element
         */
        public void setCommand(net.form105.xml.schema.model.CommandDocument.Command command)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.CommandDocument.Command target = null;
                target = (net.form105.xml.schema.model.CommandDocument.Command)get_store().find_element_user(COMMAND$0, 0);
                if (target == null)
                {
                    target = (net.form105.xml.schema.model.CommandDocument.Command)get_store().add_element_user(COMMAND$0);
                }
                target.set(command);
            }
        }
        
        /**
         * Appends and returns a new empty "Command" element
         */
        public net.form105.xml.schema.model.CommandDocument.Command addNewCommand()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.CommandDocument.Command target = null;
                target = (net.form105.xml.schema.model.CommandDocument.Command)get_store().add_element_user(COMMAND$0);
                return target;
            }
        }
    }
}
