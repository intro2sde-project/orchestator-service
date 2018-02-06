
package sde.project.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readBeer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readBeer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idBeer" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readBeer", propOrder = {
    "idBeer"
})
public class ReadBeer {

    protected long idBeer;

    /**
     * Gets the value of the idBeer property.
     * 
     */
    public long getIdBeer() {
        return idBeer;
    }

    /**
     * Sets the value of the idBeer property.
     * 
     */
    public void setIdBeer(long value) {
        this.idBeer = value;
    }

}
