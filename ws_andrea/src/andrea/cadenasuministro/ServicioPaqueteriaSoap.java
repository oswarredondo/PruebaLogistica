package andrea.cadenasuministro;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2016-09-09T10:07:57.712-05:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://cadenasuministro.andrea/", name = "ServicioPaqueteriaSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface ServicioPaqueteriaSoap {

    @WebResult(name = "GenerarManifiestoGuiaResult", targetNamespace = "http://cadenasuministro.andrea/")
    @RequestWrapper(localName = "GenerarManifiestoGuia", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.GenerarManifiestoGuia")
    @WebMethod(operationName = "GenerarManifiestoGuia", action = "http://cadenasuministro.andrea/GenerarManifiestoGuia")
    @ResponseWrapper(localName = "GenerarManifiestoGuiaResponse", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.GenerarManifiestoGuiaResponse")
    public byte[] generarManifiestoGuia (
        @WebParam(name = "usuario", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String usuario,
        @WebParam(name = "contrasena", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String contrasena,
        @WebParam(name = "NumerosGuias", targetNamespace = "http://cadenasuministro.andrea/")
        andrea.cadenasuministro.ArrayOfString numerosGuias,
        @WebParam(name = "Chofer", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String chofer,
        @WebParam(name = "Placas", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String placas,
        @WebParam(name = "Camion", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String camion,
        @WebParam(name = "NumeroManifiesto", targetNamespace = "http://cadenasuministro.andrea/")
        int numeroManifiesto
    ) throws Exception;

    @WebResult(name = "GenerarGuiaEmbarqueResult", targetNamespace = "http://cadenasuministro.andrea/")
    @RequestWrapper(localName = "GenerarGuiaEmbarque", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.GenerarGuiaEmbarque")
    @WebMethod(operationName = "GenerarGuiaEmbarque", action = "http://cadenasuministro.andrea/GenerarGuiaEmbarque")
    @ResponseWrapper(localName = "GenerarGuiaEmbarqueResponse", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.GenerarGuiaEmbarqueResponse")
    public java.lang.String generarGuiaEmbarque(
        @WebParam(name = "usuario", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String usuario,
        @WebParam(name = "contrasena", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String contrasena,
        @WebParam(name = "folioOrdenServicio", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String folioOrdenServicio,
        @WebParam(name = "detalleEnvio", targetNamespace = "http://cadenasuministro.andrea/")
        andrea.cadenasuministro.DetalleEnvio detalleEnvio,
        @WebParam(name = "destinatario", targetNamespace = "http://cadenasuministro.andrea/")
        andrea.cadenasuministro.Destinatario destinatario,
        @WebParam(name = "paquetes", targetNamespace = "http://cadenasuministro.andrea/")
        andrea.cadenasuministro.ArrayOfPaquete paquetes,
        @WebParam(name = "ReferenciaGuia", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String referenciaGuia
    ) throws Exception;

    @WebResult(name = "ConsultarTrackingResult", targetNamespace = "http://cadenasuministro.andrea/")
    @RequestWrapper(localName = "ConsultarTracking", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.ConsultarTracking")
    @WebMethod(operationName = "ConsultarTracking", action = "http://cadenasuministro.andrea/ConsultarTracking")
    @ResponseWrapper(localName = "ConsultarTrackingResponse", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.ConsultarTrackingResponse")
    public andrea.cadenasuministro.ArrayOfTracking consultarTracking(
        @WebParam(name = "usuario", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String usuario,
        @WebParam(name = "contrasena", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String contrasena,
        @WebParam(name = "guiasEmbarque", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String guiasEmbarque
    ) throws Exception;

    @WebResult(name = "CancelarGuiaEmbarqueResult", targetNamespace = "http://cadenasuministro.andrea/")
    @RequestWrapper(localName = "CancelarGuiaEmbarque", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.CancelarGuiaEmbarque")
    @WebMethod(operationName = "CancelarGuiaEmbarque", action = "http://cadenasuministro.andrea/CancelarGuiaEmbarque")
    @ResponseWrapper(localName = "CancelarGuiaEmbarqueResponse", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.CancelarGuiaEmbarqueResponse")
    public java.lang.String cancelarGuiaEmbarque(
        @WebParam(name = "usuario", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String usuario,
        @WebParam(name = "contrasena", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String contrasena,
        @WebParam(name = "guiaEmbarque", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String guiaEmbarque
    ) throws Exception;

    @WebResult(name = "ValidarConvenioResult", targetNamespace = "http://cadenasuministro.andrea/")
    @RequestWrapper(localName = "ValidarConvenio", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.ValidarConvenio")
    @WebMethod(operationName = "ValidarConvenio", action = "http://cadenasuministro.andrea/ValidarConvenio")
    @ResponseWrapper(localName = "ValidarConvenioResponse", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.ValidarConvenioResponse")
    public boolean validarConvenio(
        @WebParam(name = "usuario", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String usuario,
        @WebParam(name = "contrasena", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String contrasena,
        @WebParam(name = "ClaveConvenio", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String claveConvenio
    ) throws Exception;

    @WebResult(name = "ValidarCoberturaResult", targetNamespace = "http://cadenasuministro.andrea/")
    @RequestWrapper(localName = "ValidarCobertura", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.ValidarCobertura")
    @WebMethod(operationName = "ValidarCobertura", action = "http://cadenasuministro.andrea/ValidarCobertura")
    @ResponseWrapper(localName = "ValidarCoberturaResponse", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.ValidarCoberturaResponse")
    public boolean validarCobertura(
        @WebParam(name = "usuario", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String usuario,
        @WebParam(name = "contrasena", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String contrasena,
        @WebParam(name = "CodigoPostal", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String codigoPostal
    ) throws Exception;

    @WebResult(name = "GenerarEtiquetaGuiaResult", targetNamespace = "http://cadenasuministro.andrea/")
    @RequestWrapper(localName = "GenerarEtiquetaGuia", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.GenerarEtiquetaGuia")
    @WebMethod(operationName = "GenerarEtiquetaGuia", action = "http://cadenasuministro.andrea/GenerarEtiquetaGuia")
    @ResponseWrapper(localName = "GenerarEtiquetaGuiaResponse", targetNamespace = "http://cadenasuministro.andrea/", className = "andrea.cadenasuministro.GenerarEtiquetaGuiaResponse")
    public byte[] generarEtiquetaGuia(
        @WebParam(name = "usuario", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String usuario,
        @WebParam(name = "contrasena", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String contrasena,
        @WebParam(name = "guiaEmbarque", targetNamespace = "http://cadenasuministro.andrea/")
        java.lang.String guiaEmbarque
    ) throws Exception;
}
