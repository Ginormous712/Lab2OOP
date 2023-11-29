
package main.Dance;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumberOfDancersEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="NumberOfDancersEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Mass"/&gt;
 *     &lt;enumeration value="Solo"/&gt;
 *     &lt;enumeration value="Pair"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NumberOfDancersEnum")
@XmlEnum
public enum NumberOfDancersEnum {

    @XmlEnumValue("Mass")
    MASS("Mass"),
    @XmlEnumValue("Solo")
    SOLO("Solo"),
    @XmlEnumValue("Pair")
    PAIR("Pair");
    private final String value;

    NumberOfDancersEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NumberOfDancersEnum fromValue(String v) {
        for (NumberOfDancersEnum c: NumberOfDancersEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
