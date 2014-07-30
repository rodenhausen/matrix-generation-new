//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.18 at 10:21:36 AM MST 
//


package org.tdwg.rs.ubif._2006;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * Extension of AgentRef with a role attribute and three attributes recording object-specific contributions.
 * 
 * <p>Java class for RichAgentRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RichAgentRef">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}AgentRef">
 *       &lt;attribute name="role" use="required" type="{http://rs.tdwg.org/UBIF/2006/}AgentRoleEnum" />
 *       &lt;attribute name="firstcontribution" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="lastcontribution" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="contributioncount" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RichAgentRef")
@XmlSeeAlso({
    OwnerRef.class,
    ContributorRef.class,
    CreatorRef.class,
    CreatorContributorRef.class
})
public class RichAgentRef
    extends AgentRef
{

    @XmlAttribute(name = "role", required = true)
    protected QName role;
    @XmlAttribute(name = "firstcontribution")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar firstcontribution;
    @XmlAttribute(name = "lastcontribution")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastcontribution;
    @XmlAttribute(name = "contributioncount")
    protected BigInteger contributioncount;

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setRole(QName value) {
        this.role = value;
    }

    /**
     * Gets the value of the firstcontribution property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFirstcontribution() {
        return firstcontribution;
    }

    /**
     * Sets the value of the firstcontribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFirstcontribution(XMLGregorianCalendar value) {
        this.firstcontribution = value;
    }

    /**
     * Gets the value of the lastcontribution property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastcontribution() {
        return lastcontribution;
    }

    /**
     * Sets the value of the lastcontribution property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastcontribution(XMLGregorianCalendar value) {
        this.lastcontribution = value;
    }

    /**
     * Gets the value of the contributioncount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getContributioncount() {
        return contributioncount;
    }

    /**
     * Sets the value of the contributioncount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setContributioncount(BigInteger value) {
        this.contributioncount = value;
    }

}