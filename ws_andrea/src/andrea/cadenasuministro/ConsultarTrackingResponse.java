
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
 *         &lt;element name="ConsultarTrackingResult" type="{http://cadenasuministro.andrea/}ArrayOfTracking" minOccurs="0"/>
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
    "consultarTrackingResult"
})
@XmlRootElement(name = "ConsultarTrackingResponse")
public class ConsultarTrackingResponse {

    @XmlElement(name = "ConsultarTrackingResult")
    protected ArrayOfTracking consultarTrackingResult;

    /**
     * Obtiene el valor de la propiedad consultarTrackingResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTracking }
     *     
     */
    public ArrayOfTracking getConsultarTrackingResult() {
        return consultarTrackingResult;
    }

    /**
     * Define el valor de la propiedad consultarTrackingResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTracking }
     *     
     */
    public void setConsultarTrackingResult(ArrayOfTracking value) {
        this.consultarTrackingResult = value;
    }

}
