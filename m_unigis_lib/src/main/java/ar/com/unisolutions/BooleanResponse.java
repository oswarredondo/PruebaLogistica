/**
 * BooleanResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class BooleanResponse  implements java.io.Serializable {
    private boolean hasError;

    private boolean hasWarning;

    private boolean rollback;

    private java.lang.String errorMessage;

    private java.lang.String warningMessage;

    private ar.com.unisolutions.AbstractEntitie entity;

    private long entityId;

    public BooleanResponse() {
    }

    public BooleanResponse(
           boolean hasError,
           boolean hasWarning,
           boolean rollback,
           java.lang.String errorMessage,
           java.lang.String warningMessage,
           ar.com.unisolutions.AbstractEntitie entity,
           long entityId) {
           this.hasError = hasError;
           this.hasWarning = hasWarning;
           this.rollback = rollback;
           this.errorMessage = errorMessage;
           this.warningMessage = warningMessage;
           this.entity = entity;
           this.entityId = entityId;
    }


    /**
     * Gets the hasError value for this BooleanResponse.
     * 
     * @return hasError
     */
    public boolean isHasError() {
        return hasError;
    }


    /**
     * Sets the hasError value for this BooleanResponse.
     * 
     * @param hasError
     */
    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }


    /**
     * Gets the hasWarning value for this BooleanResponse.
     * 
     * @return hasWarning
     */
    public boolean isHasWarning() {
        return hasWarning;
    }


    /**
     * Sets the hasWarning value for this BooleanResponse.
     * 
     * @param hasWarning
     */
    public void setHasWarning(boolean hasWarning) {
        this.hasWarning = hasWarning;
    }


    /**
     * Gets the rollback value for this BooleanResponse.
     * 
     * @return rollback
     */
    public boolean isRollback() {
        return rollback;
    }


    /**
     * Sets the rollback value for this BooleanResponse.
     * 
     * @param rollback
     */
    public void setRollback(boolean rollback) {
        this.rollback = rollback;
    }


    /**
     * Gets the errorMessage value for this BooleanResponse.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this BooleanResponse.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the warningMessage value for this BooleanResponse.
     * 
     * @return warningMessage
     */
    public java.lang.String getWarningMessage() {
        return warningMessage;
    }


    /**
     * Sets the warningMessage value for this BooleanResponse.
     * 
     * @param warningMessage
     */
    public void setWarningMessage(java.lang.String warningMessage) {
        this.warningMessage = warningMessage;
    }


    /**
     * Gets the entity value for this BooleanResponse.
     * 
     * @return entity
     */
    public ar.com.unisolutions.AbstractEntitie getEntity() {
        return entity;
    }


    /**
     * Sets the entity value for this BooleanResponse.
     * 
     * @param entity
     */
    public void setEntity(ar.com.unisolutions.AbstractEntitie entity) {
        this.entity = entity;
    }


    /**
     * Gets the entityId value for this BooleanResponse.
     * 
     * @return entityId
     */
    public long getEntityId() {
        return entityId;
    }


    /**
     * Sets the entityId value for this BooleanResponse.
     * 
     * @param entityId
     */
    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BooleanResponse)) return false;
        BooleanResponse other = (BooleanResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.hasError == other.isHasError() &&
            this.hasWarning == other.isHasWarning() &&
            this.rollback == other.isRollback() &&
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
            ((this.warningMessage==null && other.getWarningMessage()==null) || 
             (this.warningMessage!=null &&
              this.warningMessage.equals(other.getWarningMessage()))) &&
            ((this.entity==null && other.getEntity()==null) || 
             (this.entity!=null &&
              this.entity.equals(other.getEntity()))) &&
            this.entityId == other.getEntityId();
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
        _hashCode += (isHasError() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isHasWarning() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRollback() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        if (getWarningMessage() != null) {
            _hashCode += getWarningMessage().hashCode();
        }
        if (getEntity() != null) {
            _hashCode += getEntity().hashCode();
        }
        _hashCode += new Long(getEntityId()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BooleanResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "BooleanResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasError");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HasError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasWarning");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "HasWarning"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rollback");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "Rollback"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "ErrorMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warningMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "WarningMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "entity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "AbstractEntitie"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entityId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "EntityId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
