
package andrea.cadenasuministro;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Paquete complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Paquete">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaqueteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Peso" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Valor" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TipoMercancia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Volumen" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DescripcionMercancia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Paquete", propOrder = {
    "paqueteID",
    "cantidad",
    "peso",
    "valor",
    "tipoMercancia",
    "volumen",
    "descripcionMercancia"
})
public class Paquete {

    @XmlElement(name = "PaqueteID")
    protected String paqueteID;
    @XmlElement(name = "Cantidad")
    protected int cantidad;
    @XmlElement(name = "Peso", required = true)
    protected BigDecimal peso;
    @XmlElement(name = "Valor", required = true)
    protected BigDecimal valor;
    @XmlElement(name = "TipoMercancia")
    protected String tipoMercancia;
    @XmlElement(name = "Volumen", required = true)
    protected BigDecimal volumen;
    @XmlElement(name = "DescripcionMercancia")
    protected String descripcionMercancia;

    /**
     * Obtiene el valor de la propiedad paqueteID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaqueteID() {
        return paqueteID;
    }

    /**
     * Define el valor de la propiedad paqueteID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaqueteID(String value) {
        this.paqueteID = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad peso.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPeso() {
        return peso;
    }

    /**
     * Define el valor de la propiedad peso.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPeso(BigDecimal value) {
        this.peso = value;
    }

    /**
     * Obtiene el valor de la propiedad valor.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * Define el valor de la propiedad valor.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValor(BigDecimal value) {
        this.valor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoMercancia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoMercancia() {
        return tipoMercancia;
    }

    /**
     * Define el valor de la propiedad tipoMercancia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoMercancia(String value) {
        this.tipoMercancia = value;
    }

    /**
     * Obtiene el valor de la propiedad volumen.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumen() {
        return volumen;
    }

    /**
     * Define el valor de la propiedad volumen.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumen(BigDecimal value) {
        this.volumen = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionMercancia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionMercancia() {
        return descripcionMercancia;
    }

    /**
     * Define el valor de la propiedad descripcionMercancia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionMercancia(String value) {
        this.descripcionMercancia = value;
    }

}
