
package main.Dance;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MusicTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="MusicTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Live"/&gt;
 *     &lt;enumeration value="Playback"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MusicTypeEnum")
@XmlEnum
public enum MusicTypeEnum {

    @XmlEnumValue("Live")
    LIVE("Live"),
    @XmlEnumValue("Playback")
    PLAYBACK("Playback");
    private final String value;

    MusicTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MusicTypeEnum fromValue(String v) {
        for (MusicTypeEnum c: MusicTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
