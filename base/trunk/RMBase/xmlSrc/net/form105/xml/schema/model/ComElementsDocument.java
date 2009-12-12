/*
 * An XML document type.
 * Localname: ComElements
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ComElementsDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model;


/**
 * A document containing one ComElements(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public interface ComElementsDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ComElementsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("comelements08d1doctype");
    
    /**
     * Gets the "ComElements" element
     */
    net.form105.xml.schema.model.ComElementsDocument.ComElements getComElements();
    
    /**
     * Sets the "ComElements" element
     */
    void setComElements(net.form105.xml.schema.model.ComElementsDocument.ComElements comElements);
    
    /**
     * Appends and returns a new empty "ComElements" element
     */
    net.form105.xml.schema.model.ComElementsDocument.ComElements addNewComElements();
    
    /**
     * An XML ComElements(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public interface ComElements extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ComElements.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("comelementsadb5elemtype");
        
        /**
         * Gets array of all "Key" elements
         */
        net.form105.xml.schema.model.ComElementsDocument.ComElements.Key[] getKeyArray();
        
        /**
         * Gets ith "Key" element
         */
        net.form105.xml.schema.model.ComElementsDocument.ComElements.Key getKeyArray(int i);
        
        /**
         * Returns number of "Key" element
         */
        int sizeOfKeyArray();
        
        /**
         * Sets array of all "Key" element
         */
        void setKeyArray(net.form105.xml.schema.model.ComElementsDocument.ComElements.Key[] keyArray);
        
        /**
         * Sets ith "Key" element
         */
        void setKeyArray(int i, net.form105.xml.schema.model.ComElementsDocument.ComElements.Key key);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Key" element
         */
        net.form105.xml.schema.model.ComElementsDocument.ComElements.Key insertNewKey(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Key" element
         */
        net.form105.xml.schema.model.ComElementsDocument.ComElements.Key addNewKey();
        
        /**
         * Removes the ith "Key" element
         */
        void removeKey(int i);
        
        /**
         * An XML Key(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public interface Key extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Key.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("key0c60elemtype");
            
            /**
             * Gets the "Telegrams" element
             */
            net.form105.xml.schema.model.TelegramsDocument.Telegrams getTelegrams();
            
            /**
             * Sets the "Telegrams" element
             */
            void setTelegrams(net.form105.xml.schema.model.TelegramsDocument.Telegrams telegrams);
            
            /**
             * Appends and returns a new empty "Telegrams" element
             */
            net.form105.xml.schema.model.TelegramsDocument.Telegrams addNewTelegrams();
            
            /**
             * Gets the "Notifications" element
             */
            net.form105.xml.schema.model.NotificationsDocument.Notifications getNotifications();
            
            /**
             * Sets the "Notifications" element
             */
            void setNotifications(net.form105.xml.schema.model.NotificationsDocument.Notifications notifications);
            
            /**
             * Appends and returns a new empty "Notifications" element
             */
            net.form105.xml.schema.model.NotificationsDocument.Notifications addNewNotifications();
            
            /**
             * Gets the "k1" attribute
             */
            java.lang.String getK1();
            
            /**
             * Gets (as xml) the "k1" attribute
             */
            org.apache.xmlbeans.XmlString xgetK1();
            
            /**
             * True if has "k1" attribute
             */
            boolean isSetK1();
            
            /**
             * Sets the "k1" attribute
             */
            void setK1(java.lang.String k1);
            
            /**
             * Sets (as xml) the "k1" attribute
             */
            void xsetK1(org.apache.xmlbeans.XmlString k1);
            
            /**
             * Unsets the "k1" attribute
             */
            void unsetK1();
            
            /**
             * Gets the "k2" attribute
             */
            java.lang.String getK2();
            
            /**
             * Gets (as xml) the "k2" attribute
             */
            org.apache.xmlbeans.XmlString xgetK2();
            
            /**
             * True if has "k2" attribute
             */
            boolean isSetK2();
            
            /**
             * Sets the "k2" attribute
             */
            void setK2(java.lang.String k2);
            
            /**
             * Sets (as xml) the "k2" attribute
             */
            void xsetK2(org.apache.xmlbeans.XmlString k2);
            
            /**
             * Unsets the "k2" attribute
             */
            void unsetK2();
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static net.form105.xml.schema.model.ComElementsDocument.ComElements.Key newInstance() {
                  return (net.form105.xml.schema.model.ComElementsDocument.ComElements.Key) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.form105.xml.schema.model.ComElementsDocument.ComElements.Key newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.form105.xml.schema.model.ComElementsDocument.ComElements.Key) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.form105.xml.schema.model.ComElementsDocument.ComElements newInstance() {
              return (net.form105.xml.schema.model.ComElementsDocument.ComElements) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.form105.xml.schema.model.ComElementsDocument.ComElements newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.form105.xml.schema.model.ComElementsDocument.ComElements) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.form105.xml.schema.model.ComElementsDocument newInstance() {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.form105.xml.schema.model.ComElementsDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ComElementsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ComElementsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ComElementsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
