/*
 * An XML document type.
 * Localname: Model
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ModelDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model;


/**
 * A document containing one Model(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public interface ModelDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ModelDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("modelbb22doctype");
    
    /**
     * Gets the "Model" element
     */
    net.form105.xml.schema.model.ModelDocument.Model getModel();
    
    /**
     * Sets the "Model" element
     */
    void setModel(net.form105.xml.schema.model.ModelDocument.Model model);
    
    /**
     * Appends and returns a new empty "Model" element
     */
    net.form105.xml.schema.model.ModelDocument.Model addNewModel();
    
    /**
     * An XML Model(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public interface Model extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Model.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("modelc117elemtype");
        
        /**
         * Gets array of all "Resource" elements
         */
        net.form105.xml.schema.model.ResourceDocument.Resource[] getResourceArray();
        
        /**
         * Gets ith "Resource" element
         */
        net.form105.xml.schema.model.ResourceDocument.Resource getResourceArray(int i);
        
        /**
         * Returns number of "Resource" element
         */
        int sizeOfResourceArray();
        
        /**
         * Sets array of all "Resource" element
         */
        void setResourceArray(net.form105.xml.schema.model.ResourceDocument.Resource[] resourceArray);
        
        /**
         * Sets ith "Resource" element
         */
        void setResourceArray(int i, net.form105.xml.schema.model.ResourceDocument.Resource resource);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Resource" element
         */
        net.form105.xml.schema.model.ResourceDocument.Resource insertNewResource(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Resource" element
         */
        net.form105.xml.schema.model.ResourceDocument.Resource addNewResource();
        
        /**
         * Removes the ith "Resource" element
         */
        void removeResource(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.form105.xml.schema.model.ModelDocument.Model newInstance() {
              return (net.form105.xml.schema.model.ModelDocument.Model) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.form105.xml.schema.model.ModelDocument.Model newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.form105.xml.schema.model.ModelDocument.Model) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.form105.xml.schema.model.ModelDocument newInstance() {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.form105.xml.schema.model.ModelDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.form105.xml.schema.model.ModelDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.form105.xml.schema.model.ModelDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.form105.xml.schema.model.ModelDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ModelDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ModelDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ModelDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
