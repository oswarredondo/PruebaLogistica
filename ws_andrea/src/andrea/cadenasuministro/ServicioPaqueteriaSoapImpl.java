
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package andrea.cadenasuministro;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2016-09-09T10:07:57.482-05:00
 * Generated source version: 2.7.18
 * 
 */

@javax.jws.WebService(
                      serviceName = "ServicioPaqueteria",
                      portName = "ServicioPaqueteriaSoap12",
                      targetNamespace = "http://cadenasuministro.andrea/",
                      wsdlLocation = "http://localhost:5771/ServicioPaqueteriasEstandar.asmx?wsdl",
                      endpointInterface = "andrea.cadenasuministro.ServicioPaqueteriaSoap")
                      
public class ServicioPaqueteriaSoapImpl implements ServicioPaqueteriaSoap {

    private static final Logger LOG = Logger.getLogger(ServicioPaqueteriaSoapImpl.class.getName());

    /* (non-Javadoc)
     * @see andrea.cadenasuministro.ServicioPaqueteriaSoap#generarManifiestoGuia(java.lang.String  usuario ,)java.lang.String  contrasena ,)andrea.cadenasuministro.ArrayOfString  numerosGuias ,)java.lang.String  chofer ,)java.lang.String  placas ,)java.lang.String  camion ,)int  numeroManifiesto )*
     */
    public byte[] generarManifiestoGuia(java.lang.String usuario,java.lang.String contrasena,andrea.cadenasuministro.ArrayOfString numerosGuias,java.lang.String chofer,java.lang.String placas,java.lang.String camion,int numeroManifiesto) { 
        LOG.info("Executing operation generarManifiestoGuia");
        System.out.println(usuario);
        System.out.println(contrasena);
        System.out.println(numerosGuias);
        System.out.println(chofer);
        System.out.println(placas);
        System.out.println(camion);
        System.out.println(numeroManifiesto);
        try {
            byte[] _return = new byte[] {};
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see andrea.cadenasuministro.ServicioPaqueteriaSoap#generarGuiaEmbarque(java.lang.String  usuario ,)java.lang.String  contrasena ,)java.lang.String  folioOrdenServicio ,)andrea.cadenasuministro.DetalleEnvio  detalleEnvio ,)andrea.cadenasuministro.Destinatario  destinatario ,)andrea.cadenasuministro.ArrayOfPaquete  paquetes ,)java.lang.String  referenciaGuia )*
     */
    public java.lang.String generarGuiaEmbarque(java.lang.String usuario,java.lang.String contrasena,java.lang.String folioOrdenServicio,andrea.cadenasuministro.DetalleEnvio detalleEnvio,andrea.cadenasuministro.Destinatario destinatario,andrea.cadenasuministro.ArrayOfPaquete paquetes,java.lang.String referenciaGuia) { 
        LOG.info("Executing operation generarGuiaEmbarque");
        System.out.println(usuario);
        System.out.println(contrasena);
        System.out.println(folioOrdenServicio);
        System.out.println(detalleEnvio);
        System.out.println(destinatario);
        System.out.println(paquetes);
        System.out.println(referenciaGuia);
        try {
            java.lang.String _return = "_return-2115864819";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see andrea.cadenasuministro.ServicioPaqueteriaSoap#consultarTracking(java.lang.String  usuario ,)java.lang.String  contrasena ,)java.lang.String  guiasEmbarque )*
     */
    public andrea.cadenasuministro.ArrayOfTracking consultarTracking(java.lang.String usuario,java.lang.String contrasena,java.lang.String guiasEmbarque) { 
        LOG.info("Executing operation consultarTracking");
        System.out.println(usuario);
        System.out.println(contrasena);
        System.out.println(guiasEmbarque);
        try {
            andrea.cadenasuministro.ArrayOfTracking _return = new andrea.cadenasuministro.ArrayOfTracking();
            java.util.List<andrea.cadenasuministro.Tracking> _returnTracking = new java.util.ArrayList<andrea.cadenasuministro.Tracking>();
            andrea.cadenasuministro.Tracking _returnTrackingVal1 = new andrea.cadenasuministro.Tracking();
            _returnTrackingVal1.setGuiaEmbarque("GuiaEmbarque49359809");
            _returnTrackingVal1.setFechaMovimiento(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2016-09-09T10:07:57.614-05:00"));
            _returnTrackingVal1.setEstatusGuia("EstatusGuia-905522221");
            _returnTrackingVal1.setUbicacion("Ubicacion-20267933");
            _returnTrackingVal1.setPersonaRecibio("PersonaRecibio-822815004");
            _returnTrackingVal1.setTipoIdentificacion("TipoIdentificacion1592772752");
            _returnTrackingVal1.setIdentificacionID("IdentificacionID-835767175");
            _returnTrackingVal1.setObservaciones("Observaciones-813860311");
            _returnTracking.add(_returnTrackingVal1);
            _return.getTracking().addAll(_returnTracking);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see andrea.cadenasuministro.ServicioPaqueteriaSoap#cancelarGuiaEmbarque(java.lang.String  usuario ,)java.lang.String  contrasena ,)java.lang.String  guiaEmbarque )*
     */
    public java.lang.String cancelarGuiaEmbarque(java.lang.String usuario,java.lang.String contrasena,java.lang.String guiaEmbarque) { 
        LOG.info("Executing operation cancelarGuiaEmbarque");
        System.out.println(usuario);
        System.out.println(contrasena);
        System.out.println(guiaEmbarque);
        try {
            java.lang.String _return = "_return-788876584";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see andrea.cadenasuministro.ServicioPaqueteriaSoap#validarConvenio(java.lang.String  usuario ,)java.lang.String  contrasena ,)java.lang.String  claveConvenio )*
     */
    public boolean validarConvenio(java.lang.String usuario,java.lang.String contrasena,java.lang.String claveConvenio) { 
        LOG.info("Executing operation validarConvenio");
        System.out.println(usuario);
        System.out.println(contrasena);
        System.out.println(claveConvenio);
        try {
            boolean _return = false;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see andrea.cadenasuministro.ServicioPaqueteriaSoap#validarCobertura(java.lang.String  usuario ,)java.lang.String  contrasena ,)java.lang.String  codigoPostal )*
     */
    public boolean validarCobertura(java.lang.String usuario,java.lang.String contrasena,java.lang.String codigoPostal) { 
        LOG.info("Executing operation validarCobertura");
        System.out.println(usuario);
        System.out.println(contrasena);
        System.out.println(codigoPostal);
        try {
            boolean _return = false;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see andrea.cadenasuministro.ServicioPaqueteriaSoap#generarEtiquetaGuia(java.lang.String  usuario ,)java.lang.String  contrasena ,)java.lang.String  guiaEmbarque )*
     */
    public byte[] generarEtiquetaGuia(java.lang.String usuario,java.lang.String contrasena,java.lang.String guiaEmbarque) { 
        LOG.info("Executing operation generarEtiquetaGuia");
        System.out.println(usuario);
        System.out.println(contrasena);
        System.out.println(guiaEmbarque);
        try {
            byte[] _return = new byte[] {};
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
