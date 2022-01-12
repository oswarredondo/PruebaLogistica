
package andrea.cadenasuministro;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfTracking complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTracking">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tracking" type="{http://cadenasuministro.andrea/}Tracking" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTracking", propOrder = {
    "tracking"
})
public class ArrayOfTracking {

    @XmlElement(name = "Tracking", nillable = true)
    protected List<Tracking> tracking;

    /**
     * Gets the value of the tracking property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tracking property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTracking().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tracking }
     * 
     * 
     */
    public List<Tracking> getTracking() {
        if (tracking == null) {
            tracking = new ArrayList<Tracking>();
        }
        return this.tracking;
    }

}
