
package sde.project.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getBeerRatingUserResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getBeerRatingUserResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beer" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBeerRatingUserResponse", propOrder = {
    "beer"
})
public class GetBeerRatingUserResponse {

    protected double beer;

    /**
     * Gets the value of the beer property.
     * 
     */
    public double getBeer() {
        return beer;
    }

    /**
     * Sets the value of the beer property.
     * 
     */
    public void setBeer(double value) {
        this.beer = value;
    }

}
