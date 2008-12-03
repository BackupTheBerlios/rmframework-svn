/*
 * An XML document type.
 * Localname: dataConverter
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.DataConverterDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one dataConverter(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class DataConverterDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.DataConverterDocument
{
    
    public DataConverterDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATACONVERTER$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "dataConverter");
    
    
    /**
     * Gets the "dataConverter" element
     */
    public java.lang.String getDataConverter()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATACONVERTER$0, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DATACONVERTER$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DATACONVERTER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DATACONVERTER$0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DATACONVERTER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DATACONVERTER$0);
            }
            target.set(dataConverter);
        }
    }
}
