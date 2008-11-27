/*
 * An XML document type.
 * Localname: dataType
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.DataTypeDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one dataType(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class DataTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.DataTypeDocument
{
    
    public DataTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATATYPE$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "dataType");
    
    
    /**
     * Gets the "dataType" element
     */
    public net.form105.xml.schema.model.DataTypeDocument.DataType.Enum getDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATATYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return (net.form105.xml.schema.model.DataTypeDocument.DataType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "dataType" element
     */
    public net.form105.xml.schema.model.DataTypeDocument.DataType xgetDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.DataTypeDocument.DataType target = null;
            target = (net.form105.xml.schema.model.DataTypeDocument.DataType)get_store().find_element_user(DATATYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "dataType" element
     */
    public void setDataType(net.form105.xml.schema.model.DataTypeDocument.DataType.Enum dataType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATATYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DATATYPE$0);
            }
            target.setEnumValue(dataType);
        }
    }
    
    /**
     * Sets (as xml) the "dataType" element
     */
    public void xsetDataType(net.form105.xml.schema.model.DataTypeDocument.DataType dataType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.DataTypeDocument.DataType target = null;
            target = (net.form105.xml.schema.model.DataTypeDocument.DataType)get_store().find_element_user(DATATYPE$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.DataTypeDocument.DataType)get_store().add_element_user(DATATYPE$0);
            }
            target.set(dataType);
        }
    }
    /**
     * An XML dataType(@http://xml.form105.net/schema/model).
     *
     * This is an atomic type that is a restriction of net.form105.xml.schema.model.DataTypeDocument$DataType.
     */
    public static class DataTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements net.form105.xml.schema.model.DataTypeDocument.DataType
    {
        
        public DataTypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected DataTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
