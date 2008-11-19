/*
 * An XML document type.
 * Localname: type
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.TypeDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one type(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class TypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.TypeDocument
{
    
    public TypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TYPE$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "type");
    
    
    /**
     * Gets the "type" element
     */
    public int getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$0, 0);
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
            target = (net.form105.xml.schema.model.TypeDocument.Type)get_store().find_element_user(TYPE$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$0);
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
            target = (net.form105.xml.schema.model.TypeDocument.Type)get_store().find_element_user(TYPE$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.TypeDocument.Type)get_store().add_element_user(TYPE$0);
            }
            target.set(type);
        }
    }
    /**
     * An XML type(@http://xml.form105.net/schema/model).
     *
     * This is an atomic type that is a restriction of net.form105.xml.schema.model.TypeDocument$Type.
     */
    public static class TypeImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements net.form105.xml.schema.model.TypeDocument.Type
    {
        
        public TypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected TypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
