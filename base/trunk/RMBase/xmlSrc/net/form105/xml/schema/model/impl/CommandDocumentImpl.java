/*
 * An XML document type.
 * Localname: Command
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.CommandDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one Command(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class CommandDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.CommandDocument
{
    private static final long serialVersionUID = 1L;
    
    public CommandDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMMAND$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Command");
    
    
    /**
     * Gets the "Command" element
     */
    public net.form105.xml.schema.model.CommandDocument.Command getCommand()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.CommandDocument.Command target = null;
            target = (net.form105.xml.schema.model.CommandDocument.Command)get_store().find_element_user(COMMAND$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Command" element
     */
    public void setCommand(net.form105.xml.schema.model.CommandDocument.Command command)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.CommandDocument.Command target = null;
            target = (net.form105.xml.schema.model.CommandDocument.Command)get_store().find_element_user(COMMAND$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.CommandDocument.Command)get_store().add_element_user(COMMAND$0);
            }
            target.set(command);
        }
    }
    
    /**
     * Appends and returns a new empty "Command" element
     */
    public net.form105.xml.schema.model.CommandDocument.Command addNewCommand()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.CommandDocument.Command target = null;
            target = (net.form105.xml.schema.model.CommandDocument.Command)get_store().add_element_user(COMMAND$0);
            return target;
        }
    }
    /**
     * An XML Command(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class CommandImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.CommandDocument.Command
    {
        private static final long serialVersionUID = 1L;
        
        public CommandImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName VALUE$0 = 
            new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Value");
        private static final javax.xml.namespace.QName SETVALUEBY$2 = 
            new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "SetValueBy");
        private static final javax.xml.namespace.QName VALUE2$4 = 
            new javax.xml.namespace.QName("", "Value");
        
        
        /**
         * Gets the "Value" element
         */
        public net.form105.xml.schema.model.CommandDocument.Command.Value getValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.CommandDocument.Command.Value target = null;
                target = (net.form105.xml.schema.model.CommandDocument.Command.Value)get_store().find_element_user(VALUE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "Value" element
         */
        public void setValue(net.form105.xml.schema.model.CommandDocument.Command.Value value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.CommandDocument.Command.Value target = null;
                target = (net.form105.xml.schema.model.CommandDocument.Command.Value)get_store().find_element_user(VALUE$0, 0);
                if (target == null)
                {
                    target = (net.form105.xml.schema.model.CommandDocument.Command.Value)get_store().add_element_user(VALUE$0);
                }
                target.set(value);
            }
        }
        
        /**
         * Appends and returns a new empty "Value" element
         */
        public net.form105.xml.schema.model.CommandDocument.Command.Value addNewValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.CommandDocument.Command.Value target = null;
                target = (net.form105.xml.schema.model.CommandDocument.Command.Value)get_store().add_element_user(VALUE$0);
                return target;
            }
        }
        
        /**
         * Gets the "SetValueBy" element
         */
        public net.form105.xml.schema.model.CommandDocument.Command.SetValueBy getSetValueBy()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.CommandDocument.Command.SetValueBy target = null;
                target = (net.form105.xml.schema.model.CommandDocument.Command.SetValueBy)get_store().find_element_user(SETVALUEBY$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "SetValueBy" element
         */
        public void setSetValueBy(net.form105.xml.schema.model.CommandDocument.Command.SetValueBy setValueBy)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.CommandDocument.Command.SetValueBy target = null;
                target = (net.form105.xml.schema.model.CommandDocument.Command.SetValueBy)get_store().find_element_user(SETVALUEBY$2, 0);
                if (target == null)
                {
                    target = (net.form105.xml.schema.model.CommandDocument.Command.SetValueBy)get_store().add_element_user(SETVALUEBY$2);
                }
                target.set(setValueBy);
            }
        }
        
        /**
         * Appends and returns a new empty "SetValueBy" element
         */
        public net.form105.xml.schema.model.CommandDocument.Command.SetValueBy addNewSetValueBy()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.CommandDocument.Command.SetValueBy target = null;
                target = (net.form105.xml.schema.model.CommandDocument.Command.SetValueBy)get_store().add_element_user(SETVALUEBY$2);
                return target;
            }
        }
        
        /**
         * Gets the "Value" attribute
         */
        public java.lang.String getValue2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE2$4);
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
        public org.apache.xmlbeans.XmlString xgetValue2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE2$4);
                return target;
            }
        }
        
        /**
         * True if has "Value" attribute
         */
        public boolean isSetValue2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(VALUE2$4) != null;
            }
        }
        
        /**
         * Sets the "Value" attribute
         */
        public void setValue2(java.lang.String value2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE2$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALUE2$4);
                }
                target.setStringValue(value2);
            }
        }
        
        /**
         * Sets (as xml) the "Value" attribute
         */
        public void xsetValue2(org.apache.xmlbeans.XmlString value2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE2$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VALUE2$4);
                }
                target.set(value2);
            }
        }
        
        /**
         * Unsets the "Value" attribute
         */
        public void unsetValue2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(VALUE2$4);
            }
        }
        /**
         * An XML Value(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public static class ValueImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.CommandDocument.Command.Value
        {
            private static final long serialVersionUID = 1L;
            
            public ValueImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName VALUE$0 = 
                new javax.xml.namespace.QName("", "value");
            
            
            /**
             * Gets the "value" attribute
             */
            public java.lang.String getValue()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "value" attribute
             */
            public org.apache.xmlbeans.XmlString xgetValue()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$0);
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
            public void setValue(java.lang.String value)
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
                    target.setStringValue(value);
                }
            }
            
            /**
             * Sets (as xml) the "value" attribute
             */
            public void xsetValue(org.apache.xmlbeans.XmlString value)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VALUE$0);
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
        /**
         * An XML SetValueBy(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public static class SetValueByImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.CommandDocument.Command.SetValueBy
        {
            private static final long serialVersionUID = 1L;
            
            public SetValueByImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName ID$0 = 
                new javax.xml.namespace.QName("", "id");
            
            
            /**
             * Gets the "id" attribute
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
             * Gets (as xml) the "id" attribute
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
             * True if has "id" attribute
             */
            public boolean isSetId()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(ID$0) != null;
                }
            }
            
            /**
             * Sets the "id" attribute
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
             * Sets (as xml) the "id" attribute
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
             * Unsets the "id" attribute
             */
            public void unsetId()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(ID$0);
                }
            }
        }
    }
}
