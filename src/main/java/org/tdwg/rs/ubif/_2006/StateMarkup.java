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
 * Variant of StateData to be used inside the NaturalLanguageDescription markup container.
 * 
 * <p>Java class for StateMarkup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StateMarkup">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}CharacterStateRef">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Modifier" type="{http://rs.tdwg.org/UBIF/2006/}ModifierMarkupRef"/>
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
@XmlType(name = "StateMarkup", propOrder = {
    "modifierOrNoteOrText"
})
public class StateMarkup
    extends CharacterStateRef
{

    @XmlElementRefs({
        @XmlElementRef(name = "Text", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Modifier", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Note", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> modifierOrNoteOrText;

    /**
     * Gets the value of the modifierOrNoteOrText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifierOrNoteOrText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifierOrNoteOrText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link MarkupText }{@code >}
     * {@link JAXBElement }{@code <}{@link ModifierMarkupRef }{@code >}
     * {@link JAXBElement }{@code <}{@link MarkupText }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getModifierOrNoteOrText() {
        if (modifierOrNoteOrText == null) {
            modifierOrNoteOrText = new ArrayList<JAXBElement<?>>();
        }
        return this.modifierOrNoteOrText;
    }

}
