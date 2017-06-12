//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.18 at 10:21:36 AM MST 
//


package org.tdwg.rs.ubif._2006;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * # Extends the abstract CharacterMarkup for use with categorical (char. state) data
 * 
 * <p>Java class for CategoricalMarkup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoricalMarkup">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}AbstractCharacterMarkup">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Status" type="{http://rs.tdwg.org/UBIF/2006/}DataStatusMarkup"/>
 *         &lt;element name="Modifier" type="{http://rs.tdwg.org/UBIF/2006/}ModifierMarkupRef"/>
 *         &lt;element name="State" type="{http://rs.tdwg.org/UBIF/2006/}StateMarkup"/>
 *         &lt;element name="Note" type="{http://rs.tdwg.org/UBIF/2006/}MarkupText"/>
 *         &lt;element name="Text" type="{http://rs.tdwg.org/UBIF/2006/}MarkupText"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoricalMarkup", propOrder = {
    "statusOrModifierOrState"
})
public class CategoricalMarkup
    extends AbstractCharacterMarkup
{

    @XmlElementRefs({
        @XmlElementRef(name = "Modifier", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Text", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Status", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Note", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "State", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> statusOrModifierOrState;

    /**
     * Gets the value of the statusOrModifierOrState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statusOrModifierOrState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatusOrModifierOrState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link MarkupText }{@code >}
     * {@link JAXBElement }{@code <}{@link ModifierMarkupRef }{@code >}
     * {@link JAXBElement }{@code <}{@link StateMarkup }{@code >}
     * {@link JAXBElement }{@code <}{@link DataStatusMarkup }{@code >}
     * {@link JAXBElement }{@code <}{@link MarkupText }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getStatusOrModifierOrState() {
        if (statusOrModifierOrState == null) {
            statusOrModifierOrState = new ArrayList<JAXBElement<?>>();
        }
        return this.statusOrModifierOrState;
    }

}
