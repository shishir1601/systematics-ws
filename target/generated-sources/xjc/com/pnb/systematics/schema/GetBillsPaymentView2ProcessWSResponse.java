//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.26 at 03:17:36 PM CST 
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
 *         &lt;element name="getBillsPaymentView2ProcessWSReturn" type="{http://webserviceclasses}GetBillsPaymentView2_Output_Properties"/&gt;
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
    "getBillsPaymentView2ProcessWSReturn"
})
@XmlRootElement(name = "getBillsPaymentView2ProcessWSResponse")
public class GetBillsPaymentView2ProcessWSResponse {

    @XmlElement(required = true, nillable = true)
    protected GetBillsPaymentView2OutputProperties getBillsPaymentView2ProcessWSReturn;

    /**
     * Gets the value of the getBillsPaymentView2ProcessWSReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetBillsPaymentView2OutputProperties }
     *     
     */
    public GetBillsPaymentView2OutputProperties getGetBillsPaymentView2ProcessWSReturn() {
        return getBillsPaymentView2ProcessWSReturn;
    }

    /**
     * Sets the value of the getBillsPaymentView2ProcessWSReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetBillsPaymentView2OutputProperties }
     *     
     */
    public void setGetBillsPaymentView2ProcessWSReturn(GetBillsPaymentView2OutputProperties value) {
        this.getBillsPaymentView2ProcessWSReturn = value;
    }

}
