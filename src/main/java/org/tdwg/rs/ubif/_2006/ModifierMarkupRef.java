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
 * Actual modification of a statement for markup of natural language descriptions (with Text inside). Refers to a modifier of any type (frequency, certainty, spatial, temporal, etc.).
 * 
 * <p>Java class for ModifierMarkupRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModifierMarkupRef">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}ModifierRefWithData">
 *       &lt;sequence>
 *         &lt;element name="Text" type="{http://rs.tdwg.org/UBIF/2006/}MarkupText"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifierMarkupRef", propOrder = {
    "text"
})
public class ModifierMarkupRef
    extends ModifierRefWithData
{

    @XmlElement(name = "Text", required = true)
    protected MarkupText text;

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link MarkupText }
     *     
     */
    public MarkupText getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkupText }
     *     
     */
    public void setText(MarkupText value) {
        this.text = value;
    }

}
