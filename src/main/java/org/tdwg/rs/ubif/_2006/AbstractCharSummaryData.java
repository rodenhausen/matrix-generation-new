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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;


/**
 * Abstract base type. Used in CodedDescription/CodedData/Char to make statements for a single character in a class or specimen.
 * 
 * <p>Java class for AbstractCharSummaryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractCharSummaryData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}CharacterRef">
 *       &lt;sequence>
 *         &lt;group ref="{http://rs.tdwg.org/UBIF/2006/}Extensions" minOccurs="0"/>
 *         &lt;element name="BasedOnSample" type="{http://rs.tdwg.org/UBIF/2006/}SamplingEventRef" minOccurs="0"/>
 *         &lt;element name="Ratings" type="{http://rs.tdwg.org/UBIF/2006/}RatingSet" minOccurs="0"/>
 *         &lt;element name="MediaObject" type="{http://rs.tdwg.org/UBIF/2006/}MediaObjectRef" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Note" type="{http://rs.tdwg.org/UBIF/2006/}LongStringL" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://rs.tdwg.org/UBIF/2006/}DataStatusData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="origin" type="{http://rs.tdwg.org/UBIF/2006/}DataOriginEnum" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractCharSummaryData", propOrder = {
    "nextVersionBase",
    "any",
    "basedOnSample",
    "ratings",
    "mediaObject",
    "note",
    "status"
})
@XmlSeeAlso({
    QuantSummaryData.class,
    FreeFormTextData.class,
    MolecularSequenceData.class,
    CatSummaryData.class
})
public abstract class AbstractCharSummaryData
    extends CharacterRef
{

    @XmlElement(name = "NextVersionBase")
    protected VersionExtension nextVersionBase;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlElement(name = "BasedOnSample")
    protected SamplingEventRef basedOnSample;
    @XmlElement(name = "Ratings")
    protected RatingSet ratings;
    @XmlElement(name = "MediaObject")
    protected List<MediaObjectRef> mediaObject;
    @XmlElement(name = "Note")
    protected List<LongStringL> note;
    @XmlElement(name = "Status")
    protected List<DataStatusData> status;
    @XmlAttribute(name = "origin")
    protected QName origin;

    /**
     * Gets the value of the nextVersionBase property.
     * 
     * @return
     *     possible object is
     *     {@link VersionExtension }
     *     
     */
    public VersionExtension getNextVersionBase() {
        return nextVersionBase;
    }

    /**
     * Sets the value of the nextVersionBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionExtension }
     *     
     */
    public void setNextVersionBase(VersionExtension value) {
        this.nextVersionBase = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets the value of the basedOnSample property.
     * 
     * @return
     *     possible object is
     *     {@link SamplingEventRef }
     *     
     */
    public SamplingEventRef getBasedOnSample() {
        return basedOnSample;
    }

    /**
     * Sets the value of the basedOnSample property.
     * 
     * @param value
     *     allowed object is
     *     {@link SamplingEventRef }
     *     
     */
    public void setBasedOnSample(SamplingEventRef value) {
        this.basedOnSample = value;
    }

    /**
     * Gets the value of the ratings property.
     * 
     * @return
     *     possible object is
     *     {@link RatingSet }
     *     
     */
    public RatingSet getRatings() {
        return ratings;
    }

    /**
     * Sets the value of the ratings property.
     * 
     * @param value
     *     allowed object is
     *     {@link RatingSet }
     *     
     */
    public void setRatings(RatingSet value) {
        this.ratings = value;
    }

    /**
     * Gets the value of the mediaObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mediaObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMediaObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MediaObjectRef }
     * 
     * 
     */
    public List<MediaObjectRef> getMediaObject() {
        if (mediaObject == null) {
            mediaObject = new ArrayList<MediaObjectRef>();
        }
        return this.mediaObject;
    }

    /**
     * Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LongStringL }
     * 
     * 
     */
    public List<LongStringL> getNote() {
        if (note == null) {
            note = new ArrayList<LongStringL>();
        }
        return this.note;
    }

    /**
     * Gets the value of the status property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataStatusData }
     * 
     * 
     */
    public List<DataStatusData> getStatus() {
        if (status == null) {
            status = new ArrayList<DataStatusData>();
        }
        return this.status;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setOrigin(QName value) {
        this.origin = value;
    }

}
