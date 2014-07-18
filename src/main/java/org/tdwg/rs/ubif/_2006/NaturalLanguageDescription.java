//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.18 at 10:21:36 AM MST 
//


package org.tdwg.rs.ubif._2006;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Descriptions entered as free-form text with optional (and potentially incomplete) markup referring to concepts (= char. tree nodes), characters, and states as defined in the terminology.
 * 
 * <p>Java class for NaturalLanguageDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NaturalLanguageDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}AbstractDescription">
 *       &lt;sequence>
 *         &lt;element name="NaturalLanguageData" type="{http://rs.tdwg.org/UBIF/2006/}NaturalLanguageMarkup"/>
 *         &lt;group ref="{http://rs.tdwg.org/UBIF/2006/}SpecificExtension" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaturalLanguageDescription", propOrder = {
    "naturalLanguageData",
    "nextVersion"
})
public class NaturalLanguageDescription
    extends AbstractDescription
{

    @XmlElement(name = "NaturalLanguageData", required = true)
    protected NaturalLanguageMarkup naturalLanguageData;
    @XmlElement(name = "NextVersion")
    protected VersionExtension nextVersion;

    /**
     * Gets the value of the naturalLanguageData property.
     * 
     * @return
     *     possible object is
     *     {@link NaturalLanguageMarkup }
     *     
     */
    public NaturalLanguageMarkup getNaturalLanguageData() {
        return naturalLanguageData;
    }

    /**
     * Sets the value of the naturalLanguageData property.
     * 
     * @param value
     *     allowed object is
     *     {@link NaturalLanguageMarkup }
     *     
     */
    public void setNaturalLanguageData(NaturalLanguageMarkup value) {
        this.naturalLanguageData = value;
    }

    /**
     * Gets the value of the nextVersion property.
     * 
     * @return
     *     possible object is
     *     {@link VersionExtension }
     *     
     */
    public VersionExtension getNextVersion() {
        return nextVersion;
    }

    /**
     * Sets the value of the nextVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionExtension }
     *     
     */
    public void setNextVersion(VersionExtension value) {
        this.nextVersion = value;
    }

}
