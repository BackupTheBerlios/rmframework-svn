/*
 * An XML document type.
 * Localname: Command
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.CommandDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model;


/**
 * A document containing one Command(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public interface CommandDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CommandDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("commandf084doctype");
    
    /**
     * Gets the "Command" element
     */
    net.form105.xml.schema.model.CommandDocument.Command getCommand();
    
    /**
     * Sets the "Command" element
     */
    void setCommand(net.form105.xml.schema.model.CommandDocument.Command command);
    
    /**
     * Appends and returns a new empty "Command" element
     */
    net.form105.xml.schema.model.CommandDocument.Command addNewCommand();
    
    /**
     * An XML Command(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public interface Command extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Command.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("command53dbelemtype");
        
        /**
         * Gets the "Value" element
         */
        net.form105.xml.schema.model.CommandDocument.Command.Value getValue();
        
        /**
         * Sets the "Value" element
         */
        void setValue(net.form105.xml.schema.model.CommandDocument.Command.Value value);
        
        /**
         * Appends and returns a new empty "Value" element
         */
        net.form105.xml.schema.model.CommandDocument.Command.Value addNewValue();
        
        /**
         * Gets the "SetValueBy" element
         */
        net.form105.xml.schema.model.CommandDocument.Command.SetValueBy getSetValueBy();
        
        /**
         * Sets the "SetValueBy" element
         */
        void setSetValueBy(net.form105.xml.schema.model.CommandDocument.Command.SetValueBy setValueBy);
        
        /**
         * Appends and returns a new empty "SetValueBy" element
         */
        net.form105.xml.schema.model.CommandDocument.Command.SetValueBy addNewSetValueBy();
        
        /**
         * Gets the "Value" attribute
         */
        java.lang.String getValue2();
        
        /**
         * Gets (as xml) the "Value" attribute
         */
        org.apache.xmlbeans.XmlString xgetValue2();
        
        /**
         * True if has "Value" attribute
         */
        boolean isSetValue2();
        
        /**
         * Sets the "Value" attribute
         */
        void setValue2(java.lang.String value2);
        
        /**
         * Sets (as xml) the "Value" attribute
         */
        void xsetValue2(org.apache.xmlbeans.XmlString value2);
        
        /**
         * Unsets the "Value" attribute
         */
        void unsetValue2();
        
        /**
         * An XML Value(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public interface Value extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Value.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("value3098elemtype");
            
            /**
             * Gets the "value" attribute
             */
            java.lang.String getValue();
            
            /**
             * Gets (as xml) the "value" attribute
             */
            org.apache.xmlbeans.XmlString xgetValue();
            
            /**
             * True if has "value" attribute
             */
            boolean isSetValue();
            
            /**
             * Sets the "value" attribute
             */
            void setValue(java.lang.String value);
            
            /**
             * Sets (as xml) the "value" attribute
             */
            void xsetValue(org.apache.xmlbeans.XmlString value);
            
            /**
             * Unsets the "value" attribute
             */
            void unsetValue();
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static net.form105.xml.schema.model.CommandDocument.Command.Value newInstance() {
                  return (net.form105.xml.schema.model.CommandDocument.Command.Value) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.form105.xml.schema.model.CommandDocument.Command.Value newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.form105.xml.schema.model.CommandDocument.Command.Value) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML SetValueBy(@http://xml.form105.net/schema/model).
         *
         * This is a complex type.
         */
        public interface SetValueBy extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SetValueBy.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("setvalueby977delemtype");
            
            /**
             * Gets the "id" attribute
             */
            java.lang.String getId();
            
            /**
             * Gets (as xml) the "id" attribute
             */
            org.apache.xmlbeans.XmlString xgetId();
            
            /**
             * True if has "id" attribute
             */
            boolean isSetId();
            
            /**
             * Sets the "id" attribute
             */
            void setId(java.lang.String id);
            
            /**
             * Sets (as xml) the "id" attribute
             */
            void xsetId(org.apache.xmlbeans.XmlString id);
            
            /**
             * Unsets the "id" attribute
             */
            void unsetId();
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static net.form105.xml.schema.model.CommandDocument.Command.SetValueBy newInstance() {
                  return (net.form105.xml.schema.model.CommandDocument.Command.SetValueBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.form105.xml.schema.model.CommandDocument.Command.SetValueBy newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.form105.xml.schema.model.CommandDocument.Command.SetValueBy) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.form105.xml.schema.model.CommandDocument.Command newInstance() {
              return (net.form105.xml.schema.model.CommandDocument.Command) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.form105.xml.schema.model.CommandDocument.Command newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.form105.xml.schema.model.CommandDocument.Command) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.form105.xml.schema.model.CommandDocument newInstance() {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.form105.xml.schema.model.CommandDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.form105.xml.schema.model.CommandDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.form105.xml.schema.model.CommandDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.form105.xml.schema.model.CommandDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.CommandDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.CommandDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.CommandDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
