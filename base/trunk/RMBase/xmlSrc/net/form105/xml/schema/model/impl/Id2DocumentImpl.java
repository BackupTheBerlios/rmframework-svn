/*
 * An XML document type.
 * Localname: id2
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.Id2Document
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one id2(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class Id2DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.Id2Document
{
    private static final long serialVersionUID = 1L;
    
    public Id2DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ID2$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "id2");
    
    
    /**
     * Gets the "id2" element
     */
    public java.lang.String getId2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id2" element
     */
    public org.apache.xmlbeans.XmlString xgetId2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID2$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "id2" element
     */
    public void setId2(java.lang.String id2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ID2$0);
            }
            target.setStringValue(id2);
        }
    }
    
    /**
     * Sets (as xml) the "id2" element
     */
    public void xsetId2(org.apache.xmlbeans.XmlString id2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ID2$0);
            }
            target.set(id2);
        }
    }
}
