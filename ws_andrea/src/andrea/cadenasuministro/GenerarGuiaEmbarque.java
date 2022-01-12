
package andrea.cadenasuministro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contrasena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="folioOrdenServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detalleEnvio" type="{http://cadenasuministro.andrea/}DetalleEnvio" minOccurs="0"/>
 *         &lt;element name="destinatario" type="{http://cadenasuministro.andrea/}Destinatario" minOccurs="0"/>
 *         &lt;element name="paquetes" type="{http://cadenasuministro.andrea/}ArrayOfPaquete" minOccurs="0"/>
 *         &lt;element name="ReferenciaGuia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "usuario",
    "contrasena",
    "folioOrdenServicio",
    "detalleEnvio",
    "destinatario",
    "paquetes",
    "referenciaGuia"
})
@XmlRootElement(name = "GenerarGuiaEmbarque")
public class GenerarGuiaEmbarque {

    protected String usuario;
    protected String contrasena;
    protected String folioOrdenServicio;
    protected DetalleEnvio detalleEnvio;
    protected Destinatario destinatario;
    protected ArrayOfPaquete paquetes;
    @XmlElement(name = "ReferenciaGuia")
    protected String referenciaGuia;

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtiene el valor de la propiedad contrasena.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Define el valor de la propiedad contrasena.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrasena(String value) {
        this.contrasena = value;
    }

    /**
     * Obtiene el valor de la propiedad folioOrdenServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolioOrdenServicio() {
        return folioOrdenServicio;
    }

    /**
     * Define el valor de la propiedad folioOrdenServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolioOrdenServicio(String value) {
        this.folioOrdenServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad detalleEnvio.
     * 
     * @return
     *     possible object is
     *     {@link DetalleEnvio }
     *     
     */
    public DetalleEnvio getDetalleEnvio() {
        return detalleEnvio;
    }

    /**
     * Define el valor de la propiedad detalleEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link DetalleEnvio }
     *     
     */
    public void setDetalleEnvio(DetalleEnvio value) {
        this.detalleEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad destinatario.
     * 
     * @return
     *     possible object is
     *     {@link Destinatario }
     *     
     */
    public Destinatario getDestinatario() {
        return destinatario;
    }

    /**
     * Define el valor de la propiedad destinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link Destinatario }
     *     
     */
    public void setDestinatario(Destinatario value) {
        this.destinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad paquetes.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPaquete }
     *     
     */
    public ArrayOfPaquete getPaquetes() {
        return paquetes;
    }

    /**
     * Define el valor de la propiedad paquetes.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPaquete }
     *     
     */
    public void setPaquetes(ArrayOfPaquete value) {
        this.paquetes = value;
    }

    /**
     * Obtiene el valor de la propiedad referenciaGuia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenciaGuia() {
        return referenciaGuia;
    }

    /**
     * Define el valor de la propiedad referenciaGuia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenciaGuia(String value) {
        this.referenciaGuia = value;
    }

}
