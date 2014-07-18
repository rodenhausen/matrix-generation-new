//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.18 at 10:21:36 AM MST 
//


package org.tdwg.rs.ubif._2006;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * ShortStringL extended with LabelRoleEnum 'role' attribute.
 * 
 * Content is free form text that (usually uniquely) represent the object to human consumers. Such labels are often essential to preserve semantics if machine-readable links/IDs break. 
 * 
 * Content text may optionally be UBIF-formatted. 
 * 
 * In an LSID-based interaction, the 'title' metadata item may be considered a label with role='full'.
 * 
 * <p>Java class for LabelText complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LabelText">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://rs.tdwg.org/UBIF/2006/>ShortStringL">
 *       &lt;attribute name="role" type="{http://rs.tdwg.org/UBIF/2006/}LabelRoleEnum" default="Full" />
 *       &lt;anyAttribute namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LabelText")
public class LabelText
    extends ShortStringL
{

    @XmlAttribute(name = "role")
    protected QName role;

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRole() {
        if (role == null) {
            return new QName("http://rs.tdwg.org/UBIF/2006/", "Full", "");
        } else {
            return role;
        }
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

}
