/*
 * An XML document type.
 * Localname: address
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.AddressDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one address(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class AddressDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.AddressDocument
{
    private static final long serialVersionUID = 1L;
    
    public AddressDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDRESS$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "address");
    
    
    /**
     * Gets the "address" element
     */
    public net.form105.xml.schema.model.AddressDocument.Address getAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.AddressDocument.Address target = null;
            target = (net.form105.xml.schema.model.AddressDocument.Address)get_store().find_element_user(ADDRESS$0, 0);
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
            target = (net.form105.xml.schema.model.AddressDocument.Address)get_store().find_element_user(ADDRESS$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.AddressDocument.Address)get_store().add_element_user(ADDRESS$0);
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
            target = (net.form105.xml.schema.model.AddressDocument.Address)get_store().add_element_user(ADDRESS$0);
            return target;
        }
    }
    /**
     * An XML address(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class AddressImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.AddressDocument.Address
    {
        private static final long serialVersionUID = 1L;
        
        public AddressImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DB$0 = 
            new javax.xml.namespace.QName("", "db");
        private static final javax.xml.namespace.QName BYTE$2 = 
            new javax.xml.namespace.QName("", "byte");
        private static final javax.xml.namespace.QName BIT$4 = 
            new javax.xml.namespace.QName("", "bit");
        
        
        /**
         * Gets the "db" attribute
         */
        public int getDb()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DB$0);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "db" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetDb()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(DB$0);
                return target;
            }
        }
        
        /**
         * True if has "db" attribute
         */
        public boolean isSetDb()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(DB$0) != null;
            }
        }
        
        /**
         * Sets the "db" attribute
         */
        public void setDb(int db)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DB$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DB$0);
                }
                target.setIntValue(db);
            }
        }
        
        /**
         * Sets (as xml) the "db" attribute
         */
        public void xsetDb(org.apache.xmlbeans.XmlInt db)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(DB$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(DB$0);
                }
                target.set(db);
            }
        }
        
        /**
         * Unsets the "db" attribute
         */
        public void unsetDb()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(DB$0);
            }
        }
        
        /**
         * Gets the "byte" attribute
         */
        public int getByte()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BYTE$2);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "byte" attribute
         */
        public net.form105.xml.schema.model.AddressDocument.Address.Byte xgetByte()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.AddressDocument.Address.Byte target = null;
                target = (net.form105.xml.schema.model.AddressDocument.Address.Byte)get_store().find_attribute_user(BYTE$2);
                return target;
            }
        }
        
        /**
         * True if has "byte" attribute
         */
        public boolean isSetByte()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(BYTE$2) != null;
            }
        }
        
        /**
         * Sets the "byte" attribute
         */
        public void setByte(int xbyte)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BYTE$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(BYTE$2);
                }
                target.setIntValue(xbyte);
            }
        }
        
        /**
         * Sets (as xml) the "byte" attribute
         */
        public void xsetByte(net.form105.xml.schema.model.AddressDocument.Address.Byte xbyte)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.AddressDocument.Address.Byte target = null;
                target = (net.form105.xml.schema.model.AddressDocument.Address.Byte)get_store().find_attribute_user(BYTE$2);
                if (target == null)
                {
                    target = (net.form105.xml.schema.model.AddressDocument.Address.Byte)get_store().add_attribute_user(BYTE$2);
                }
                target.set(xbyte);
            }
        }
        
        /**
         * Unsets the "byte" attribute
         */
        public void unsetByte()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(BYTE$2);
            }
        }
        
        /**
         * Gets the "bit" attribute
         */
        public int getBit()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BIT$4);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "bit" attribute
         */
        public org.apache.xmlbeans.XmlInt xgetBit()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(BIT$4);
                return target;
            }
        }
        
        /**
         * True if has "bit" attribute
         */
        public boolean isSetBit()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(BIT$4) != null;
            }
        }
        
        /**
         * Sets the "bit" attribute
         */
        public void setBit(int bit)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BIT$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(BIT$4);
                }
                target.setIntValue(bit);
            }
        }
        
        /**
         * Sets (as xml) the "bit" attribute
         */
        public void xsetBit(org.apache.xmlbeans.XmlInt bit)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInt target = null;
                target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(BIT$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(BIT$4);
                }
                target.set(bit);
            }
        }
        
        /**
         * Unsets the "bit" attribute
         */
        public void unsetBit()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(BIT$4);
            }
        }
        /**
         * An XML byte(@).
         *
         * This is an atomic type that is a restriction of net.form105.xml.schema.model.AddressDocument$Address$Byte.
         */
        public static class ByteImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements net.form105.xml.schema.model.AddressDocument.Address.Byte
        {
            private static final long serialVersionUID = 1L;
            
            public ByteImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected ByteImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
    }
}
