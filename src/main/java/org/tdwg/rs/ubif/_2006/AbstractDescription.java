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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Abstract base type for NaturalLanguageDescription
 * and CodedDescription.
 * 
 * The id attribute is currently not used in keyrefs from within this schema. However, it is considered generally useful to uniquely identify descriptions in federated situations.
 * 
 * <p>Java class for AbstractDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}VersionedAbstractObject">
 *       &lt;sequence>
 *         &lt;element name="Scope" type="{http://rs.tdwg.org/UBIF/2006/}DescriptionScopeSet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractDescription", propOrder = {
    "scope"
})
@XmlSeeAlso({
    CodedDescription.class,
    NaturalLanguageDescription.class
})
public abstract class AbstractDescription
    extends VersionedAbstractObject
{

    @XmlElement(name = "Scope")
    protected DescriptionScopeSet scope;

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionScopeSet }
     *     
     */
    public DescriptionScopeSet getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionScopeSet }
     *     
     */
    public void setScope(DescriptionScopeSet value) {
        this.scope = value;
    }

}
