
package main.Dance;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DanceTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="DanceTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Ballroom"/&gt;
 *     &lt;enumeration value="Folk"/&gt;
 *     &lt;enumeration value="Stage"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DanceTypeEnum")
@XmlEnum
public enum DanceTypeEnum {

    @XmlEnumValue("Ballroom")
    BALLROOM("Ballroom"),
    @XmlEnumValue("Folk")
    FOLK("Folk"),
    @XmlEnumValue("Stage")
    STAGE("Stage");
    private final String value;

    DanceTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DanceTypeEnum fromValue(String v) {
        for (DanceTypeEnum c: DanceTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
