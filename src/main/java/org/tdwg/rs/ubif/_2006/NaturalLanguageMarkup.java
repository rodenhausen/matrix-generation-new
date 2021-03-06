//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.18 at 10:21:36 AM MST 
//


package org.tdwg.rs.ubif._2006;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * The root of natural language markup is identical to ConceptMarkup, except that the concept ref attribute is prohibited.
 * 
 * <p>Java class for NaturalLanguageMarkup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NaturalLanguageMarkup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{http://rs.tdwg.org/UBIF/2006/}MarkupGroup" maxOccurs="unbounded"/>
 *       &lt;attribute name="parsed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NaturalLanguageMarkup", propOrder = {
    "markupGroup"
})
public class NaturalLanguageMarkup {

    @XmlElements({
        @XmlElement(name = "Categorical", type = CategoricalMarkup.class),
        @XmlElement(name = "Quantitative", type = QuantitativeMarkup.class),
        @XmlElement(name = "Text", type = MarkupText.class),
        @XmlElement(name = "TextChar", type = FreeFormTextMarkup.class),
        @XmlElement(name = "Concept", type = ConceptMarkup.class)
    })
    protected List<Object> markupGroup;
    @XmlAttribute(name = "parsed")
    protected Boolean parsed;

    /**
     * Gets the value of the markupGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the markupGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarkupGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoricalMarkup }
     * {@link QuantitativeMarkup }
     * {@link MarkupText }
     * {@link FreeFormTextMarkup }
     * {@link ConceptMarkup }
     * 
     * 
     */
    public List<Object> getMarkupGroup() {
        if (markupGroup == null) {
            markupGroup = new ArrayList<Object>();
        }
        return this.markupGroup;
    }

    /**
     * Gets the value of the parsed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isParsed() {
        if (parsed == null) {
            return false;
        } else {
            return parsed;
        }
    }

    /**
     * Sets the value of the parsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setParsed(Boolean value) {
        this.parsed = value;
    }

}
