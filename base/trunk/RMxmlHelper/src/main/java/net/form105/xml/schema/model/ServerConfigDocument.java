/*
 * An XML document type.
 * Localname: serverConfig
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ServerConfigDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model;


/**
 * A document containing one serverConfig(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public interface ServerConfigDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ServerConfigDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s55A5F5159C541FB7D2E54DB704983109").resolveHandle("serverconfigd150doctype");
    
    /**
     * Gets the "serverConfig" element
     */
    net.form105.xml.schema.model.ServerConfigDocument.ServerConfig getServerConfig();
    
    /**
     * Sets the "serverConfig" element
     */
    void setServerConfig(net.form105.xml.schema.model.ServerConfigDocument.ServerConfig serverConfig);
    
    /**
     * Appends and returns a new empty "serverConfig" element
     */
    net.form105.xml.schema.model.ServerConfigDocument.ServerConfig addNewServerConfig();
    
    /**
     * An XML serverConfig(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public interface ServerConfig extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ServerConfig.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s55A5F5159C541FB7D2E54DB704983109").resolveHandle("serverconfig86afelemtype");
        
        /**
         * Gets array of all "inbound" elements
         */
        net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound[] getInboundArray();
        
        /**
         * Gets ith "inbound" element
         */
        net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound getInboundArray(int i);
        
        /**
         * Returns number of "inbound" element
         */
        int sizeOfInboundArray();
        
        /**
         * Sets array of all "inbound" element
         */
        void setInboundArray(net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound[] inboundArray);
        
        /**
         * Sets ith "inbound" element
         */
        void setInboundArray(int i, net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound inbound);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "inbound" element
         */
        net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound insertNewInbound(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "inbound" element
         */
        net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound addNewInbound();
        
        /**
         * Removes the ith "inbound" element
         */
        void removeInbound(int i);
        
        /**
         * An XML inbound(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public interface Inbound extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Inbound.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s55A5F5159C541FB7D2E54DB704983109").resolveHandle("inboundb154elemtype");
            
            /**
             * Gets the "id" element
             */
            java.lang.String getId();
            
            /**
             * Gets (as xml) the "id" element
             */
            org.apache.xmlbeans.XmlString xgetId();
            
            /**
             * Sets the "id" element
             */
            void setId(java.lang.String id);
            
            /**
             * Sets (as xml) the "id" element
             */
            void xsetId(org.apache.xmlbeans.XmlString id);
            
            /**
             * Gets the "alias" element
             */
            java.lang.String getAlias();
            
            /**
             * Gets (as xml) the "alias" element
             */
            org.apache.xmlbeans.XmlString xgetAlias();
            
            /**
             * Sets the "alias" element
             */
            void setAlias(java.lang.String alias);
            
            /**
             * Sets (as xml) the "alias" element
             */
            void xsetAlias(org.apache.xmlbeans.XmlString alias);
            
            /**
             * Gets the "host" element
             */
            java.lang.String getHost();
            
            /**
             * Gets (as xml) the "host" element
             */
            org.apache.xmlbeans.XmlString xgetHost();
            
            /**
             * Sets the "host" element
             */
            void setHost(java.lang.String host);
            
            /**
             * Sets (as xml) the "host" element
             */
            void xsetHost(org.apache.xmlbeans.XmlString host);
            
            /**
             * Gets the "port" element
             */
            int getPort();
            
            /**
             * Gets (as xml) the "port" element
             */
            org.apache.xmlbeans.XmlInt xgetPort();
            
            /**
             * Sets the "port" element
             */
            void setPort(int port);
            
            /**
             * Sets (as xml) the "port" element
             */
            void xsetPort(org.apache.xmlbeans.XmlInt port);
            
            /**
             * Gets the "type" element
             */
            java.lang.String getType();
            
            /**
             * Gets (as xml) the "type" element
             */
            org.apache.xmlbeans.XmlString xgetType();
            
            /**
             * Sets the "type" element
             */
            void setType(java.lang.String type);
            
            /**
             * Sets (as xml) the "type" element
             */
            void xsetType(org.apache.xmlbeans.XmlString type);
            
            /**
             * Gets the "sizePendingQueue" element
             */
            int getSizePendingQueue();
            
            /**
             * Gets (as xml) the "sizePendingQueue" element
             */
            org.apache.xmlbeans.XmlInt xgetSizePendingQueue();
            
            /**
             * True if has "sizePendingQueue" element
             */
            boolean isSetSizePendingQueue();
            
            /**
             * Sets the "sizePendingQueue" element
             */
            void setSizePendingQueue(int sizePendingQueue);
            
            /**
             * Sets (as xml) the "sizePendingQueue" element
             */
            void xsetSizePendingQueue(org.apache.xmlbeans.XmlInt sizePendingQueue);
            
            /**
             * Unsets the "sizePendingQueue" element
             */
            void unsetSizePendingQueue();
            
            /**
             * Gets the "validatorKey" element
             */
            java.lang.String getValidatorKey();
            
            /**
             * Gets (as xml) the "validatorKey" element
             */
            org.apache.xmlbeans.XmlString xgetValidatorKey();
            
            /**
             * Sets the "validatorKey" element
             */
            void setValidatorKey(java.lang.String validatorKey);
            
            /**
             * Sets (as xml) the "validatorKey" element
             */
            void xsetValidatorKey(org.apache.xmlbeans.XmlString validatorKey);
            
            /**
             * Gets the "packetSize" element
             */
            int getPacketSize();
            
            /**
             * Gets (as xml) the "packetSize" element
             */
            org.apache.xmlbeans.XmlInt xgetPacketSize();
            
            /**
             * Sets the "packetSize" element
             */
            void setPacketSize(int packetSize);
            
            /**
             * Sets (as xml) the "packetSize" element
             */
            void xsetPacketSize(org.apache.xmlbeans.XmlInt packetSize);
            
            /**
             * Gets the "contentIdentifier" element
             */
            java.lang.String getContentIdentifier();
            
            /**
             * Gets (as xml) the "contentIdentifier" element
             */
            org.apache.xmlbeans.XmlString xgetContentIdentifier();
            
            /**
             * Sets the "contentIdentifier" element
             */
            void setContentIdentifier(java.lang.String contentIdentifier);
            
            /**
             * Sets (as xml) the "contentIdentifier" element
             */
            void xsetContentIdentifier(org.apache.xmlbeans.XmlString contentIdentifier);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound newInstance() {
                  return (net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.form105.xml.schema.model.ServerConfigDocument.ServerConfig.Inbound) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.form105.xml.schema.model.ServerConfigDocument.ServerConfig newInstance() {
              return (net.form105.xml.schema.model.ServerConfigDocument.ServerConfig) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.form105.xml.schema.model.ServerConfigDocument.ServerConfig newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.form105.xml.schema.model.ServerConfigDocument.ServerConfig) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.form105.xml.schema.model.ServerConfigDocument newInstance() {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.form105.xml.schema.model.ServerConfigDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ServerConfigDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ServerConfigDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ServerConfigDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
