/*
 * An XML document type.
 * Localname: address
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.AddressDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model;


/**
 * A document containing one address(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public interface AddressDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sB18905F8CF4D75292408F4E3C86C0D61").resolveHandle("address24cddoctype");
    
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
     * An XML address(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public interface Address extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Address.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sB18905F8CF4D75292408F4E3C86C0D61").resolveHandle("addressb52delemtype");
        
        /**
         * Gets the "db" attribute
         */
        int getDb();
        
        /**
         * Gets (as xml) the "db" attribute
         */
        org.apache.xmlbeans.XmlInt xgetDb();
        
        /**
         * True if has "db" attribute
         */
        boolean isSetDb();
        
        /**
         * Sets the "db" attribute
         */
        void setDb(int db);
        
        /**
         * Sets (as xml) the "db" attribute
         */
        void xsetDb(org.apache.xmlbeans.XmlInt db);
        
        /**
         * Unsets the "db" attribute
         */
        void unsetDb();
        
        /**
         * Gets the "byte" attribute
         */
        int getByte();
        
        /**
         * Gets (as xml) the "byte" attribute
         */
        net.form105.xml.schema.model.AddressDocument.Address.Byte xgetByte();
        
        /**
         * True if has "byte" attribute
         */
        boolean isSetByte();
        
        /**
         * Sets the "byte" attribute
         */
        void setByte(int xbyte);
        
        /**
         * Sets (as xml) the "byte" attribute
         */
        void xsetByte(net.form105.xml.schema.model.AddressDocument.Address.Byte xbyte);
        
        /**
         * Unsets the "byte" attribute
         */
        void unsetByte();
        
        /**
         * Gets the "bit" attribute
         */
        int getBit();
        
        /**
         * Gets (as xml) the "bit" attribute
         */
        org.apache.xmlbeans.XmlInt xgetBit();
        
        /**
         * True if has "bit" attribute
         */
        boolean isSetBit();
        
        /**
         * Sets the "bit" attribute
         */
        void setBit(int bit);
        
        /**
         * Sets (as xml) the "bit" attribute
         */
        void xsetBit(org.apache.xmlbeans.XmlInt bit);
        
        /**
         * Unsets the "bit" attribute
         */
        void unsetBit();
        
        /**
         * An XML byte(@).
         *
         * This is an atomic type that is a restriction of net.form105.xml.schema.model.AddressDocument$Address$Byte.
         */
        public interface Byte extends org.apache.xmlbeans.XmlInt
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Byte.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sB18905F8CF4D75292408F4E3C86C0D61").resolveHandle("byte1855attrtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static net.form105.xml.schema.model.AddressDocument.Address.Byte newValue(java.lang.Object obj) {
                  return (net.form105.xml.schema.model.AddressDocument.Address.Byte) type.newValue( obj ); }
                
                public static net.form105.xml.schema.model.AddressDocument.Address.Byte newInstance() {
                  return (net.form105.xml.schema.model.AddressDocument.Address.Byte) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.form105.xml.schema.model.AddressDocument.Address.Byte newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.form105.xml.schema.model.AddressDocument.Address.Byte) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.form105.xml.schema.model.AddressDocument.Address newInstance() {
              return (net.form105.xml.schema.model.AddressDocument.Address) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.form105.xml.schema.model.AddressDocument.Address newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.form105.xml.schema.model.AddressDocument.Address) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.form105.xml.schema.model.AddressDocument newInstance() {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.form105.xml.schema.model.AddressDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.form105.xml.schema.model.AddressDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.form105.xml.schema.model.AddressDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.form105.xml.schema.model.AddressDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.AddressDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.AddressDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
