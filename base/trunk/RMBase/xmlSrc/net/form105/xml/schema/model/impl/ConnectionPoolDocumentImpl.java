/*
 * An XML document type.
 * Localname: connectionPool
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ConnectionPoolDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one connectionPool(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class ConnectionPoolDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ConnectionPoolDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionPoolDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONPOOL$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "connectionPool");
    
    
    /**
     * Gets the "connectionPool" element
     */
    public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool getConnectionPool()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool target = null;
            target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool)get_store().find_element_user(CONNECTIONPOOL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "connectionPool" element
     */
    public void setConnectionPool(net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool connectionPool)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool target = null;
            target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool)get_store().find_element_user(CONNECTIONPOOL$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool)get_store().add_element_user(CONNECTIONPOOL$0);
            }
            target.set(connectionPool);
        }
    }
    
    /**
     * Appends and returns a new empty "connectionPool" element
     */
    public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool addNewConnectionPool()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool target = null;
            target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool)get_store().add_element_user(CONNECTIONPOOL$0);
            return target;
        }
    }
    /**
     * An XML connectionPool(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class ConnectionPoolImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool
    {
        private static final long serialVersionUID = 1L;
        
        public ConnectionPoolImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName INBOUND$0 = 
            new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "inbound");
        private static final javax.xml.namespace.QName OUTBOUND$2 = 
            new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "outbound");
        
        
        /**
         * Gets array of all "inbound" elements
         */
        public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound[] getInboundArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(INBOUND$0, targetList);
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound[] result = new net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "inbound" element
         */
        public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound getInboundArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound target = null;
                target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound)get_store().find_element_user(INBOUND$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "inbound" element
         */
        public int sizeOfInboundArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(INBOUND$0);
            }
        }
        
        /**
         * Sets array of all "inbound" element
         */
        public void setInboundArray(net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound[] inboundArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(inboundArray, INBOUND$0);
            }
        }
        
        /**
         * Sets ith "inbound" element
         */
        public void setInboundArray(int i, net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound inbound)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound target = null;
                target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound)get_store().find_element_user(INBOUND$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(inbound);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "inbound" element
         */
        public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound insertNewInbound(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound target = null;
                target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound)get_store().insert_element_user(INBOUND$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "inbound" element
         */
        public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound addNewInbound()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound target = null;
                target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound)get_store().add_element_user(INBOUND$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "inbound" element
         */
        public void removeInbound(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(INBOUND$0, i);
            }
        }
        
        /**
         * Gets array of all "outbound" elements
         */
        public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound[] getOutboundArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(OUTBOUND$2, targetList);
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound[] result = new net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "outbound" element
         */
        public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound getOutboundArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound target = null;
                target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound)get_store().find_element_user(OUTBOUND$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "outbound" element
         */
        public int sizeOfOutboundArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(OUTBOUND$2);
            }
        }
        
        /**
         * Sets array of all "outbound" element
         */
        public void setOutboundArray(net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound[] outboundArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(outboundArray, OUTBOUND$2);
            }
        }
        
        /**
         * Sets ith "outbound" element
         */
        public void setOutboundArray(int i, net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound outbound)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound target = null;
                target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound)get_store().find_element_user(OUTBOUND$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(outbound);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "outbound" element
         */
        public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound insertNewOutbound(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound target = null;
                target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound)get_store().insert_element_user(OUTBOUND$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "outbound" element
         */
        public net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound addNewOutbound()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound target = null;
                target = (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound)get_store().add_element_user(OUTBOUND$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "outbound" element
         */
        public void removeOutbound(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(OUTBOUND$2, i);
            }
        }
        /**
         * An XML inbound(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public static class InboundImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound
        {
            private static final long serialVersionUID = 1L;
            
            public InboundImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName ID$0 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "id");
            private static final javax.xml.namespace.QName ALIAS$2 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "alias");
            private static final javax.xml.namespace.QName HOST$4 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "host");
            private static final javax.xml.namespace.QName PORT$6 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "port");
            private static final javax.xml.namespace.QName TYPE$8 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "type");
            private static final javax.xml.namespace.QName SIZEPENDINGQUEUE$10 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "sizePendingQueue");
            private static final javax.xml.namespace.QName VALIDATORKEY$12 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "validatorKey");
            private static final javax.xml.namespace.QName PACKETSIZE$14 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "packetSize");
            private static final javax.xml.namespace.QName CONTENTIDENTIFIER$16 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "contentIdentifier");
            
            
            /**
             * Gets the "id" element
             */
            public java.lang.String getId()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "id" element
             */
            public org.apache.xmlbeans.XmlString xgetId()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "id" element
             */
            public void setId(java.lang.String id)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ID$0);
                    }
                    target.setStringValue(id);
                }
            }
            
            /**
             * Sets (as xml) the "id" element
             */
            public void xsetId(org.apache.xmlbeans.XmlString id)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ID$0);
                    }
                    target.set(id);
                }
            }
            
            /**
             * Gets the "alias" element
             */
            public java.lang.String getAlias()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ALIAS$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "alias" element
             */
            public org.apache.xmlbeans.XmlString xgetAlias()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ALIAS$2, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "alias" element
             */
            public void setAlias(java.lang.String alias)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ALIAS$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ALIAS$2);
                    }
                    target.setStringValue(alias);
                }
            }
            
            /**
             * Sets (as xml) the "alias" element
             */
            public void xsetAlias(org.apache.xmlbeans.XmlString alias)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ALIAS$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ALIAS$2);
                    }
                    target.set(alias);
                }
            }
            
            /**
             * Gets the "host" element
             */
            public java.lang.String getHost()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HOST$4, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "host" element
             */
            public org.apache.xmlbeans.XmlString xgetHost()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HOST$4, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "host" element
             */
            public void setHost(java.lang.String host)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HOST$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(HOST$4);
                    }
                    target.setStringValue(host);
                }
            }
            
            /**
             * Sets (as xml) the "host" element
             */
            public void xsetHost(org.apache.xmlbeans.XmlString host)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HOST$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(HOST$4);
                    }
                    target.set(host);
                }
            }
            
            /**
             * Gets the "port" element
             */
            public int getPort()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PORT$6, 0);
                    if (target == null)
                    {
                      return 0;
                    }
                    return target.getIntValue();
                }
            }
            
            /**
             * Gets (as xml) the "port" element
             */
            public org.apache.xmlbeans.XmlInt xgetPort()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(PORT$6, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "port" element
             */
            public void setPort(int port)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PORT$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PORT$6);
                    }
                    target.setIntValue(port);
                }
            }
            
            /**
             * Sets (as xml) the "port" element
             */
            public void xsetPort(org.apache.xmlbeans.XmlInt port)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(PORT$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(PORT$6);
                    }
                    target.set(port);
                }
            }
            
            /**
             * Gets the "type" element
             */
            public java.lang.String getType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$8, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "type" element
             */
            public org.apache.xmlbeans.XmlString xgetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPE$8, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "type" element
             */
            public void setType(java.lang.String type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$8);
                    }
                    target.setStringValue(type);
                }
            }
            
            /**
             * Sets (as xml) the "type" element
             */
            public void xsetType(org.apache.xmlbeans.XmlString type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPE$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TYPE$8);
                    }
                    target.set(type);
                }
            }
            
            /**
             * Gets the "sizePendingQueue" element
             */
            public int getSizePendingQueue()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIZEPENDINGQUEUE$10, 0);
                    if (target == null)
                    {
                      return 0;
                    }
                    return target.getIntValue();
                }
            }
            
            /**
             * Gets (as xml) the "sizePendingQueue" element
             */
            public org.apache.xmlbeans.XmlInt xgetSizePendingQueue()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(SIZEPENDINGQUEUE$10, 0);
                    return target;
                }
            }
            
            /**
             * True if has "sizePendingQueue" element
             */
            public boolean isSetSizePendingQueue()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().count_elements(SIZEPENDINGQUEUE$10) != 0;
                }
            }
            
            /**
             * Sets the "sizePendingQueue" element
             */
            public void setSizePendingQueue(int sizePendingQueue)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SIZEPENDINGQUEUE$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SIZEPENDINGQUEUE$10);
                    }
                    target.setIntValue(sizePendingQueue);
                }
            }
            
            /**
             * Sets (as xml) the "sizePendingQueue" element
             */
            public void xsetSizePendingQueue(org.apache.xmlbeans.XmlInt sizePendingQueue)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(SIZEPENDINGQUEUE$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(SIZEPENDINGQUEUE$10);
                    }
                    target.set(sizePendingQueue);
                }
            }
            
            /**
             * Unsets the "sizePendingQueue" element
             */
            public void unsetSizePendingQueue()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_element(SIZEPENDINGQUEUE$10, 0);
                }
            }
            
            /**
             * Gets the "validatorKey" element
             */
            public java.lang.String getValidatorKey()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VALIDATORKEY$12, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "validatorKey" element
             */
            public org.apache.xmlbeans.XmlString xgetValidatorKey()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VALIDATORKEY$12, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "validatorKey" element
             */
            public void setValidatorKey(java.lang.String validatorKey)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VALIDATORKEY$12, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VALIDATORKEY$12);
                    }
                    target.setStringValue(validatorKey);
                }
            }
            
            /**
             * Sets (as xml) the "validatorKey" element
             */
            public void xsetValidatorKey(org.apache.xmlbeans.XmlString validatorKey)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VALIDATORKEY$12, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(VALIDATORKEY$12);
                    }
                    target.set(validatorKey);
                }
            }
            
            /**
             * Gets the "packetSize" element
             */
            public int getPacketSize()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PACKETSIZE$14, 0);
                    if (target == null)
                    {
                      return 0;
                    }
                    return target.getIntValue();
                }
            }
            
            /**
             * Gets (as xml) the "packetSize" element
             */
            public org.apache.xmlbeans.XmlInt xgetPacketSize()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(PACKETSIZE$14, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "packetSize" element
             */
            public void setPacketSize(int packetSize)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PACKETSIZE$14, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PACKETSIZE$14);
                    }
                    target.setIntValue(packetSize);
                }
            }
            
            /**
             * Sets (as xml) the "packetSize" element
             */
            public void xsetPacketSize(org.apache.xmlbeans.XmlInt packetSize)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(PACKETSIZE$14, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(PACKETSIZE$14);
                    }
                    target.set(packetSize);
                }
            }
            
            /**
             * Gets the "contentIdentifier" element
             */
            public java.lang.String getContentIdentifier()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTENTIDENTIFIER$16, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "contentIdentifier" element
             */
            public org.apache.xmlbeans.XmlString xgetContentIdentifier()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONTENTIDENTIFIER$16, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "contentIdentifier" element
             */
            public void setContentIdentifier(java.lang.String contentIdentifier)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTENTIDENTIFIER$16, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTENTIDENTIFIER$16);
                    }
                    target.setStringValue(contentIdentifier);
                }
            }
            
            /**
             * Sets (as xml) the "contentIdentifier" element
             */
            public void xsetContentIdentifier(org.apache.xmlbeans.XmlString contentIdentifier)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONTENTIDENTIFIER$16, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CONTENTIDENTIFIER$16);
                    }
                    target.set(contentIdentifier);
                }
            }
        }
        /**
         * An XML outbound(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public static class OutboundImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound
        {
            private static final long serialVersionUID = 1L;
            
            public OutboundImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName ID$0 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "id");
            private static final javax.xml.namespace.QName ALIAS$2 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "alias");
            private static final javax.xml.namespace.QName HOST$4 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "host");
            private static final javax.xml.namespace.QName PORT$6 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "port");
            private static final javax.xml.namespace.QName TYPE$8 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "type");
            
            
            /**
             * Gets the "id" element
             */
            public java.lang.String getId()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "id" element
             */
            public org.apache.xmlbeans.XmlString xgetId()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "id" element
             */
            public void setId(java.lang.String id)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ID$0);
                    }
                    target.setStringValue(id);
                }
            }
            
            /**
             * Sets (as xml) the "id" element
             */
            public void xsetId(org.apache.xmlbeans.XmlString id)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ID$0);
                    }
                    target.set(id);
                }
            }
            
            /**
             * Gets the "alias" element
             */
            public java.lang.String getAlias()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ALIAS$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "alias" element
             */
            public org.apache.xmlbeans.XmlString xgetAlias()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ALIAS$2, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "alias" element
             */
            public void setAlias(java.lang.String alias)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ALIAS$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ALIAS$2);
                    }
                    target.setStringValue(alias);
                }
            }
            
            /**
             * Sets (as xml) the "alias" element
             */
            public void xsetAlias(org.apache.xmlbeans.XmlString alias)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ALIAS$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ALIAS$2);
                    }
                    target.set(alias);
                }
            }
            
            /**
             * Gets the "host" element
             */
            public java.lang.String getHost()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HOST$4, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "host" element
             */
            public org.apache.xmlbeans.XmlString xgetHost()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HOST$4, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "host" element
             */
            public void setHost(java.lang.String host)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HOST$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(HOST$4);
                    }
                    target.setStringValue(host);
                }
            }
            
            /**
             * Sets (as xml) the "host" element
             */
            public void xsetHost(org.apache.xmlbeans.XmlString host)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HOST$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(HOST$4);
                    }
                    target.set(host);
                }
            }
            
            /**
             * Gets the "port" element
             */
            public int getPort()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PORT$6, 0);
                    if (target == null)
                    {
                      return 0;
                    }
                    return target.getIntValue();
                }
            }
            
            /**
             * Gets (as xml) the "port" element
             */
            public org.apache.xmlbeans.XmlInt xgetPort()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(PORT$6, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "port" element
             */
            public void setPort(int port)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PORT$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PORT$6);
                    }
                    target.setIntValue(port);
                }
            }
            
            /**
             * Sets (as xml) the "port" element
             */
            public void xsetPort(org.apache.xmlbeans.XmlInt port)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlInt target = null;
                    target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(PORT$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(PORT$6);
                    }
                    target.set(port);
                }
            }
            
            /**
             * Gets the "type" element
             */
            public java.lang.String getType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$8, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "type" element
             */
            public org.apache.xmlbeans.XmlString xgetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPE$8, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "type" element
             */
            public void setType(java.lang.String type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$8);
                    }
                    target.setStringValue(type);
                }
            }
            
            /**
             * Sets (as xml) the "type" element
             */
            public void xsetType(org.apache.xmlbeans.XmlString type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TYPE$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TYPE$8);
                    }
                    target.set(type);
                }
            }
        }
    }
}
