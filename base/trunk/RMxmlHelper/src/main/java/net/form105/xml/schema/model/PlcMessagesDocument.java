/*
 * An XML document type.
 * Localname: plcMessages
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.PlcMessagesDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model;


/**
 * A document containing one plcMessages(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public interface PlcMessagesDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PlcMessagesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sB18905F8CF4D75292408F4E3C86C0D61").resolveHandle("plcmessagesfa2cdoctype");
    
    /**
     * Gets the "plcMessages" element
     */
    net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages getPlcMessages();
    
    /**
     * Sets the "plcMessages" element
     */
    void setPlcMessages(net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages plcMessages);
    
    /**
     * Appends and returns a new empty "plcMessages" element
     */
    net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages addNewPlcMessages();
    
    /**
     * An XML plcMessages(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public interface PlcMessages extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PlcMessages.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sB18905F8CF4D75292408F4E3C86C0D61").resolveHandle("plcmessages952belemtype");
        
        /**
         * Gets array of all "plcMessage" elements
         */
        net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage[] getPlcMessageArray();
        
        /**
         * Gets ith "plcMessage" element
         */
        net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage getPlcMessageArray(int i);
        
        /**
         * Returns number of "plcMessage" element
         */
        int sizeOfPlcMessageArray();
        
        /**
         * Sets array of all "plcMessage" element
         */
        void setPlcMessageArray(net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage[] plcMessageArray);
        
        /**
         * Sets ith "plcMessage" element
         */
        void setPlcMessageArray(int i, net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage plcMessage);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "plcMessage" element
         */
        net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage insertNewPlcMessage(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "plcMessage" element
         */
        net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage addNewPlcMessage();
        
        /**
         * Removes the ith "plcMessage" element
         */
        void removePlcMessage(int i);
        
        /**
         * An XML plcMessage(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public interface PlcMessage extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PlcMessage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sB18905F8CF4D75292408F4E3C86C0D61").resolveHandle("plcmessage23e7elemtype");
            
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
             * Gets the "name" element
             */
            java.lang.String getName();
            
            /**
             * Gets (as xml) the "name" element
             */
            org.apache.xmlbeans.XmlString xgetName();
            
            /**
             * Sets the "name" element
             */
            void setName(java.lang.String name);
            
            /**
             * Sets (as xml) the "name" element
             */
            void xsetName(org.apache.xmlbeans.XmlString name);
            
            /**
             * Gets the "type" element
             */
            int getType();
            
            /**
             * Gets (as xml) the "type" element
             */
            net.form105.xml.schema.model.TypeDocument.Type xgetType();
            
            /**
             * Sets the "type" element
             */
            void setType(int type);
            
            /**
             * Sets (as xml) the "type" element
             */
            void xsetType(net.form105.xml.schema.model.TypeDocument.Type type);
            
            /**
             * Gets the "sector" element
             */
            int getSector();
            
            /**
             * Gets (as xml) the "sector" element
             */
            net.form105.xml.schema.model.SectorDocument.Sector xgetSector();
            
            /**
             * Sets the "sector" element
             */
            void setSector(int sector);
            
            /**
             * Sets (as xml) the "sector" element
             */
            void xsetSector(net.form105.xml.schema.model.SectorDocument.Sector sector);
            
            /**
             * Gets the "address" element
             */
            net.form105.xml.schema.model.AddressDocument.Address getAddress();
            
            /**
             * Sets the "address" element
             */
            void setAddress(net.form105.xml.schema.model.AddressDocument.Address address);
            
            /**
             * Appends and returns a new empty "address" element
             */
            net.form105.xml.schema.model.AddressDocument.Address addNewAddress();
            
            /**
             * Gets the "dataType" element
             */
            net.form105.xml.schema.model.DataTypeDocument.DataType.Enum getDataType();
            
            /**
             * Gets (as xml) the "dataType" element
             */
            net.form105.xml.schema.model.DataTypeDocument.DataType xgetDataType();
            
            /**
             * Sets the "dataType" element
             */
            void setDataType(net.form105.xml.schema.model.DataTypeDocument.DataType.Enum dataType);
            
            /**
             * Sets (as xml) the "dataType" element
             */
            void xsetDataType(net.form105.xml.schema.model.DataTypeDocument.DataType dataType);
            
            /**
             * Gets the "connectionType" attribute
             */
            net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType.Enum getConnectionType();
            
            /**
             * Gets (as xml) the "connectionType" attribute
             */
            net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType xgetConnectionType();
            
            /**
             * Sets the "connectionType" attribute
             */
            void setConnectionType(net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType.Enum connectionType);
            
            /**
             * Sets (as xml) the "connectionType" attribute
             */
            void xsetConnectionType(net.form105.xml.schema.model.ConnectionTypeAttribute.ConnectionType connectionType);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage newInstance() {
                  return (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages.PlcMessage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages newInstance() {
              return (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.form105.xml.schema.model.PlcMessagesDocument.PlcMessages) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.form105.xml.schema.model.PlcMessagesDocument newInstance() {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.PlcMessagesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.PlcMessagesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
