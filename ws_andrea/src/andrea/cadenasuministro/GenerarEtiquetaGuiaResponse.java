
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
 *         &lt;element name="GenerarEtiquetaGuiaResult" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
    "generarEtiquetaGuiaResult"
})
@XmlRootElement(name = "GenerarEtiquetaGuiaResponse")
public class GenerarEtiquetaGuiaResponse {

    @XmlElement(name = "GenerarEtiquetaGuiaResult")
    protected byte[] generarEtiquetaGuiaResult;

    /**
     * Obtiene el valor de la propiedad generarEtiquetaGuiaResult.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGenerarEtiquetaGuiaResult() {
        return generarEtiquetaGuiaResult;
    }

    /**
     * Define el valor de la propiedad generarEtiquetaGuiaResult.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGenerarEtiquetaGuiaResult(byte[] value) {
        this.generarEtiquetaGuiaResult = value;
    }

}
