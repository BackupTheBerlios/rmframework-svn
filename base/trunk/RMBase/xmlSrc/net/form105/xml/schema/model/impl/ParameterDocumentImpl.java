/*
 * An XML document type.
 * Localname: Parameter
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ParameterDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one Parameter(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class ParameterDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ParameterDocument
{
    private static final long serialVersionUID = 1L;
    
    public ParameterDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PARAMETER$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Parameter");
    
    
    /**
     * Gets the "Parameter" element
     */
    public net.form105.xml.schema.model.ParameterDocument.Parameter getParameter()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ParameterDocument.Parameter target = null;
            target = (net.form105.xml.schema.model.ParameterDocument.Parameter)get_store().find_element_user(PARAMETER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Parameter" element
     */
    public void setParameter(net.form105.xml.schema.model.ParameterDocument.Parameter parameter)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ParameterDocument.Parameter target = null;
            target = (net.form105.xml.schema.model.ParameterDocument.Parameter)get_store().find_element_user(PARAMETER$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.ParameterDocument.Parameter)get_store().add_element_user(PARAMETER$0);
            }
            target.set(parameter);
        }
    }
    
    /**
     * Appends and returns a new empty "Parameter" element
     */
    public net.form105.xml.schema.model.ParameterDocument.Parameter addNewParameter()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ParameterDocument.Parameter target = null;
            target = (net.form105.xml.schema.model.ParameterDocument.Parameter)get_store().add_element_user(PARAMETER$0);
            return target;
        }
    }
    /**
     * An XML Parameter(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class ParameterImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ParameterDocument.Parameter
    {
        private static final long serialVersionUID = 1L;
        
        public ParameterImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ID$0 = 
            new javax.xml.namespace.QName("", "Id");
        private static final javax.xml.namespace.QName NAME$2 = 
            new javax.xml.namespace.QName("", "Name");
        private static final javax.xml.namespace.QName TYPE$4 = 
            new javax.xml.namespace.QName("", "Type");
        private static final javax.xml.namespace.QName VALUE$6 = 
            new javax.xml.namespace.QName("", "Value");
        
        
        /**
         * Gets the "Id" attribute
         */
        public java.lang.String getId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Id" attribute
         */
        public org.apache.xmlbeans.XmlString xgetId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$0);
                return target;
            }
        }
        
        /**
         * Sets the "Id" attribute
         */
        public void setId(java.lang.String id)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$0);
                }
                target.setStringValue(id);
            }
        }
        
        /**
         * Sets (as xml) the "Id" attribute
         */
        public void xsetId(org.apache.xmlbeans.XmlString id)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$0);
                }
                target.set(id);
            }
        }
        
        /**
         * Gets the "Name" attribute
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Name" attribute
         */
        public org.apache.xmlbeans.XmlString xgetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
                return target;
            }
        }
        
        /**
         * Sets the "Name" attribute
         */
        public void setName(java.lang.String name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$2);
                }
                target.setStringValue(name);
            }
        }
        
        /**
         * Sets (as xml) the "Name" attribute
         */
        public void xsetName(org.apache.xmlbeans.XmlString name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$2);
                }
                target.set(name);
            }
        }
        
        /**
         * Gets the "Type" attribute
         */
        public net.form105.xml.schema.model.ParameterDocument.Parameter.Type.Enum getType()
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
                return (net.form105.xml.schema.model.ParameterDocument.Parameter.Type.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "Type" attribute
         */
        public net.form105.xml.schema.model.ParameterDocument.Parameter.Type xgetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ParameterDocument.Parameter.Type target = null;
                target = (net.form105.xml.schema.model.ParameterDocument.Parameter.Type)get_store().find_attribute_user(TYPE$4);
                return target;
            }
        }
        
        /**
         * True if has "Type" attribute
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
         * Sets the "Type" attribute
         */
        public void setType(net.form105.xml.schema.model.ParameterDocument.Parameter.Type.Enum type)
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
                target.setEnumValue(type);
            }
        }
        
        /**
         * Sets (as xml) the "Type" attribute
         */
        public void xsetType(net.form105.xml.schema.model.ParameterDocument.Parameter.Type type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ParameterDocument.Parameter.Type target = null;
                target = (net.form105.xml.schema.model.ParameterDocument.Parameter.Type)get_store().find_attribute_user(TYPE$4);
                if (target == null)
                {
                    target = (net.form105.xml.schema.model.ParameterDocument.Parameter.Type)get_store().add_attribute_user(TYPE$4);
                }
                target.set(type);
            }
        }
        
        /**
         * Unsets the "Type" attribute
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
         * Gets the "Value" attribute
         */
        public java.lang.String getValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Value" attribute
         */
        public org.apache.xmlbeans.XmlString xgetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$6);
                return target;
            }
        }
        
        /**
         * True if has "Value" attribute
         */
        public boolean isSetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(VALUE$6) != null;
            }
        }
        
        /**
         * Sets the "Value" attribute
         */
        public void setValue(java.lang.String value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALUE$6);
                }
                target.setStringValue(value);
            }
        }
        
        /**
         * Sets (as xml) the "Value" attribute
         */
        public void xsetValue(org.apache.xmlbeans.XmlString value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VALUE$6);
                }
                target.set(value);
            }
        }
        
        /**
         * Unsets the "Value" attribute
         */
        public void unsetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(VALUE$6);
            }
        }
        /**
         * An XML Type(@).
         *
         * This is an atomic type that is a restriction of net.form105.xml.schema.model.ParameterDocument$Parameter$Type.
         */
        public static class TypeImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements net.form105.xml.schema.model.ParameterDocument.Parameter.Type
        {
            private static final long serialVersionUID = 1L;
            
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
}
