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
    public byte getDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATATYPE$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getByteValue();
        }
    }
    
    /**
     * Gets (as xml) the "dataType" element
     */
    public org.apache.xmlbeans.XmlByte xgetDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlByte target = null;
            target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(DATATYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "dataType" element
     */
    public void setDataType(byte dataType)
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
            target.setByteValue(dataType);
        }
    }
    
    /**
     * Sets (as xml) the "dataType" element
     */
    public void xsetDataType(org.apache.xmlbeans.XmlByte dataType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlByte target = null;
            target = (org.apache.xmlbeans.XmlByte)get_store().find_element_user(DATATYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlByte)get_store().add_element_user(DATATYPE$0);
            }
            target.set(dataType);
        }
    }
}
