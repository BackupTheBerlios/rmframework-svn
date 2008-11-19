/*
 * An XML attribute type.
 * Localname: connectionType
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ConnectionTypeAttribute
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one connectionType(@http://xml.form105.net/schema/model) attribute.
 *
 * This is a complex type.
 */
public class ConnectionTypeAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ConnectionTypeAttribute
{
    
    public ConnectionTypeAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONNECTIONTYPE$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "connectionType");
    
    
    /**
     * Gets the "connectionType" attribute
     */
    public net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType.Enum getConnectionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONNECTIONTYPE$0);
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
            target = (net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType)get_store().find_attribute_user(CONNECTIONTYPE$0);
            return target;
        }
    }
    
    /**
     * True if has "connectionType" attribute
     */
    public boolean isSetConnectionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(CONNECTIONTYPE$0) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONNECTIONTYPE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CONNECTIONTYPE$0);
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
            target = (net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType)get_store().find_attribute_user(CONNECTIONTYPE$0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType)get_store().add_attribute_user(CONNECTIONTYPE$0);
            }
            target.set(connectionType);
        }
    }
    
    /**
     * Unsets the "connectionType" attribute
     */
    public void unsetConnectionType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(CONNECTIONTYPE$0);
        }
    }
    /**
     * An XML connectionType(@http://xml.form105.net/schema/model).
     *
     * This is an atomic type that is a restriction of net.form105.xml.schema.model.ConnectionTypeAttribute$ConnectionType.
     */
    public static class ConnectionTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType
    {
        
        public ConnectionTypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ConnectionTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
