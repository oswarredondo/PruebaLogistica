
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
 *         &lt;element name="ValidarConvenioResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "validarConvenioResult"
})
@XmlRootElement(name = "ValidarConvenioResponse")
public class ValidarConvenioResponse {

    @XmlElement(name = "ValidarConvenioResult")
    protected boolean validarConvenioResult;

    /**
     * Obtiene el valor de la propiedad validarConvenioResult.
     * 
     */
    public boolean isValidarConvenioResult() {
        return validarConvenioResult;
    }

    /**
     * Define el valor de la propiedad validarConvenioResult.
     * 
     */
    public void setValidarConvenioResult(boolean value) {
        this.validarConvenioResult = value;
    }

}
