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
 *         &lt;element name="getBillsPaymentInquiryProcessWSReturn" type="{http://webserviceclasses}GetBillsPaymentInquiry_Output_Properties"/&gt;
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
    "getBillsPaymentInquiryProcessWSReturn"
})
@XmlRootElement(name = "getBillsPaymentInquiryProcessWSResponse")
public class GetBillsPaymentInquiryProcessWSResponse {

    @XmlElement(required = true, nillable = true)
    protected GetBillsPaymentInquiryOutputProperties getBillsPaymentInquiryProcessWSReturn;

    /**
     * Gets the value of the getBillsPaymentInquiryProcessWSReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetBillsPaymentInquiryOutputProperties }
     *     
     */
    public GetBillsPaymentInquiryOutputProperties getGetBillsPaymentInquiryProcessWSReturn() {
        return getBillsPaymentInquiryProcessWSReturn;
    }

    /**
     * Sets the value of the getBillsPaymentInquiryProcessWSReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetBillsPaymentInquiryOutputProperties }
     *     
     */
    public void setGetBillsPaymentInquiryProcessWSReturn(GetBillsPaymentInquiryOutputProperties value) {
        this.getBillsPaymentInquiryProcessWSReturn = value;
    }

}
