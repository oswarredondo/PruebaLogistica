
package andrea.cadenasuministro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Destinatario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Destinatario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClaveCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApellidoPaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApellidoMaterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Calle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EntreCalles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoPostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Colonia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ciudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Convenio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Destinatario", propOrder = {
    "claveCliente",
    "nombre",
    "apellidoPaterno",
    "apellidoMaterno",
    "telefono",
    "calle",
    "numero",
    "entreCalles",
    "referencia",
    "codigoPostal",
    "colonia",
    "ciudad",
    "estado",
    "pais",
    "convenio"
})
public class Destinatario {

    @XmlElement(name = "ClaveCliente")
    protected String claveCliente;
    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "ApellidoPaterno")
    protected String apellidoPaterno;
    @XmlElement(name = "ApellidoMaterno")
    protected String apellidoMaterno;
    @XmlElement(name = "Telefono")
    protected String telefono;
    @XmlElement(name = "Calle")
    protected String calle;
    @XmlElement(name = "Numero")
    protected String numero;
    @XmlElement(name = "EntreCalles")
    protected String entreCalles;
    @XmlElement(name = "Referencia")
    protected String referencia;
    @XmlElement(name = "CodigoPostal")
    protected String codigoPostal;
    @XmlElement(name = "Colonia")
    protected String colonia;
    @XmlElement(name = "Ciudad")
    protected String ciudad;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "Pais")
    protected String pais;
    @XmlElement(name = "Convenio")
    protected String convenio;

    /**
     * Obtiene el valor de la propiedad claveCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveCliente() {
        return claveCliente;
    }

    /**
     * Define el valor de la propiedad claveCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveCliente(String value) {
        this.claveCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoPaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Define el valor de la propiedad apellidoPaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoPaterno(String value) {
        this.apellidoPaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoMaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Define el valor de la propiedad apellidoMaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoMaterno(String value) {
        this.apellidoMaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad calle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Define el valor de la propiedad calle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalle(String value) {
        this.calle = value;
    }

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad entreCalles.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntreCalles() {
        return entreCalles;
    }

    /**
     * Define el valor de la propiedad entreCalles.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntreCalles(String value) {
        this.entreCalles = value;
    }

    /**
     * Obtiene el valor de la propiedad referencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Define el valor de la propiedad referencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencia(String value) {
        this.referencia = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoPostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Define el valor de la propiedad codigoPostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPostal(String value) {
        this.codigoPostal = value;
    }

    /**
     * Obtiene el valor de la propiedad colonia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Define el valor de la propiedad colonia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColonia(String value) {
        this.colonia = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudad(String value) {
        this.ciudad = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define el valor de la propiedad pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

    /**
     * Obtiene el valor de la propiedad convenio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvenio() {
        return convenio;
    }

    /**
     * Define el valor de la propiedad convenio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvenio(String value) {
        this.convenio = value;
    }

}
