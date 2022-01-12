
package andrea.cadenasuministro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para DetalleEnvio complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DetalleEnvio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FechaInicioRecoleccion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaFinRecoleccion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetalleEnvio", propOrder = {
    "fechaInicioRecoleccion",
    "fechaFinRecoleccion"
})
public class DetalleEnvio {

    @XmlElement(name = "FechaInicioRecoleccion", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicioRecoleccion;
    @XmlElement(name = "FechaFinRecoleccion", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFinRecoleccion;

    /**
     * Obtiene el valor de la propiedad fechaInicioRecoleccion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicioRecoleccion() {
        return fechaInicioRecoleccion;
    }

    /**
     * Define el valor de la propiedad fechaInicioRecoleccion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicioRecoleccion(XMLGregorianCalendar value) {
        this.fechaInicioRecoleccion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFinRecoleccion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaFinRecoleccion() {
        return fechaFinRecoleccion;
    }

    /**
     * Define el valor de la propiedad fechaFinRecoleccion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaFinRecoleccion(XMLGregorianCalendar value) {
        this.fechaFinRecoleccion = value;
    }

}
