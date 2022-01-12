/**
 * EntityKey.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class EntityKey  implements java.io.Serializable {
    private java.lang.String entitySetName;

    private java.lang.String entityContainerName;

    private ar.com.unisolutions.EntityKeyMember[] entityKeyValues;

    public EntityKey() {
    }

    public EntityKey(
           java.lang.String entitySetName,
           java.lang.String entityContainerName,
           ar.com.unisolutions.EntityKeyMember[] entityKeyValues) {
           this.entitySetName = entitySetName;
           this.entityContainerName = entityContainerName;
           this.entityKeyValues = entityKeyValues;
    }


    /**
     * Gets the entitySetName value for this EntityKey.
     * 
     * @return entitySetName
     */
    public java.lang.String getEntitySetName() {
        return entitySetName;
    }


    /**
     * Sets the entitySetName value for this EntityKey.
     * 
     * @param entitySetName
     */
    public void setEntitySetName(java.lang.String entitySetName) {
        this.entitySetName = entitySetName;
    }


    /**
     * Gets the entityContainerName value for this EntityKey.
     * 
     * @return entityContainerName
     */
    public java.lang.String getEntityContainerName() {
        return entityContainerName;
    }


    /**
     * Sets the entityContainerName value for this EntityKey.
     * 
     * @param entityContainerName
     */
    public void setEntityContainerName(java.lang.String entityContainerName) {
        this.entityContainerName = entityContainerName;
    }


    /**
     * Gets the entityKeyValues value for this EntityKey.
     * 
     * @return entityKeyValues
     */
    public ar.com.unisolutions.EntityKeyMember[] getEntityKeyValues() {
        return entityKeyValues;
    }


    /**
     * Sets the entityKeyValues value for this EntityKey.
     * 
     * @param entityKeyValues
     */
    public void setEntityKeyValues(ar.com.unisolutions.EntityKeyMember[] entityKeyValues) {
        this.entityKeyValues = entityKeyValues;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EntityKey)) return false;
        EntityKey other = (EntityKey) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.entitySetName==null && other.getEntitySetName()==null) || 
             (this.entitySetName!=null &&
              this.entitySetName.equals(other.getEntitySetName()))) &&
            ((this.entityContainerName==null && other.getEntityContainerName()==null) || 
             (this.entityContainerName!=null &&
              this.entityContainerName.equals(other.getEntityContainerName()))) &&
            ((this.entityKeyValues==null && other.getEntityKeyValues()==null) || 
             (this.entityKeyValues!=null &&
              java.util.Arrays.equals(this.entityKeyValues, other.getEntityKeyValues())));
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
        if (getEntitySetName() != null) {
            _hashCode += getEntitySetName().hashCode();
        }
        if (getEntityContainerName() != null) {
            _hashCode += getEntityContainerName().hashCode();
        }
        if (getEntityKeyValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEntityKeyValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEntityKeyValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EntityKey.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityKey"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entitySetName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntitySetName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entityContainerName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityContainerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entityKeyValues");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityKeyValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityKeyMember"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityKeyMember"));
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
