
package main.Dance;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SceneTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="SceneTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ConcertHall"/&gt;
 *     &lt;enumeration value="Street"/&gt;
 *     &lt;enumeration value="TVStudio"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SceneTypeEnum")
@XmlEnum
public enum SceneTypeEnum {

    @XmlEnumValue("ConcertHall")
    CONCERT_HALL("ConcertHall"),
    @XmlEnumValue("Street")
    STREET("Street"),
    @XmlEnumValue("TVStudio")
    TV_STUDIO("TVStudio");
    private final String value;

    SceneTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SceneTypeEnum fromValue(String v) {
        for (SceneTypeEnum c: SceneTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
