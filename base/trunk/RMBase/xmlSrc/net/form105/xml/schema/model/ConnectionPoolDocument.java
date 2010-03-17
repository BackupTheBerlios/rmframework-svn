/*
 * An XML document type.
 * Localname: connectionPool
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ConnectionPoolDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model;


/**
 * A document containing one connectionPool(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public interface ConnectionPoolDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ConnectionPoolDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("connectionpool2c45doctype");
    
    /**
     * Gets the "connectionPool" element
     */
    net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool getConnectionPool();
    
    /**
     * Sets the "connectionPool" element
     */
    void setConnectionPool(net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool connectionPool);
    
    /**
     * Appends and returns a new empty "connectionPool" element
     */
    net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool addNewConnectionPool();
    
    /**
     * An XML connectionPool(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public interface ConnectionPool extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ConnectionPool.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("connectionpool674felemtype");
        
        /**
         * Gets array of all "inbound" elements
         */
        net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound[] getInboundArray();
        
        /**
         * Gets ith "inbound" element
         */
        net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound getInboundArray(int i);
        
        /**
         * Returns number of "inbound" element
         */
        int sizeOfInboundArray();
        
        /**
         * Sets array of all "inbound" element
         */
        void setInboundArray(net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound[] inboundArray);
        
        /**
         * Sets ith "inbound" element
         */
        void setInboundArray(int i, net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound inbound);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "inbound" element
         */
        net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound insertNewInbound(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "inbound" element
         */
        net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound addNewInbound();
        
        /**
         * Removes the ith "inbound" element
         */
        void removeInbound(int i);
        
        /**
         * Gets array of all "outbound" elements
         */
        net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound[] getOutboundArray();
        
        /**
         * Gets ith "outbound" element
         */
        net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound getOutboundArray(int i);
        
        /**
         * Returns number of "outbound" element
         */
        int sizeOfOutboundArray();
        
        /**
         * Sets array of all "outbound" element
         */
        void setOutboundArray(net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound[] outboundArray);
        
        /**
         * Sets ith "outbound" element
         */
        void setOutboundArray(int i, net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound outbound);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "outbound" element
         */
        net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound insertNewOutbound(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "outbound" element
         */
        net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound addNewOutbound();
        
        /**
         * Removes the ith "outbound" element
         */
        void removeOutbound(int i);
        
        /**
         * An XML inbound(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public interface Inbound extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Inbound.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("inboundb774elemtype");
            
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
                public static net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound newInstance() {
                  return (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Inbound) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML outbound(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public interface Outbound extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Outbound.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("outbound09dbelemtype");
            
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
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound newInstance() {
                  return (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool.Outbound) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool newInstance() {
              return (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.form105.xml.schema.model.ConnectionPoolDocument.ConnectionPool) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.form105.xml.schema.model.ConnectionPoolDocument newInstance() {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ConnectionPoolDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ConnectionPoolDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
