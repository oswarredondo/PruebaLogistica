package andrea.cadenasuministro;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2016-09-09T10:07:57.783-05:00
 * Generated source version: 2.7.18
 * 
 */
@WebServiceClient(name = "ServicioPaqueteria", 
                  wsdlLocation = "http://localhost:5771/ServicioPaqueteriasEstandar.asmx?wsdl",
                  targetNamespace = "http://cadenasuministro.andrea/") 
public class ServicioPaqueteria extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://cadenasuministro.andrea/", "ServicioPaqueteria");
    public final static QName ServicioPaqueteriaSoap12 = new QName("http://cadenasuministro.andrea/", "ServicioPaqueteriaSoap12");
    public final static QName ServicioPaqueteriaSoap = new QName("http://cadenasuministro.andrea/", "ServicioPaqueteriaSoap");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:5771/ServicioPaqueteriasEstandar.asmx?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ServicioPaqueteria.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:5771/ServicioPaqueteriasEstandar.asmx?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ServicioPaqueteria(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServicioPaqueteria(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioPaqueteria() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ServicioPaqueteria(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ServicioPaqueteria(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ServicioPaqueteria(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ServicioPaqueteriaSoap
     */
    @WebEndpoint(name = "ServicioPaqueteriaSoap12")
    public ServicioPaqueteriaSoap getServicioPaqueteriaSoap12() {
        return super.getPort(ServicioPaqueteriaSoap12, ServicioPaqueteriaSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioPaqueteriaSoap
     */
    @WebEndpoint(name = "ServicioPaqueteriaSoap12")
    public ServicioPaqueteriaSoap getServicioPaqueteriaSoap12(WebServiceFeature... features) {
        return super.getPort(ServicioPaqueteriaSoap12, ServicioPaqueteriaSoap.class, features);
    }
    /**
     *
     * @return
     *     returns ServicioPaqueteriaSoap
     */
    @WebEndpoint(name = "ServicioPaqueteriaSoap")
    public ServicioPaqueteriaSoap getServicioPaqueteriaSoap() {
        return super.getPort(ServicioPaqueteriaSoap, ServicioPaqueteriaSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioPaqueteriaSoap
     */
    @WebEndpoint(name = "ServicioPaqueteriaSoap")
    public ServicioPaqueteriaSoap getServicioPaqueteriaSoap(WebServiceFeature... features) {
        return super.getPort(ServicioPaqueteriaSoap, ServicioPaqueteriaSoap.class, features);
    }

}
