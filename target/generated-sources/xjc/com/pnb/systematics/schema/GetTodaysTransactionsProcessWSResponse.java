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
 *         &lt;element name="getTodaysTransactionsProcessWSReturn" type="{http://webserviceclasses}GetTodaysTransactions_Output_Properties"/&gt;
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
    "getTodaysTransactionsProcessWSReturn"
})
@XmlRootElement(name = "getTodaysTransactionsProcessWSResponse")
public class GetTodaysTransactionsProcessWSResponse {

    @XmlElement(required = true, nillable = true)
    protected GetTodaysTransactionsOutputProperties getTodaysTransactionsProcessWSReturn;

    /**
     * Gets the value of the getTodaysTransactionsProcessWSReturn property.
     * 
     * @return
     *     possible object is
     *     {@link GetTodaysTransactionsOutputProperties }
     *     
     */
    public GetTodaysTransactionsOutputProperties getGetTodaysTransactionsProcessWSReturn() {
        return getTodaysTransactionsProcessWSReturn;
    }

    /**
     * Sets the value of the getTodaysTransactionsProcessWSReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTodaysTransactionsOutputProperties }
     *     
     */
    public void setGetTodaysTransactionsProcessWSReturn(GetTodaysTransactionsOutputProperties value) {
        this.getTodaysTransactionsProcessWSReturn = value;
    }

}
