/*
 * An XML document type.
 * Localname: ComElements
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ComElementsDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one ComElements(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class ComElementsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ComElementsDocument
{
    private static final long serialVersionUID = 1L;
    
    public ComElementsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMELEMENTS$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "ComElements");
    
    
    /**
     * Gets the "ComElements" element
     */
    public net.form105.xml.schema.model.ComElementsDocument.ComElements getComElements()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ComElementsDocument.ComElements target = null;
            target = (net.form105.xml.schema.model.ComElementsDocument.ComElements)get_store().find_element_user(COMELEMENTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ComElements" element
     */
    public void setComElements(net.form105.xml.schema.model.ComElementsDocument.ComElements comElements)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ComElementsDocument.ComElements target = null;
            target = (net.form105.xml.schema.model.ComElementsDocument.ComElements)get_store().find_element_user(COMELEMENTS$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.ComElementsDocument.ComElements)get_store().add_element_user(COMELEMENTS$0);
            }
            target.set(comElements);
        }
    }
    
    /**
     * Appends and returns a new empty "ComElements" element
     */
    public net.form105.xml.schema.model.ComElementsDocument.ComElements addNewComElements()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ComElementsDocument.ComElements target = null;
            target = (net.form105.xml.schema.model.ComElementsDocument.ComElements)get_store().add_element_user(COMELEMENTS$0);
            return target;
        }
    }
    /**
     * An XML ComElements(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class ComElementsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ComElementsDocument.ComElements
    {
        private static final long serialVersionUID = 1L;
        
        public ComElementsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName KEY$0 = 
            new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Key");
        
        
        /**
         * Gets array of all "Key" elements
         */
        public net.form105.xml.schema.model.ComElementsDocument.ComElements.Key[] getKeyArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(KEY$0, targetList);
                net.form105.xml.schema.model.ComElementsDocument.ComElements.Key[] result = new net.form105.xml.schema.model.ComElementsDocument.ComElements.Key[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Key" element
         */
        public net.form105.xml.schema.model.ComElementsDocument.ComElements.Key getKeyArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ComElementsDocument.ComElements.Key target = null;
                target = (net.form105.xml.schema.model.ComElementsDocument.ComElements.Key)get_store().find_element_user(KEY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Key" element
         */
        public int sizeOfKeyArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(KEY$0);
            }
        }
        
        /**
         * Sets array of all "Key" element
         */
        public void setKeyArray(net.form105.xml.schema.model.ComElementsDocument.ComElements.Key[] keyArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(keyArray, KEY$0);
            }
        }
        
        /**
         * Sets ith "Key" element
         */
        public void setKeyArray(int i, net.form105.xml.schema.model.ComElementsDocument.ComElements.Key key)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ComElementsDocument.ComElements.Key target = null;
                target = (net.form105.xml.schema.model.ComElementsDocument.ComElements.Key)get_store().find_element_user(KEY$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(key);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Key" element
         */
        public net.form105.xml.schema.model.ComElementsDocument.ComElements.Key insertNewKey(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ComElementsDocument.ComElements.Key target = null;
                target = (net.form105.xml.schema.model.ComElementsDocument.ComElements.Key)get_store().insert_element_user(KEY$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Key" element
         */
        public net.form105.xml.schema.model.ComElementsDocument.ComElements.Key addNewKey()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ComElementsDocument.ComElements.Key target = null;
                target = (net.form105.xml.schema.model.ComElementsDocument.ComElements.Key)get_store().add_element_user(KEY$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Key" element
         */
        public void removeKey(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(KEY$0, i);
            }
        }
        /**
         * An XML Key(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public static class KeyImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ComElementsDocument.ComElements.Key
        {
            private static final long serialVersionUID = 1L;
            
            public KeyImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName TELEGRAMS$0 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Telegrams");
            private static final javax.xml.namespace.QName NOTIFICATIONS$2 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Notifications");
            private static final javax.xml.namespace.QName K1$4 = 
                new javax.xml.namespace.QName("", "k1");
            private static final javax.xml.namespace.QName K2$6 = 
                new javax.xml.namespace.QName("", "k2");
            
            
            /**
             * Gets the "Telegrams" element
             */
            public net.form105.xml.schema.model.TelegramsDocument.Telegrams getTelegrams()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.TelegramsDocument.Telegrams target = null;
                    target = (net.form105.xml.schema.model.TelegramsDocument.Telegrams)get_store().find_element_user(TELEGRAMS$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target;
                }
            }
            
            /**
             * Sets the "Telegrams" element
             */
            public void setTelegrams(net.form105.xml.schema.model.TelegramsDocument.Telegrams telegrams)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.TelegramsDocument.Telegrams target = null;
                    target = (net.form105.xml.schema.model.TelegramsDocument.Telegrams)get_store().find_element_user(TELEGRAMS$0, 0);
                    if (target == null)
                    {
                      target = (net.form105.xml.schema.model.TelegramsDocument.Telegrams)get_store().add_element_user(TELEGRAMS$0);
                    }
                    target.set(telegrams);
                }
            }
            
            /**
             * Appends and returns a new empty "Telegrams" element
             */
            public net.form105.xml.schema.model.TelegramsDocument.Telegrams addNewTelegrams()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.TelegramsDocument.Telegrams target = null;
                    target = (net.form105.xml.schema.model.TelegramsDocument.Telegrams)get_store().add_element_user(TELEGRAMS$0);
                    return target;
                }
            }
            
            /**
             * Gets the "Notifications" element
             */
            public net.form105.xml.schema.model.NotificationsDocument.Notifications getNotifications()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.NotificationsDocument.Notifications target = null;
                    target = (net.form105.xml.schema.model.NotificationsDocument.Notifications)get_store().find_element_user(NOTIFICATIONS$2, 0);
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
                    target = (net.form105.xml.schema.model.NotificationsDocument.Notifications)get_store().find_element_user(NOTIFICATIONS$2, 0);
                    if (target == null)
                    {
                      target = (net.form105.xml.schema.model.NotificationsDocument.Notifications)get_store().add_element_user(NOTIFICATIONS$2);
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
                    target = (net.form105.xml.schema.model.NotificationsDocument.Notifications)get_store().add_element_user(NOTIFICATIONS$2);
                    return target;
                }
            }
            
            /**
             * Gets the "k1" attribute
             */
            public java.lang.String getK1()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(K1$4);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "k1" attribute
             */
            public org.apache.xmlbeans.XmlString xgetK1()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(K1$4);
                    return target;
                }
            }
            
            /**
             * True if has "k1" attribute
             */
            public boolean isSetK1()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(K1$4) != null;
                }
            }
            
            /**
             * Sets the "k1" attribute
             */
            public void setK1(java.lang.String k1)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(K1$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(K1$4);
                    }
                    target.setStringValue(k1);
                }
            }
            
            /**
             * Sets (as xml) the "k1" attribute
             */
            public void xsetK1(org.apache.xmlbeans.XmlString k1)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(K1$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(K1$4);
                    }
                    target.set(k1);
                }
            }
            
            /**
             * Unsets the "k1" attribute
             */
            public void unsetK1()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(K1$4);
                }
            }
            
            /**
             * Gets the "k2" attribute
             */
            public java.lang.String getK2()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(K2$6);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "k2" attribute
             */
            public org.apache.xmlbeans.XmlString xgetK2()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(K2$6);
                    return target;
                }
            }
            
            /**
             * True if has "k2" attribute
             */
            public boolean isSetK2()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(K2$6) != null;
                }
            }
            
            /**
             * Sets the "k2" attribute
             */
            public void setK2(java.lang.String k2)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(K2$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(K2$6);
                    }
                    target.setStringValue(k2);
                }
            }
            
            /**
             * Sets (as xml) the "k2" attribute
             */
            public void xsetK2(org.apache.xmlbeans.XmlString k2)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(K2$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(K2$6);
                    }
                    target.set(k2);
                }
            }
            
            /**
             * Unsets the "k2" attribute
             */
            public void unsetK2()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(K2$6);
                }
            }
        }
    }
}
