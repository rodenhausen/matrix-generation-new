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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * TaxonName plus core level extensions.
 * 
 * Note: Taxon names are not restricted to accepted names, it is also use to express Synonyms in the TaxonHierarchyNode type)
 * 
 * <p>Java class for TaxonNameCore complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxonNameCore">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}TaxonName">
 *       &lt;sequence>
 *         &lt;group ref="{http://rs.tdwg.org/UBIF/2006/}TaxonNameCoreExtensions"/>
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
@XmlType(name = "TaxonNameCore", propOrder = {
    "nomenclaturalCode",
    "rank",
    "canonicalName",
    "canonicalAuthorship",
    "conceptSuffix",
    "race",
    "taxonPlacement",
    "nextVersion"
})
public class TaxonNameCore
    extends TaxonIdentification
{

    @XmlElement(name = "NomenclaturalCode")
    protected QName nomenclaturalCode;
    @XmlElement(name = "Rank")
    protected TaxonomicRank rank;
    @XmlElement(name = "CanonicalName")
    protected LinneanCanonicalTaxonName canonicalName;
    @XmlElement(name = "CanonicalAuthorship")
    protected LinneanCanonicalTaxonAuthorship canonicalAuthorship;
    @XmlElement(name = "ConceptSuffix")
    protected CitationString conceptSuffix;
    @XmlElement(name = "Race")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String race;
    @XmlElement(name = "TaxonPlacement")
    protected TaxonNameRefSeq taxonPlacement;
    @XmlElement(name = "NextVersion")
    protected VersionExtension nextVersion;

    /**
     * Gets the value of the nomenclaturalCode property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getNomenclaturalCode() {
        return nomenclaturalCode;
    }

    /**
     * Sets the value of the nomenclaturalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setNomenclaturalCode(QName value) {
        this.nomenclaturalCode = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     * @return
     *     possible object is
     *     {@link TaxonomicRank }
     *     
     */
    public TaxonomicRank getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxonomicRank }
     *     
     */
    public void setRank(TaxonomicRank value) {
        this.rank = value;
    }

    /**
     * Gets the value of the canonicalName property.
     * 
     * @return
     *     possible object is
     *     {@link LinneanCanonicalTaxonName }
     *     
     */
    public LinneanCanonicalTaxonName getCanonicalName() {
        return canonicalName;
    }

    /**
     * Sets the value of the canonicalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinneanCanonicalTaxonName }
     *     
     */
    public void setCanonicalName(LinneanCanonicalTaxonName value) {
        this.canonicalName = value;
    }

    /**
     * Gets the value of the canonicalAuthorship property.
     * 
     * @return
     *     possible object is
     *     {@link LinneanCanonicalTaxonAuthorship }
     *     
     */
    public LinneanCanonicalTaxonAuthorship getCanonicalAuthorship() {
        return canonicalAuthorship;
    }

    /**
     * Sets the value of the canonicalAuthorship property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinneanCanonicalTaxonAuthorship }
     *     
     */
    public void setCanonicalAuthorship(LinneanCanonicalTaxonAuthorship value) {
        this.canonicalAuthorship = value;
    }

    /**
     * Gets the value of the conceptSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link CitationString }
     *     
     */
    public CitationString getConceptSuffix() {
        return conceptSuffix;
    }

    /**
     * Sets the value of the conceptSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitationString }
     *     
     */
    public void setConceptSuffix(CitationString value) {
        this.conceptSuffix = value;
    }

    /**
     * Gets the value of the race property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets the value of the race property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRace(String value) {
        this.race = value;
    }

    /**
     * Gets the value of the taxonPlacement property.
     * 
     * @return
     *     possible object is
     *     {@link TaxonNameRefSeq }
     *     
     */
    public TaxonNameRefSeq getTaxonPlacement() {
        return taxonPlacement;
    }

    /**
     * Sets the value of the taxonPlacement property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxonNameRefSeq }
     *     
     */
    public void setTaxonPlacement(TaxonNameRefSeq value) {
        this.taxonPlacement = value;
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
