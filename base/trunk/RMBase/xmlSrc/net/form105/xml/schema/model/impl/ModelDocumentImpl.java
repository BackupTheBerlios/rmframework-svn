/*
 * An XML document type.
 * Localname: Model
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ModelDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one Model(@http://xml.form105.net/schema/model) element.
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
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "Model");
    
    
    /**
     * Gets the "Model" element
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
     * Sets the "Model" element
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
     * Appends and returns a new empty "Model" element
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
     * An XML Model(@http://xml.form105.net/schema/model).
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
        public net.form105.xml.schema.model.ResourceDocument.Resource[] getResourceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(RESOURCE$0, targetList);
                net.form105.xml.schema.model.ResourceDocument.Resource[] result = new net.form105.xml.schema.model.ResourceDocument.Resource[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Resource" element
         */
        public net.form105.xml.schema.model.ResourceDocument.Resource getResourceArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ResourceDocument.Resource target = null;
                target = (net.form105.xml.schema.model.ResourceDocument.Resource)get_store().find_element_user(RESOURCE$0, i);
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
        public void setResourceArray(net.form105.xml.schema.model.ResourceDocument.Resource[] resourceArray)
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
        public void setResourceArray(int i, net.form105.xml.schema.model.ResourceDocument.Resource resource)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ResourceDocument.Resource target = null;
                target = (net.form105.xml.schema.model.ResourceDocument.Resource)get_store().find_element_user(RESOURCE$0, i);
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
        public net.form105.xml.schema.model.ResourceDocument.Resource insertNewResource(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ResourceDocument.Resource target = null;
                target = (net.form105.xml.schema.model.ResourceDocument.Resource)get_store().insert_element_user(RESOURCE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Resource" element
         */
        public net.form105.xml.schema.model.ResourceDocument.Resource addNewResource()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.form105.xml.schema.model.ResourceDocument.Resource target = null;
                target = (net.form105.xml.schema.model.ResourceDocument.Resource)get_store().add_element_user(RESOURCE$0);
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
    }
}
