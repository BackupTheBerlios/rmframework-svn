/*
 * An XML document type.
 * Localname: BoolParameter
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.BoolParameterDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one BoolParameter(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class BoolParameterDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.BoolParameterDocument
{
    private static final long serialVersionUID = 1L;
    
    public BoolParameterDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BOOLPARAMETER$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "BoolParameter");
    
    
    /**
     * Gets the "BoolParameter" element
     */
    public org.apache.xmlbeans.XmlObject getBoolParameter()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(BOOLPARAMETER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "BoolParameter" element
     */
    public void setBoolParameter(org.apache.xmlbeans.XmlObject boolParameter)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(BOOLPARAMETER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(BOOLPARAMETER$0);
            }
            target.set(boolParameter);
        }
    }
    
    /**
     * Appends and returns a new empty "BoolParameter" element
     */
    public org.apache.xmlbeans.XmlObject addNewBoolParameter()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(BOOLPARAMETER$0);
            return target;
        }
    }
}
