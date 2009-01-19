/*
 * An XML document type.
 * Localname: model
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ModelDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one model(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class ModelDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ModelDocument
{
    private static final long serialVersionUID = 1L;
    
    public ModelDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MODEL$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "model");
    
    
    /**
     * Gets the "model" element
     */
    public net.form105.xml.schema.model.ModelDocument.Model getModel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ModelDocument.Model target = null;
            target = (net.form105.xml.schema.model.ModelDocument.Model)get_store().find_element_user(MODEL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "model" element
     */
    public void setModel(net.form105.xml.schema.model.ModelDocument.Model model)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ModelDocument.Model target = null;
            target = (net.form105.xml.schema.model.ModelDocument.Model)get_store().find_element_user(MODEL$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.ModelDocument.Model)get_store().add_element_user(MODEL$0);
            }
            target.set(model);
        }
    }
    
    /**
     * Appends and returns a new empty "model" element
     */
    public net.form105.xml.schema.model.ModelDocument.Model addNewModel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.ModelDocument.Model target = null;
            target = (net.form105.xml.schema.model.ModelDocument.Model)get_store().add_element_user(MODEL$0);
            return target;
        }
    }
    /**
     * An XML model(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public static class ModelImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ModelDocument.Model
    {
        private static final long serialVersionUID = 1L;
        
        public ModelImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName RESOURCE$0 = 
            new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Resource");
        
        
        /**
         * Gets array of all "Resource" elements
         */
        public net.form105.xml.schema.model.ModelDocument.Model.Resource[] getResourceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(RESOURCE$0, targetList);
                net.form105.xml.schema.model.ModelDocument.Model.Resource[] result = new net.form105.xml.schema.model.ModelDocument.Model.Resource[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Resource" element
         */
        public net.form105.xml.schema.model.ModelDocument.Model.Resource getResourceArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ModelDocument.Model.Resource target = null;
                target = (net.form105.xml.schema.model.ModelDocument.Model.Resource)get_store().find_element_user(RESOURCE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Resource" element
         */
        public int sizeOfResourceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RESOURCE$0);
            }
        }
        
        /**
         * Sets array of all "Resource" element
         */
        public void setResourceArray(net.form105.xml.schema.model.ModelDocument.Model.Resource[] resourceArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(resourceArray, RESOURCE$0);
            }
        }
        
        /**
         * Sets ith "Resource" element
         */
        public void setResourceArray(int i, net.form105.xml.schema.model.ModelDocument.Model.Resource resource)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ModelDocument.Model.Resource target = null;
                target = (net.form105.xml.schema.model.ModelDocument.Model.Resource)get_store().find_element_user(RESOURCE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(resource);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Resource" element
         */
        public net.form105.xml.schema.model.ModelDocument.Model.Resource insertNewResource(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ModelDocument.Model.Resource target = null;
                target = (net.form105.xml.schema.model.ModelDocument.Model.Resource)get_store().insert_element_user(RESOURCE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Resource" element
         */
        public net.form105.xml.schema.model.ModelDocument.Model.Resource addNewResource()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ModelDocument.Model.Resource target = null;
                target = (net.form105.xml.schema.model.ModelDocument.Model.Resource)get_store().add_element_user(RESOURCE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Resource" element
         */
        public void removeResource(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RESOURCE$0, i);
            }
        }
        /**
         * An XML Resource(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public static class ResourceImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.ModelDocument.Model.Resource
        {
            private static final long serialVersionUID = 1L;
            
            public ResourceImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName PARAMETER$0 = 
                new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Parameter");
            private static final javax.xml.namespace.QName ID$2 = 
                new javax.xml.namespace.QName("", "id");
            private static final javax.xml.namespace.QName NAME$4 = 
                new javax.xml.namespace.QName("", "name");
            
            
            /**
             * Gets array of all "Parameter" elements
             */
            public net.form105.xml.schema.model.ParameterDocument.Parameter[] getParameterArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    java.util.List targetList = new java.util.ArrayList();
                    get_store().find_all_element_users(PARAMETER$0, targetList);
                    net.form105.xml.schema.model.ParameterDocument.Parameter[] result = new net.form105.xml.schema.model.ParameterDocument.Parameter[targetList.size()];
                    targetList.toArray(result);
                    return result;
                }
            }
            
            /**
             * Gets ith "Parameter" element
             */
            public net.form105.xml.schema.model.ParameterDocument.Parameter getParameterArray(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.ParameterDocument.Parameter target = null;
                    target = (net.form105.xml.schema.model.ParameterDocument.Parameter)get_store().find_element_user(PARAMETER$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    return target;
                }
            }
            
            /**
             * Returns number of "Parameter" element
             */
            public int sizeOfParameterArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().count_elements(PARAMETER$0);
                }
            }
            
            /**
             * Sets array of all "Parameter" element
             */
            public void setParameterArray(net.form105.xml.schema.model.ParameterDocument.Parameter[] parameterArray)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    arraySetterHelper(parameterArray, PARAMETER$0);
                }
            }
            
            /**
             * Sets ith "Parameter" element
             */
            public void setParameterArray(int i, net.form105.xml.schema.model.ParameterDocument.Parameter parameter)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.ParameterDocument.Parameter target = null;
                    target = (net.form105.xml.schema.model.ParameterDocument.Parameter)get_store().find_element_user(PARAMETER$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    target.set(parameter);
                }
            }
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "Parameter" element
             */
            public net.form105.xml.schema.model.ParameterDocument.Parameter insertNewParameter(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.form105.xml.schema.model.ParameterDocument.Parameter target = null;
                    target = (net.form105.xml.schema.model.ParameterDocument.Parameter)get_store().insert_element_user(PARAMETER$0, i);
                    return target;
                }
            }
            
            /**
             * Appends and returns a new empty value (as xml) as the last "Parameter" element
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
             * Removes the ith "Parameter" element
             */
            public void removeParameter(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_element(PARAMETER$0, i);
                }
            }
            
            /**
             * Gets the "id" attribute
             */
            public java.lang.String getId()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$2);
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
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$2);
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
                    return get_store().find_attribute_user(ID$2) != null;
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
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$2);
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
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$2);
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
                    get_store().remove_attribute(ID$2);
                }
            }
            
            /**
             * Gets the "name" attribute
             */
            public java.lang.String getName()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "name" attribute
             */
            public org.apache.xmlbeans.XmlString xgetName()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$4);
                    return target;
                }
            }
            
            /**
             * True if has "name" attribute
             */
            public boolean isSetName()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(NAME$4) != null;
                }
            }
            
            /**
             * Sets the "name" attribute
             */
            public void setName(java.lang.String name)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$4);
                    }
                    target.setStringValue(name);
                }
            }
            
            /**
             * Sets (as xml) the "name" attribute
             */
            public void xsetName(org.apache.xmlbeans.XmlString name)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$4);
                    }
                    target.set(name);
                }
            }
            
            /**
             * Unsets the "name" attribute
             */
            public void unsetName()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(NAME$4);
                }
            }
        }
    }
}
