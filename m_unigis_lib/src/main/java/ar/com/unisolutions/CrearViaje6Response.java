/**
 * CrearViaje6Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class CrearViaje6Response  implements java.io.Serializable {
    private ar.com.unisolutions.CrearViajeResultado crearViaje6Result;

    public CrearViaje6Response() {
    }

    public CrearViaje6Response(
           ar.com.unisolutions.CrearViajeResultado crearViaje6Result) {
           this.crearViaje6Result = crearViaje6Result;
    }


    /**
     * Gets the crearViaje6Result value for this CrearViaje6Response.
     * 
     * @return crearViaje6Result
     */
    public ar.com.unisolutions.CrearViajeResultado getCrearViaje6Result() {
        return crearViaje6Result;
    }


    /**
     * Sets the crearViaje6Result value for this CrearViaje6Response.
     * 
     * @param crearViaje6Result
     */
    public void setCrearViaje6Result(ar.com.unisolutions.CrearViajeResultado crearViaje6Result) {
        this.crearViaje6Result = crearViaje6Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CrearViaje6Response)) return false;
        CrearViaje6Response other = (CrearViaje6Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.crearViaje6Result==null && other.getCrearViaje6Result()==null) || 
             (this.crearViaje6Result!=null &&
              this.crearViaje6Result.equals(other.getCrearViaje6Result())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCrearViaje6Result() != null) {
            _hashCode += getCrearViaje6Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CrearViaje6Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", ">CrearViaje6Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crearViaje6Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViaje6Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "CrearViajeResultado"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
