/*
 * An XML document type.
 * Localname: sector
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.SectorDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model.impl;
/**
 * A document containing one sector(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public class SectorDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.form105.xml.schema.model.SectorDocument
{
    
    public SectorDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SECTOR$0 = 
        new javax.xml.namespace.QName("http://xml.form105.net/schema/model", "sector");
    
    
    /**
     * Gets the "sector" element
     */
    public int getSector()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SECTOR$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "sector" element
     */
    public net.form105.xml.schema.model.SectorDocument.Sector xgetSector()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.SectorDocument.Sector target = null;
            target = (net.form105.xml.schema.model.SectorDocument.Sector)get_store().find_element_user(SECTOR$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "sector" element
     */
    public void setSector(int sector)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SECTOR$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SECTOR$0);
            }
            target.setIntValue(sector);
        }
    }
    
    /**
     * Sets (as xml) the "sector" element
     */
    public void xsetSector(net.form105.xml.schema.model.SectorDocument.Sector sector)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.form105.xml.schema.model.SectorDocument.Sector target = null;
            target = (net.form105.xml.schema.model.SectorDocument.Sector)get_store().find_element_user(SECTOR$0, 0);
            if (target == null)
            {
                target = (net.form105.xml.schema.model.SectorDocument.Sector)get_store().add_element_user(SECTOR$0);
            }
            target.set(sector);
        }
    }
    /**
     * An XML sector(@http://xml.form105.net/schema/model).
     *
     * This is an atomic type that is a restriction of net.form105.xml.schema.model.SectorDocument$Sector.
     */
    public static class SectorImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements net.form105.xml.schema.model.SectorDocument.Sector
    {
        
        public SectorImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected SectorImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
