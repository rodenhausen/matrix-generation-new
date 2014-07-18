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
 * # Derived from AbstractCharacterDefinition to be used in instance documents (non-abstract type).
 * 
 * Categorical data include nominal and ordinal data (DELTA types UM/OM and NEXUS types). Other terms for categorical data in statistics are 'qualitative data' or 'attributes'. The term 'attribute' has been avoided in SDD because it has different definitions in statistics, programming, databases, DELTA, etc. Both 'qualitative' and 'attribute' are ambiguos as to whether ordinal/ ranked variables are in- or excluded.
 * 
 * <p>Java class for CategoricalCharacter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoricalCharacter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}AbstractCharacterDefinition">
 *       &lt;sequence>
 *         &lt;element name="States" type="{http://rs.tdwg.org/UBIF/2006/}CharacterStateSeq"/>
 *         &lt;element name="Mappings" type="{http://rs.tdwg.org/UBIF/2006/}CategoricalCharMappingSet" minOccurs="0"/>
 *         &lt;element name="Assumptions" type="{http://rs.tdwg.org/UBIF/2006/}CategoricalCharAssumptions" minOccurs="0"/>
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
@XmlType(name = "CategoricalCharacter", propOrder = {
    "states",
    "mappings",
    "assumptions",
    "nextVersion"
})
public class CategoricalCharacter
    extends AbstractCharacterDefinition
{

    @XmlElement(name = "States", required = true)
    protected CharacterStateSeq states;
    @XmlElement(name = "Mappings")
    protected CategoricalCharMappingSet mappings;
    @XmlElement(name = "Assumptions")
    protected CategoricalCharAssumptions assumptions;
    @XmlElement(name = "NextVersion")
    protected VersionExtension nextVersion;

    /**
     * Gets the value of the states property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStateSeq }
     *     
     */
    public CharacterStateSeq getStates() {
        return states;
    }

    /**
     * Sets the value of the states property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStateSeq }
     *     
     */
    public void setStates(CharacterStateSeq value) {
        this.states = value;
    }

    /**
     * Gets the value of the mappings property.
     * 
     * @return
     *     possible object is
     *     {@link CategoricalCharMappingSet }
     *     
     */
    public CategoricalCharMappingSet getMappings() {
        return mappings;
    }

    /**
     * Sets the value of the mappings property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoricalCharMappingSet }
     *     
     */
    public void setMappings(CategoricalCharMappingSet value) {
        this.mappings = value;
    }

    /**
     * Gets the value of the assumptions property.
     * 
     * @return
     *     possible object is
     *     {@link CategoricalCharAssumptions }
     *     
     */
    public CategoricalCharAssumptions getAssumptions() {
        return assumptions;
    }

    /**
     * Sets the value of the assumptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoricalCharAssumptions }
     *     
     */
    public void setAssumptions(CategoricalCharAssumptions value) {
        this.assumptions = value;
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
