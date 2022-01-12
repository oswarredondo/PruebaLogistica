
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
 *         &lt;element name="NumerosGuias" type="{http://cadenasuministro.andrea/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="Chofer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Placas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Camion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumeroManifiesto" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "numerosGuias",
    "chofer",
    "placas",
    "camion",
    "numeroManifiesto"
})
@XmlRootElement(name = "GenerarManifiestoGuia")
public class GenerarManifiestoGuia {

    protected String usuario;
    protected String contrasena;
    @XmlElement(name = "NumerosGuias")
    protected ArrayOfString numerosGuias;
    @XmlElement(name = "Chofer")
    protected String chofer;
    @XmlElement(name = "Placas")
    protected String placas;
    @XmlElement(name = "Camion")
    protected String camion;
    @XmlElement(name = "NumeroManifiesto")
    protected int numeroManifiesto;

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
     * Obtiene el valor de la propiedad numerosGuias.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getNumerosGuias() {
        return numerosGuias;
    }

    /**
     * Define el valor de la propiedad numerosGuias.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setNumerosGuias(ArrayOfString value) {
        this.numerosGuias = value;
    }

    /**
     * Obtiene el valor de la propiedad chofer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChofer() {
        return chofer;
    }

    /**
     * Define el valor de la propiedad chofer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChofer(String value) {
        this.chofer = value;
    }

    /**
     * Obtiene el valor de la propiedad placas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacas() {
        return placas;
    }

    /**
     * Define el valor de la propiedad placas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacas(String value) {
        this.placas = value;
    }

    /**
     * Obtiene el valor de la propiedad camion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCamion() {
        return camion;
    }

    /**
     * Define el valor de la propiedad camion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamion(String value) {
        this.camion = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroManifiesto.
     * 
     */
    public int getNumeroManifiesto() {
        return numeroManifiesto;
    }

    /**
     * Define el valor de la propiedad numeroManifiesto.
     * 
     */
    public void setNumeroManifiesto(int value) {
        this.numeroManifiesto = value;
    }

}
