
package com.ws.interchange;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ws.interchange package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProcesaPlazaResponse_QNAME = new QName("http://interchange.ws.com/", "procesaPlazaResponse");
    private final static QName _Procesa_QNAME = new QName("http://interchange.ws.com/", "procesa");
    private final static QName _IsCorrectServer_QNAME = new QName("http://interchange.ws.com/", "isCorrectServer");
    private final static QName _IsCorrectServerResponse_QNAME = new QName("http://interchange.ws.com/", "isCorrectServerResponse");
    private final static QName _ProcesaPlaza_QNAME = new QName("http://interchange.ws.com/", "procesaPlaza");
    private final static QName _ProcesaResponse_QNAME = new QName("http://interchange.ws.com/", "procesaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ws.interchange
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsCorrectServer }
     * 
     */
    public IsCorrectServer createIsCorrectServer() {
        return new IsCorrectServer();
    }

    /**
     * Create an instance of {@link Procesa }
     * 
     */
    public Procesa createProcesa() {
        return new Procesa();
    }

    /**
     * Create an instance of {@link ProcesaPlazaResponse }
     * 
     */
    public ProcesaPlazaResponse createProcesaPlazaResponse() {
        return new ProcesaPlazaResponse();
    }

    /**
     * Create an instance of {@link ProcesaPlaza }
     * 
     */
    public ProcesaPlaza createProcesaPlaza() {
        return new ProcesaPlaza();
    }

    /**
     * Create an instance of {@link IsCorrectServerResponse }
     * 
     */
    public IsCorrectServerResponse createIsCorrectServerResponse() {
        return new IsCorrectServerResponse();
    }

    /**
     * Create an instance of {@link ProcesaResponse }
     * 
     */
    public ProcesaResponse createProcesaResponse() {
        return new ProcesaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcesaPlazaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interchange.ws.com/", name = "procesaPlazaResponse")
    public JAXBElement<ProcesaPlazaResponse> createProcesaPlazaResponse(ProcesaPlazaResponse value) {
        return new JAXBElement<ProcesaPlazaResponse>(_ProcesaPlazaResponse_QNAME, ProcesaPlazaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Procesa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interchange.ws.com/", name = "procesa")
    public JAXBElement<Procesa> createProcesa(Procesa value) {
        return new JAXBElement<Procesa>(_Procesa_QNAME, Procesa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsCorrectServer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interchange.ws.com/", name = "isCorrectServer")
    public JAXBElement<IsCorrectServer> createIsCorrectServer(IsCorrectServer value) {
        return new JAXBElement<IsCorrectServer>(_IsCorrectServer_QNAME, IsCorrectServer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsCorrectServerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interchange.ws.com/", name = "isCorrectServerResponse")
    public JAXBElement<IsCorrectServerResponse> createIsCorrectServerResponse(IsCorrectServerResponse value) {
        return new JAXBElement<IsCorrectServerResponse>(_IsCorrectServerResponse_QNAME, IsCorrectServerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcesaPlaza }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interchange.ws.com/", name = "procesaPlaza")
    public JAXBElement<ProcesaPlaza> createProcesaPlaza(ProcesaPlaza value) {
        return new JAXBElement<ProcesaPlaza>(_ProcesaPlaza_QNAME, ProcesaPlaza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcesaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interchange.ws.com/", name = "procesaResponse")
    public JAXBElement<ProcesaResponse> createProcesaResponse(ProcesaResponse value) {
        return new JAXBElement<ProcesaResponse>(_ProcesaResponse_QNAME, ProcesaResponse.class, null, value);
    }

}
