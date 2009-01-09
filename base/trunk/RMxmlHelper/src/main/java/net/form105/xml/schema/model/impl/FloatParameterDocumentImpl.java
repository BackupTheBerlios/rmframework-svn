/*
 * An XML document type.
 * Localname: FloatParameter
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.FloatParameterDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one FloatParameter(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class FloatParameterDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.FloatParameterDocument
{
    private static final long serialVersionUID = 1L;
    
    public FloatParameterDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FLOATPARAMETER$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "FloatParameter");
    
    
    /**
     * Gets the "FloatParameter" element
     */
    public net.form105.xml.schema.model.FloatParameterDocument.FloatParameter getFloatParameter()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.FloatParameterDocument.FloatParameter target = null;
            target = (net.form105.xml.schema.model.FloatParameterDocument.FloatParameter)get_store().find_element_user(FLOATPARAMETER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "FloatParameter" element
     */
    public void setFloatParameter(net.form105.xml.schema.model.FloatParameterDocument.FloatParameter floatParameter)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.FloatParameterDocument.FloatParameter target = null;
            target = (net.form105.xml.schema.model.FloatParameterDocument.FloatParameter)get_store().find_element_user(FLOATPARAMETER$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.FloatParameterDocument.FloatParameter)get_store().add_element_user(FLOATPARAMETER$0);
            }
            target.set(floatParameter);
        }
    }
    
    /**
     * Appends and returns a new empty "FloatParameter" element
     */
    public net.form105.xml.schema.model.FloatParameterDocument.FloatParameter addNewFloatParameter()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.FloatParameterDocument.FloatParameter target = null;
            target = (net.form105.xml.schema.model.FloatParameterDocument.FloatParameter)get_store().add_element_user(FLOATPARAMETER$0);
            return target;
        }
    }
    /**
     * An XML FloatParameter(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class FloatParameterImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.FloatParameterDocument.FloatParameter
    {
        private static final long serialVersionUID = 1L;
        
        public FloatParameterImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName VALUE$0 = 
            new javax.xml.namespace.QName("", "value");
        
        
        /**
         * Gets the "value" attribute
         */
        public float getValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$0);
                if (target == null)
                {
                    return 0.0f;
                }
                return target.getFloatValue();
            }
        }
        
        /**
         * Gets (as xml) the "value" attribute
         */
        public org.apache.xmlbeans.XmlFloat xgetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlFloat target = null;
                target = (org.apache.xmlbeans.XmlFloat)get_store().find_attribute_user(VALUE$0);
                return target;
            }
        }
        
        /**
         * True if has "value" attribute
         */
        public boolean isSetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(VALUE$0) != null;
            }
        }
        
        /**
         * Sets the "value" attribute
         */
        public void setValue(float value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALUE$0);
                }
                target.setFloatValue(value);
            }
        }
        
        /**
         * Sets (as xml) the "value" attribute
         */
        public void xsetValue(org.apache.xmlbeans.XmlFloat value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlFloat target = null;
                target = (org.apache.xmlbeans.XmlFloat)get_store().find_attribute_user(VALUE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlFloat)get_store().add_attribute_user(VALUE$0);
                }
                target.set(value);
            }
        }
        
        /**
         * Unsets the "value" attribute
         */
        public void unsetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(VALUE$0);
            }
        }
    }
}
