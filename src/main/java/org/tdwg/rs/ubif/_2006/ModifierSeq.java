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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModifierSeq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModifierSeq">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}Seq">
 *       &lt;sequence>
 *         &lt;element name="Modifier" type="{http://rs.tdwg.org/UBIF/2006/}ModifierDef" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ordered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifierSeq", propOrder = {
    "modifier"
})
public class ModifierSeq
    extends Seq
{

    @XmlElement(name = "Modifier", required = true)
    protected List<ModifierDef> modifier;
    @XmlAttribute(name = "ordered")
    protected Boolean ordered;

    /**
     * Gets the value of the modifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModifierDef }
     * 
     * 
     */
    public List<ModifierDef> getModifier() {
        if (modifier == null) {
            modifier = new ArrayList<ModifierDef>();
        }
        return this.modifier;
    }

    /**
     * Gets the value of the ordered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOrdered() {
        if (ordered == null) {
            return false;
        } else {
            return ordered;
        }
    }

    /**
     * Sets the value of the ordered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOrdered(Boolean value) {
        this.ordered = value;
    }

}
