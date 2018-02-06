
package sde.project.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rateUserBeerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rateUserBeerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rateUserBeerResponse", propOrder = {
    "beer"
})
public class RateUserBeerResponse {

    protected boolean beer;

    /**
     * Gets the value of the beer property.
     * 
     */
    public boolean isBeer() {
        return beer;
    }

    /**
     * Sets the value of the beer property.
     * 
     */
    public void setBeer(boolean value) {
        this.beer = value;
    }

}
