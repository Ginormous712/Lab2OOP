
package main.Dance;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DancersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DancersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Dancer" type="{}DancerType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DancersType", propOrder = {
    "dancer"
})
public class DancersType {

    @XmlElement(name = "Dancer", required = true)
    protected List<DancerType> dancer;

    /**
     * Gets the value of the dancer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the dancer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDancer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DancerType }
     * 
     * 
     */
    public List<DancerType> getDancer() {
        if (dancer == null) {
            dancer = new ArrayList<DancerType>();
        }
        return this.dancer;
    }

    public void setDancer(List<DancerType> dancer) {
        this.dancer = dancer;
    }

}
