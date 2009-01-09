/*
 * An XML document type.
 * Localname: content
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ContentDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one content(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class ContentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ContentDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTENT$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "content");
    
    
    /**
     * Gets the "content" element
     */
    public net.form105.xml.schema.model.ContentDocument.Content getContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ContentDocument.Content target = null;
            target = (net.form105.xml.schema.model.ContentDocument.Content)get_store().find_element_user(CONTENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "content" element
     */
    public void setContent(net.form105.xml.schema.model.ContentDocument.Content content)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ContentDocument.Content target = null;
            target = (net.form105.xml.schema.model.ContentDocument.Content)get_store().find_element_user(CONTENT$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.ContentDocument.Content)get_store().add_element_user(CONTENT$0);
            }
            target.set(content);
        }
    }
    
    /**
     * Appends and returns a new empty "content" element
     */
    public net.form105.xml.schema.model.ContentDocument.Content addNewContent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ContentDocument.Content target = null;
            target = (net.form105.xml.schema.model.ContentDocument.Content)get_store().add_element_user(CONTENT$0);
            return target;
        }
    }
    /**
     * An XML content(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class ContentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ContentDocument.Content
    {
        private static final long serialVersionUID = 1L;
        
        public ContentImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}
