/*
 * An XML document type.
 * Localname: Parameter
 * Namespace: http://xml.form105.net/schema/model
 * Java type: net.form105.xml.schema.model.ParameterDocument
 *
 * Automatically generated - do not modify.
 */
package net.form105.xml.schema.model;


/**
 * A document containing one Parameter(@http://xml.form105.net/schema/model) element.
 *
 * This is a complex type.
 */
public interface ParameterDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ParameterDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("parameter1822doctype");
    
    /**
     * Gets the "Parameter" element
     */
    net.form105.xml.schema.model.ParameterDocument.Parameter getParameter();
    
    /**
     * Sets the "Parameter" element
     */
    void setParameter(net.form105.xml.schema.model.ParameterDocument.Parameter parameter);
    
    /**
     * Appends and returns a new empty "Parameter" element
     */
    net.form105.xml.schema.model.ParameterDocument.Parameter addNewParameter();
    
    /**
     * An XML Parameter(@http://xml.form105.net/schema/model).
     *
     * This is a complex type.
     */
    public interface Parameter extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Parameter.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("parameter7017elemtype");
        
        /**
         * Gets the "Id" attribute
         */
        java.lang.String getId();
        
        /**
         * Gets (as xml) the "Id" attribute
         */
        org.apache.xmlbeans.XmlString xgetId();
        
        /**
         * Sets the "Id" attribute
         */
        void setId(java.lang.String id);
        
        /**
         * Sets (as xml) the "Id" attribute
         */
        void xsetId(org.apache.xmlbeans.XmlString id);
        
        /**
         * Gets the "Name" attribute
         */
        java.lang.String getName();
        
        /**
         * Gets (as xml) the "Name" attribute
         */
        org.apache.xmlbeans.XmlString xgetName();
        
        /**
         * Sets the "Name" attribute
         */
        void setName(java.lang.String name);
        
        /**
         * Sets (as xml) the "Name" attribute
         */
        void xsetName(org.apache.xmlbeans.XmlString name);
        
        /**
         * Gets the "Type" attribute
         */
        net.form105.xml.schema.model.ParameterDocument.Parameter.Type.Enum getType();
        
        /**
         * Gets (as xml) the "Type" attribute
         */
        net.form105.xml.schema.model.ParameterDocument.Parameter.Type xgetType();
        
        /**
         * True if has "Type" attribute
         */
        boolean isSetType();
        
        /**
         * Sets the "Type" attribute
         */
        void setType(net.form105.xml.schema.model.ParameterDocument.Parameter.Type.Enum type);
        
        /**
         * Sets (as xml) the "Type" attribute
         */
        void xsetType(net.form105.xml.schema.model.ParameterDocument.Parameter.Type type);
        
        /**
         * Unsets the "Type" attribute
         */
        void unsetType();
        
        /**
         * Gets the "Value" attribute
         */
        java.lang.String getValue();
        
        /**
         * Gets (as xml) the "Value" attribute
         */
        org.apache.xmlbeans.XmlString xgetValue();
        
        /**
         * True if has "Value" attribute
         */
        boolean isSetValue();
        
        /**
         * Sets the "Value" attribute
         */
        void setValue(java.lang.String value);
        
        /**
         * Sets (as xml) the "Value" attribute
         */
        void xsetValue(org.apache.xmlbeans.XmlString value);
        
        /**
         * Unsets the "Value" attribute
         */
        void unsetValue();
        
        /**
         * An XML Type(@).
         *
         * This is an atomic type that is a restriction of net.form105.xml.schema.model.ParameterDocument$Parameter$Type.
         */
        public interface Type extends org.apache.xmlbeans.XmlString
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Type.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s829698F166F306BF75EB2830AFB2AC93").resolveHandle("type0a91attrtype");
            
            org.apache.xmlbeans.StringEnumAbstractBase enumValue();
            void set(org.apache.xmlbeans.StringEnumAbstractBase e);
            
            static final Enum STRING = Enum.forString("String");
            static final Enum INTEGER = Enum.forString("Integer");
            static final Enum FLOAT = Enum.forString("Float");
            static final Enum BOOLEAN = Enum.forString("Boolean");
            
            static final int INT_STRING = Enum.INT_STRING;
            static final int INT_INTEGER = Enum.INT_INTEGER;
            static final int INT_FLOAT = Enum.INT_FLOAT;
            static final int INT_BOOLEAN = Enum.INT_BOOLEAN;
            
            /**
             * Enumeration value class for net.form105.xml.schema.model.ParameterDocument$Parameter$Type.
             * These enum values can be used as follows:
             * <pre>
             * enum.toString(); // returns the string value of the enum
             * enum.intValue(); // returns an int value, useful for switches
             * // e.g., case Enum.INT_STRING
             * Enum.forString(s); // returns the enum value for a string
             * Enum.forInt(i); // returns the enum value for an int
             * </pre>
             * Enumeration objects are immutable singleton objects that
             * can be compared using == object equality. They have no
             * public constructor. See the constants defined within this
             * class for all the valid values.
             */
            static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
            {
                /**
                 * Returns the enum value for a string, or null if none.
                 */
                public static Enum forString(java.lang.String s)
                    { return (Enum)table.forString(s); }
                /**
                 * Returns the enum value corresponding to an int, or null if none.
                 */
                public static Enum forInt(int i)
                    { return (Enum)table.forInt(i); }
                
                private Enum(java.lang.String s, int i)
                    { super(s, i); }
                
                static final int INT_STRING = 1;
                static final int INT_INTEGER = 2;
                static final int INT_FLOAT = 3;
                static final int INT_BOOLEAN = 4;
                
                public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                    new org.apache.xmlbeans.StringEnumAbstractBase.Table
                (
                    new Enum[]
                    {
                      new Enum("String", INT_STRING),
                      new Enum("Integer", INT_INTEGER),
                      new Enum("Float", INT_FLOAT),
                      new Enum("Boolean", INT_BOOLEAN),
                    }
                );
                private static final long serialVersionUID = 1L;
                private java.lang.Object readResolve() { return forInt(intValue()); } 
            }
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static net.form105.xml.schema.model.ParameterDocument.Parameter.Type newValue(java.lang.Object obj) {
                  return (net.form105.xml.schema.model.ParameterDocument.Parameter.Type) type.newValue( obj ); }
                
                public static net.form105.xml.schema.model.ParameterDocument.Parameter.Type newInstance() {
                  return (net.form105.xml.schema.model.ParameterDocument.Parameter.Type) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.form105.xml.schema.model.ParameterDocument.Parameter.Type newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.form105.xml.schema.model.ParameterDocument.Parameter.Type) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.form105.xml.schema.model.ParameterDocument.Parameter newInstance() {
              return (net.form105.xml.schema.model.ParameterDocument.Parameter) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.form105.xml.schema.model.ParameterDocument.Parameter newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.form105.xml.schema.model.ParameterDocument.Parameter) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.form105.xml.schema.model.ParameterDocument newInstance() {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.form105.xml.schema.model.ParameterDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.form105.xml.schema.model.ParameterDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.form105.xml.schema.model.ParameterDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.form105.xml.schema.model.ParameterDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ParameterDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.form105.xml.schema.model.ParameterDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.form105.xml.schema.model.ParameterDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
