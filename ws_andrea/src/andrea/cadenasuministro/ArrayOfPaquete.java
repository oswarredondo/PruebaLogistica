
package andrea.cadenasuministro;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfPaquete complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPaquete">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Paquete" type="{http://cadenasuministro.andrea/}Paquete" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPaquete", propOrder = {
    "paquete"
})
public class ArrayOfPaquete {

    @XmlElement(name = "Paquete", nillable = true)
    protected List<Paquete> paquete;

    /**
     * Gets the value of the paquete property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paquete property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaquete().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Paquete }
     * 
     * 
     */
    public List<Paquete> getPaquete() {
        if (paquete == null) {
            paquete = new ArrayList<Paquete>();
        }
        return this.paquete;
    }

}
