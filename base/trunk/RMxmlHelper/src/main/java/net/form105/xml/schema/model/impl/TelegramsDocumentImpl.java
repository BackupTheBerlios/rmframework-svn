/*
 * An XML document type.
 * Localname: Telegrams
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.TelegramsDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one Telegrams(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class TelegramsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.TelegramsDocument
{
    private static final long serialVersionUID = 1L;
    
    public TelegramsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TELEGRAMS$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Telegrams");
    
    
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
     * An XML Telegrams(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class TelegramsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.TelegramsDocument.Telegrams
    {
        private static final long serialVersionUID = 1L;
        
        public TelegramsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName COMMAND$0 = 
            new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Command");
        private static final javax.xml.namespace.QName STREAM$2 = 
            new javax.xml.namespace.QName("", "stream");
        private static final javax.xml.namespace.QName TYPE$4 = 
            new javax.xml.namespace.QName("", "type");
        private static final javax.xml.namespace.QName ADDRESS$6 = 
            new javax.xml.namespace.QName("", "address");
        
        
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
        
        /**
         * Gets the "stream" attribute
         */
        public java.lang.String getStream()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STREAM$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "stream" attribute
         */
        public org.apache.xmlbeans.XmlString xgetStream()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(STREAM$2);
                return target;
            }
        }
        
        /**
         * True if has "stream" attribute
         */
        public boolean isSetStream()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(STREAM$2) != null;
            }
        }
        
        /**
         * Sets the "stream" attribute
         */
        public void setStream(java.lang.String stream)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STREAM$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STREAM$2);
                }
                target.setStringValue(stream);
            }
        }
        
        /**
         * Sets (as xml) the "stream" attribute
         */
        public void xsetStream(org.apache.xmlbeans.XmlString stream)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(STREAM$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(STREAM$2);
                }
                target.set(stream);
            }
        }
        
        /**
         * Unsets the "stream" attribute
         */
        public void unsetStream()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(STREAM$2);
            }
        }
        
        /**
         * Gets the "type" attribute
         */
        public java.lang.String getType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "type" attribute
         */
        public org.apache.xmlbeans.XmlString xgetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TYPE$4);
                return target;
            }
        }
        
        /**
         * True if has "type" attribute
         */
        public boolean isSetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TYPE$4) != null;
            }
        }
        
        /**
         * Sets the "type" attribute
         */
        public void setType(java.lang.String type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TYPE$4);
                }
                target.setStringValue(type);
            }
        }
        
        /**
         * Sets (as xml) the "type" attribute
         */
        public void xsetType(org.apache.xmlbeans.XmlString type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TYPE$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TYPE$4);
                }
                target.set(type);
            }
        }
        
        /**
         * Unsets the "type" attribute
         */
        public void unsetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TYPE$4);
            }
        }
        
        /**
         * Gets the "address" attribute
         */
        public java.lang.String getAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ADDRESS$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "address" attribute
         */
        public org.apache.xmlbeans.XmlString xgetAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ADDRESS$6);
                return target;
            }
        }
        
        /**
         * True if has "address" attribute
         */
        public boolean isSetAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(ADDRESS$6) != null;
            }
        }
        
        /**
         * Sets the "address" attribute
         */
        public void setAddress(java.lang.String address)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ADDRESS$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ADDRESS$6);
                }
                target.setStringValue(address);
            }
        }
        
        /**
         * Sets (as xml) the "address" attribute
         */
        public void xsetAddress(org.apache.xmlbeans.XmlString address)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ADDRESS$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ADDRESS$6);
                }
                target.set(address);
            }
        }
        
        /**
         * Unsets the "address" attribute
         */
        public void unsetAddress()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(ADDRESS$6);
            }
        }
    }
}
