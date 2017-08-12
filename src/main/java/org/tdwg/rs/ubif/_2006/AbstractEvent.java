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
 * Basic object type (representation not required), plus event data (date/time span, geo-location as geographic area).
 * 
 * <p>Java class for AbstractEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}AbstractObjectOrEventBase">
 *       &lt;sequence>
 *         &lt;element name="DateTime" type="{http://rs.tdwg.org/UBIF/2006/}CompositeDateTime" minOccurs="0"/>
 *         &lt;element name="DateTimeSpanEnd" type="{http://rs.tdwg.org/UBIF/2006/}CompositeDateTime" minOccurs="0"/>
 *         &lt;element name="GeographicArea" type="{http://rs.tdwg.org/UBIF/2006/}GeographicAreaRef" minOccurs="0"/>
 *         &lt;element name="Coordinates" type="{http://rs.tdwg.org/UBIF/2006/}GeographicalCoordinates" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractEvent", propOrder = {
    "dateTime",
    "dateTimeSpanEnd",
    "geographicArea",
    "coordinates"
})
@XmlSeeAlso({
    SamplingEvent.class
})
public abstract class AbstractEvent
    extends AbstractObjectOrEventBase
{

    @XmlElement(name = "DateTime")
    protected CompositeDateTime dateTime;
    @XmlElement(name = "DateTimeSpanEnd")
    protected CompositeDateTime dateTimeSpanEnd;
    @XmlElement(name = "GeographicArea")
    protected GeographicAreaRef geographicArea;
    @XmlElement(name = "Coordinates")
    protected GeographicalCoordinates coordinates;

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link CompositeDateTime }
     *     
     */
    public CompositeDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompositeDateTime }
     *     
     */
    public void setDateTime(CompositeDateTime value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the dateTimeSpanEnd property.
     * 
     * @return
     *     possible object is
     *     {@link CompositeDateTime }
     *     
     */
    public CompositeDateTime getDateTimeSpanEnd() {
        return dateTimeSpanEnd;
    }

    /**
     * Sets the value of the dateTimeSpanEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompositeDateTime }
     *     
     */
    public void setDateTimeSpanEnd(CompositeDateTime value) {
        this.dateTimeSpanEnd = value;
    }

    /**
     * Gets the value of the geographicArea property.
     * 
     * @return
     *     possible object is
     *     {@link GeographicAreaRef }
     *     
     */
    public GeographicAreaRef getGeographicArea() {
        return geographicArea;
    }

    /**
     * Sets the value of the geographicArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeographicAreaRef }
     *     
     */
    public void setGeographicArea(GeographicAreaRef value) {
        this.geographicArea = value;
    }

    /**
     * Gets the value of the coordinates property.
     * 
     * @return
     *     possible object is
     *     {@link GeographicalCoordinates }
     *     
     */
    public GeographicalCoordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the value of the coordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeographicalCoordinates }
     *     
     */
    public void setCoordinates(GeographicalCoordinates value) {
        this.coordinates = value;
    }

}
