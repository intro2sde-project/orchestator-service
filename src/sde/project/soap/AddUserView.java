
package sde.project.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addUserView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addUserView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://soap.project.sde/}user" minOccurs="0"/>
 *         &lt;element name="beer" type="{http://soap.project.sde/}beer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addUserView", propOrder = {
    "user",
    "beer"
})
public class AddUserView {

    protected User user;
    protected Beer beer;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the beer property.
     * 
     * @return
     *     possible object is
     *     {@link Beer }
     *     
     */
    public Beer getBeer() {
        return beer;
    }

    /**
     * Sets the value of the beer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Beer }
     *     
     */
    public void setBeer(Beer value) {
        this.beer = value;
    }

}
