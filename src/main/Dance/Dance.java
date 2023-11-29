
package main.Dance;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{}IDType"/&gt;
 *         &lt;element name="Type" type="{}DanceTypeEnum"/&gt;
 *         &lt;element name="Scene" type="{}SceneTypeEnum"/&gt;
 *         &lt;element name="NumberOfDancers" type="{}NumberOfDancersEnum"/&gt;
 *         &lt;element name="Music" type="{}MusicTypeEnum"/&gt;
 *         &lt;element name="Dancers" type="{}DancersType"/&gt;
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "type",
    "scene",
    "numberOfDancers",
    "music",
    "dancers",
    "number"
})
@XmlRootElement(name = "Dance")
public class Dance {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected DanceTypeEnum type;
    @XmlElement(name = "Scene", required = true)
    @XmlSchemaType(name = "string")
    protected SceneTypeEnum scene;
    @XmlElement(name = "NumberOfDancers", required = true)
    @XmlSchemaType(name = "string")
    protected NumberOfDancersEnum numberOfDancers;
    @XmlElement(name = "Music", required = true)
    @XmlSchemaType(name = "string")
    protected MusicTypeEnum music;
    @XmlElement(name = "Dancers", required = true)
    protected DancersType dancers;
    @XmlElement(name = "Number", required = true)
    protected BigInteger number;

    public static Dance fromXml(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Dance.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Dance) unmarshaller.unmarshal(new StringReader(xml));
    }

    public String toXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Dance.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(this, writer);
        return writer.toString();
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link DanceTypeEnum }
     *
     */
    public DanceTypeEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link DanceTypeEnum }
     *
     */
    public void setType(DanceTypeEnum value) {
        this.type = value;
    }

    /**
     * Gets the value of the scene property.
     *
     * @return
     *     possible object is
     *     {@link SceneTypeEnum }
     *
     */
    public SceneTypeEnum getScene() {
        return scene;
    }

    /**
     * Sets the value of the scene property.
     *
     * @param value
     *     allowed object is
     *     {@link SceneTypeEnum }
     *
     */
    public void setScene(SceneTypeEnum value) {
        this.scene = value;
    }

    /**
     * Gets the value of the numberOfDancers property.
     *
     * @return
     *     possible object is
     *     {@link NumberOfDancersEnum }
     *
     */
    public NumberOfDancersEnum getNumberOfDancers() {
        return numberOfDancers;
    }

    /**
     * Sets the value of the numberOfDancers property.
     *
     * @param value
     *     allowed object is
     *     {@link NumberOfDancersEnum }
     *
     */
    public void setNumberOfDancers(NumberOfDancersEnum value) {
        this.numberOfDancers = value;
    }

    /**
     * Gets the value of the music property.
     *
     * @return
     *     possible object is
     *     {@link MusicTypeEnum }
     *
     */
    public MusicTypeEnum getMusic() {
        return music;
    }

    /**
     * Sets the value of the music property.
     *
     * @param value
     *     allowed object is
     *     {@link MusicTypeEnum }
     *
     */
    public void setMusic(MusicTypeEnum value) {
        this.music = value;
    }

    /**
     * Gets the value of the dancers property.
     *
     * @return
     *     possible object is
     *     {@link DancersType }
     *
     */
    public DancersType getDancers() {
        return dancers;
    }

    /**
     * Sets the value of the dancers property.
     *
     * @param value
     *     allowed object is
     *     {@link DancersType }
     *
     */
    public void setDancers(DancersType value) {
        this.dancers = value;
    }

    /**
     * Gets the value of the number property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNumber(BigInteger value) {
        this.number = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(type).append("\n");
        sb.append("Scene: ").append(scene).append("\n");
        sb.append("NumberOfDancers: ").append(numberOfDancers).append("\n");
        sb.append("Music: ").append(music).append("\n");
        sb.append("Number: ").append(number).append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Dancers: \n");
        for (DancerType dancer : dancers.getDancer()) {
            sb.append("  Name: ").append(dancer.getName()).append("\n");
            sb.append("  Age: ").append(dancer.getAge()).append("\n");
        }
        return sb.toString();
    }
}
