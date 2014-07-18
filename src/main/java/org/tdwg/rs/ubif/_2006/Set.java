//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.18 at 10:21:36 AM MST 
//


package org.tdwg.rs.ubif._2006;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Elements form a set, each element may occur only once and order may be changed at any time.
 * 
 * <p>Java class for Set complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Set">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}CollectionContainer">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Set")
@XmlSeeAlso({
    AudienceSet.class,
    GeographicAreaSet.class,
    QuantitativeCharMappingSet.class,
    SummaryDataSet.class,
    NaturalLanguagePhraseSet.class,
    SamplingUnitDataSet.class,
    SamplingEventSet.class,
    LinkSet.class,
    TaxonHierarchySet.class,
    SpecimenSet.class,
    CharacterTreeSet.class,
    TaxonNameSet.class,
    TaxonomicScopeSet.class,
    AgentSet.class,
    CodedDescriptionSet.class,
    NaturalLanguageDescriptionSet.class,
    MediaObjectSet.class,
    DescriptiveConceptSet.class,
    RatingSet.class,
    CategoricalCharMappingSet.class,
    CharacterSet.class,
    CharTreeDesignedForSet.class,
    IPRStatementSet.class,
    IdentificationKeySet.class,
    PublicationSet.class,
    CharacterStateRefSet.class
})
public abstract class Set
    extends CollectionContainer
{


}
