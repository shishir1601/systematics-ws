//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.23 at 07:04:01 PM CST 
//


package com.pnb.systematics.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="isValidMFUserProcessWSReturn" type="{http://webserviceclasses}IsValidMFUser_Output_Properties"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isValidMFUserProcessWSReturn"
})
@XmlRootElement(name = "isValidMFUserProcessWSResponse")
public class IsValidMFUserProcessWSResponse {

    @XmlElement(required = true, nillable = true)
    protected IsValidMFUserOutputProperties isValidMFUserProcessWSReturn;

    /**
     * Gets the value of the isValidMFUserProcessWSReturn property.
     * 
     * @return
     *     possible object is
     *     {@link IsValidMFUserOutputProperties }
     *     
     */
    public IsValidMFUserOutputProperties getIsValidMFUserProcessWSReturn() {
        return isValidMFUserProcessWSReturn;
    }

    /**
     * Sets the value of the isValidMFUserProcessWSReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsValidMFUserOutputProperties }
     *     
     */
    public void setIsValidMFUserProcessWSReturn(IsValidMFUserOutputProperties value) {
        this.isValidMFUserProcessWSReturn = value;
    }

}
