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
 * Representation type, with at least one Representation element required (restriction)
 * 
 * <p>Java class for RepresentationReqrd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RepresentationReqrd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://rs.tdwg.org/UBIF/2006/}Representation">
 *       &lt;group ref="{http://rs.tdwg.org/UBIF/2006/}RepresentationGroup" maxOccurs="unbounded"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepresentationReqrd")
@XmlSeeAlso({
    IPRStatement.class
})
public class RepresentationReqrd
    extends Representation
{


}
