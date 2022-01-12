/**
 * POrdenEntrega.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.unisolutions;

public class POrdenEntrega  extends ar.com.unisolutions.POrden  implements java.io.Serializable {
    public POrdenEntrega() {
    }

    public POrdenEntrega(
           java.lang.String sucursal,
           java.lang.String operacion,
           java.lang.String refDocumento,
           java.lang.String refDocumentoAdicional,
           java.lang.String refDocumentoPedido,
           java.lang.String tipo,
           java.lang.String tipoOrden,
           java.lang.String tipoParada,
           java.lang.String categoriaOrden,
           java.lang.String refDocumentoRecoleccion,
           java.lang.String estado,
           java.util.Calendar fechaJornada,
           ar.com.unisolutions.PCliente cliente,
           java.lang.String descripcion,
           java.lang.String direccion,
           java.lang.String calle,
           java.lang.String nroPuerta,
           java.lang.String entreCalle,
           java.lang.String barrio,
           java.lang.String localidad,
           java.lang.String partido,
           java.lang.String provincia,
           java.lang.String pais,
           java.lang.Integer inicioHorario1,
           java.lang.Integer finHorario1,
           java.lang.Integer inicioHorario2,
           java.lang.Integer finHorario2,
           java.lang.Integer tiempoEspera,
           java.lang.Boolean crearDomicilio,
           java.lang.Integer orden,
           java.util.Calendar inicioHorarioPlanificado,
           java.util.Calendar finHorarioPlanificado,
           java.lang.Double volumen,
           java.lang.Double peso,
           java.lang.Double bulto,
           java.lang.Double pallets,
           java.lang.Double distancia,
           java.lang.Double latitud,
           java.lang.Double longitud,
           java.lang.String observaciones,
           java.lang.String email,
           java.lang.String telefono,
           java.lang.String telefono2,
           java.lang.String telefono3,
           java.lang.String varchar1,
           java.lang.String varchar2,
           java.lang.String varchar3,
           java.lang.String varchar4,
           java.lang.Integer int1,
           java.lang.Integer int2,
           java.lang.Integer idRuta,
           java.lang.Integer preOrden,
           java.lang.Integer grupoConsolidacion,
           java.lang.Integer prioridadAbsoluta,
           java.lang.Integer grupoRutas,
           java.lang.Integer tiempoLatencia,
           java.lang.Integer tiempoEsperaPromedio,
           ar.com.unisolutions.PDeposito depositoSalida,
           ar.com.unisolutions.PDeposito depositoLlegada,
           ar.com.unisolutions.CampoValor[] campoDinamico,
           ar.com.unisolutions.POrdenEntregaItem[] items,
           ar.com.unisolutions.PServicioAdicional[] servicios,
           java.lang.String tipoJornada,
           java.lang.String jornadaDescripcion,
           java.lang.String codigoPostal,
           java.lang.String motivoEstadoParadaDescripcion,
           java.lang.String motivoEstadoParadaReferencia,
           ar.com.unisolutions.PFoto[] fotos,
           ar.com.unisolutions.ConsultarParadaResultadoItem[] paradaItems,
           ar.com.unisolutions.PRemito remito,
           ar.com.unisolutions.PEstadoOrdenEntrega estadoOrden,
           java.lang.Long idOrden,
           java.lang.Long idJornada,
           java.lang.Double pesoMaximo,
           java.lang.Double volumenMaximo,
           java.lang.Double bultosMaximo,
           java.math.BigDecimal costo,
           java.lang.Integer inicioVisita,
           java.lang.Integer finVisita,
           java.util.Calendar inicioHorarioEstimado,
           java.util.Calendar finHorarioEstimado,
           java.util.Calendar inicioHorarioReal,
           java.util.Calendar finHorarioReal,
           java.lang.Boolean usarProductos,
           java.lang.Boolean ultimaVisita,
           java.util.Calendar fecha,
           java.util.Calendar fechaOrden,
           java.util.Calendar datetime1,
           java.util.Calendar datetime2,
           java.util.Calendar fechaUltimoCambioEstado,
           java.lang.Integer unidades) {
        super(
            sucursal,
            operacion,
            refDocumento,
            refDocumentoAdicional,
            refDocumentoPedido,
            tipo,
            tipoOrden,
            tipoParada,
            categoriaOrden,
            refDocumentoRecoleccion,
            estado,
            fechaJornada,
            cliente,
            descripcion,
            direccion,
            calle,
            nroPuerta,
            entreCalle,
            barrio,
            localidad,
            partido,
            provincia,
            pais,
            inicioHorario1,
            finHorario1,
            inicioHorario2,
            finHorario2,
            tiempoEspera,
            crearDomicilio,
            orden,
            inicioHorarioPlanificado,
            finHorarioPlanificado,
            volumen,
            peso,
            bulto,
            pallets,
            distancia,
            latitud,
            longitud,
            observaciones,
            email,
            telefono,
            telefono2,
            telefono3,
            varchar1,
            varchar2,
            varchar3,
            varchar4,
            int1,
            int2,
            idRuta,
            preOrden,
            grupoConsolidacion,
            prioridadAbsoluta,
            grupoRutas,
            tiempoLatencia,
            tiempoEsperaPromedio,
            depositoSalida,
            depositoLlegada,
            campoDinamico,
            items,
            servicios,
            tipoJornada,
            jornadaDescripcion,
            codigoPostal,
            motivoEstadoParadaDescripcion,
            motivoEstadoParadaReferencia,
            fotos,
            paradaItems,
            remito,
            estadoOrden,
            idOrden,
            idJornada,
            pesoMaximo,
            volumenMaximo,
            bultosMaximo,
            costo,
            inicioVisita,
            finVisita,
            inicioHorarioEstimado,
            finHorarioEstimado,
            inicioHorarioReal,
            finHorarioReal,
            usarProductos,
            ultimaVisita,
            fecha,
            fechaOrden,
            datetime1,
            datetime2,
            fechaUltimoCambioEstado,
            unidades);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POrdenEntrega)) return false;
        POrdenEntrega other = (POrdenEntrega) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POrdenEntrega.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://unisolutions.com.ar/", "pOrdenEntrega"));
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
