/*
 * An XML document type.
 * Localname: plcMessages
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.PlcMessagesDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one plcMessages(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class PlcMessagesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.PlcMessagesDocument
{
    
    public PlcMessagesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PLCMESSAGES$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "plcMessages");
    
    
    /**
     * Gets the "plcMessages" element
     */
    public net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages getPlcMessages()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages target = null;
            target = (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages)get_store().find_element_user(PLCMESSAGES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "plcMessages" element
     */
    public void setPlcMessages(net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages plcMessages)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages target = null;
            target = (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages)get_store().find_element_user(PLCMESSAGES$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages)get_store().add_element_user(PLCMESSAGES$0);
            }
            target.set(plcMessages);
        }
    }
    
    /**
     * Appends and returns a new empty "plcMessages" element
     */
    public net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages addNewPlcMessages()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages target = null;
            target = (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages)get_store().add_element_user(PLCMESSAGES$0);
            return target;
        }
    }
    /**
     * An XML plcMessages(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class PlcMessagesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages
    {
        
        public PlcMessagesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PLCMESSAGE$0 = 
            new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "plcMessage");
        
        
        /**
         * Gets array of all "plcMessage" elements
         */
        public net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage[] getPlcMessageArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PLCMESSAGE$0, targetList);
                net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage[] result = new net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "plcMessage" element
         */
        public net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage getPlcMessageArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage target = null;
                target = (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage)get_store().find_element_user(PLCMESSAGE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "plcMessage" element
         */
        public int sizeOfPlcMessageArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PLCMESSAGE$0);
            }
        }
        
        /**
         * Sets array of all "plcMessage" element
         */
        public void setPlcMessageArray(net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage[] plcMessageArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(plcMessageArray, PLCMESSAGE$0);
            }
        }
        
        /**
         * Sets ith "plcMessage" element
         */
        public void setPlcMessageArray(int i, net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage plcMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage target = null;
                target = (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage)get_store().find_element_user(PLCMESSAGE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(plcMessage);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "plcMessage" element
         */
        public net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage insertNewPlcMessage(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage target = null;
                target = (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage)get_store().insert_element_user(PLCMESSAGE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "plcMessage" element
         */
        public net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage addNewPlcMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage target = null;
                target = (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage)get_store().add_element_user(PLCMESSAGE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "plcMessage" element
         */
        public void removePlcMessage(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PLCMESSAGE$0, i);
            }
        }
        /**
         * An XML plcMessage(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public static class PlcMessageImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage
        {
            
            public PlcMessageImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName ID$0 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "id");
            private static final javax.xml.namespace.QName NAME$2 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "name");
            private static final javax.xml.namespace.QName TYPE$4 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "type");
            private static final javax.xml.namespace.QName SECTOR$6 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "sector");
            private static final javax.xml.namespace.QName ADDRESS$8 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "address");
            private static final javax.xml.namespace.QName DATACONVERTER$10 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "dataConverter");
            private static final javax.xml.namespace.QName CONNECTIONTYPE$12 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "connectionType");
            
            
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
             * Gets the "name" element
             */
            public java.lang.String getName()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "name" element
             */
            public org.apache.xmlbeans.XmlString xgetName()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$2, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "name" element
             */
            public void setName(java.lang.String name)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NAME$2);
                    }
                    target.setStringValue(name);
                }
            }
            
            /**
             * Sets (as xml) the "name" element
             */
            public void xsetName(org.apache.xmlbeans.XmlString name)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NAME$2);
                    }
                    target.set(name);
                }
            }
            
            /**
             * Gets the "type" element
             */
            public int getType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$4, 0);
                    if (target == null)
                    {
                      return 0;
                    }
                    return target.getIntValue();
                }
            }
            
            /**
             * Gets (as xml) the "type" element
             */
            public net.form105.xml.schema.model.TypeDocument.Type xgetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.TypeDocument.Type target = null;
                    target = (net.form105.xml.schema.model.TypeDocument.Type)get_store().find_element_user(TYPE$4, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "type" element
             */
            public void setType(int type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$4);
                    }
                    target.setIntValue(type);
                }
            }
            
            /**
             * Sets (as xml) the "type" element
             */
            public void xsetType(net.form105.xml.schema.model.TypeDocument.Type type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.TypeDocument.Type target = null;
                    target = (net.form105.xml.schema.model.TypeDocument.Type)get_store().find_element_user(TYPE$4, 0);
                    if (target == null)
                    {
                      target = (net.form105.xml.schema.model.TypeDocument.Type)get_store().add_element_user(TYPE$4);
                    }
                    target.set(type);
                }
            }
            
            /**
             * Gets the "sector" element
             */
            public int getSector()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SECTOR$6, 0);
                    if (target == null)
                    {
                      return 0;
                    }
                    return target.getIntValue();
                }
            }
            
            /**
             * Gets (as xml) the "sector" element
             */
            public net.form105.xml.schema.model.SectorDocument.Sector xgetSector()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.SectorDocument.Sector target = null;
                    target = (net.form105.xml.schema.model.SectorDocument.Sector)get_store().find_element_user(SECTOR$6, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "sector" element
             */
            public void setSector(int sector)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SECTOR$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SECTOR$6);
                    }
                    target.setIntValue(sector);
                }
            }
            
            /**
             * Sets (as xml) the "sector" element
             */
            public void xsetSector(net.form105.xml.schema.model.SectorDocument.Sector sector)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.SectorDocument.Sector target = null;
                    target = (net.form105.xml.schema.model.SectorDocument.Sector)get_store().find_element_user(SECTOR$6, 0);
                    if (target == null)
                    {
                      target = (net.form105.xml.schema.model.SectorDocument.Sector)get_store().add_element_user(SECTOR$6);
                    }
                    target.set(sector);
                }
            }
            
            /**
             * Gets the "address" element
             */
            public net.form105.xml.schema.model.AddressDocument.Address getAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.AddressDocument.Address target = null;
                    target = (net.form105.xml.schema.model.AddressDocument.Address)get_store().find_element_user(ADDRESS$8, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target;
                }
            }
            
            /**
             * Sets the "address" element
             */
            public void setAddress(net.form105.xml.schema.model.AddressDocument.Address address)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.AddressDocument.Address target = null;
                    target = (net.form105.xml.schema.model.AddressDocument.Address)get_store().find_element_user(ADDRESS$8, 0);
                    if (target == null)
                    {
                      target = (net.form105.xml.schema.model.AddressDocument.Address)get_store().add_element_user(ADDRESS$8);
                    }
                    target.set(address);
                }
            }
            
            /**
             * Appends and returns a new empty "address" element
             */
            public net.form105.xml.schema.model.AddressDocument.Address addNewAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.AddressDocument.Address target = null;
                    target = (net.form105.xml.schema.model.AddressDocument.Address)get_store().add_element_user(ADDRESS$8);
                    return target;
                }
            }
            
            /**
             * Gets the "dataConverter" element
             */
            public java.lang.String getDataConverter()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATACONVERTER$10, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "dataConverter" element
             */
            public org.apache.xmlbeans.XmlString xgetDataConverter()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DATACONVERTER$10, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "dataConverter" element
             */
            public void setDataConverter(java.lang.String dataConverter)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATACONVERTER$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DATACONVERTER$10);
                    }
                    target.setStringValue(dataConverter);
                }
            }
            
            /**
             * Sets (as xml) the "dataConverter" element
             */
            public void xsetDataConverter(org.apache.xmlbeans.XmlString dataConverter)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DATACONVERTER$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DATACONVERTER$10);
                    }
                    target.set(dataConverter);
                }
            }
            
            /**
             * Gets the "connectionType" attribute
             */
            public net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType.Enum getConnectionType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONNECTIONTYPE$12);
                    if (target == null)
                    {
                      return null;
                    }
                    return (net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType.Enum)target.getEnumValue();
                }
            }
            
            /**
             * Gets (as xml) the "connectionType" attribute
             */
            public net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType xgetConnectionType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType target = null;
                    target = (net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType)get_store().find_attribute_user(CONNECTIONTYPE$12);
                    return target;
                }
            }
            
            /**
             * Sets the "connectionType" attribute
             */
            public void setConnectionType(net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType.Enum connectionType)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONNECTIONTYPE$12);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CONNECTIONTYPE$12);
                    }
                    target.setEnumValue(connectionType);
                }
            }
            
            /**
             * Sets (as xml) the "connectionType" attribute
             */
            public void xsetConnectionType(net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType connectionType)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType target = null;
                    target = (net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType)get_store().find_attribute_user(CONNECTIONTYPE$12);
                    if (target == null)
                    {
                      target = (net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType)get_store().add_attribute_user(CONNECTIONTYPE$12);
                    }
                    target.set(connectionType);
                }
            }
        }
    }
}
