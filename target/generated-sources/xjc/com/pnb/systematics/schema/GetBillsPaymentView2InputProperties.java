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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetBillsPaymentView2_Input_Properties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBillsPaymentView2_Input_Properties"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubLinkKey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubStartPoolName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="merchantID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mm" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="yy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubAccessHandle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubStyleSheet" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBillsPaymentView2_Input_Properties", propOrder = {
    "dd",
    "hPubLinkKey",
    "hPubStartPoolName",
    "merchantID",
    "mm",
    "password",
    "userID",
    "yy",
    "hPubAccessHandle",
    "hPubStyleSheet"
})
public class GetBillsPaymentView2InputProperties {

    @XmlElement(required = true, nillable = true)
    protected String dd;
    @XmlElement(name = "HPubLinkKey", required = true, nillable = true)
    protected String hPubLinkKey;
    @XmlElement(name = "HPubStartPoolName", required = true, nillable = true)
    protected String hPubStartPoolName;
    @XmlElement(required = true, nillable = true)
    protected String merchantID;
    @XmlElement(required = true, nillable = true)
    protected String mm;
    @XmlElement(required = true, nillable = true)
    protected String password;
    @XmlElement(required = true, nillable = true)
    protected String userID;
    @XmlElement(required = true, nillable = true)
    protected String yy;
    @XmlElement(name = "HPubAccessHandle", required = true, nillable = true)
    protected String hPubAccessHandle;
    @XmlElement(name = "HPubStyleSheet", required = true, nillable = true)
    protected String hPubStyleSheet;

    /**
     * Gets the value of the dd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDd() {
        return dd;
    }

    /**
     * Sets the value of the dd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDd(String value) {
        this.dd = value;
    }

    /**
     * Gets the value of the hPubLinkKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubLinkKey() {
        return hPubLinkKey;
    }

    /**
     * Sets the value of the hPubLinkKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubLinkKey(String value) {
        this.hPubLinkKey = value;
    }

    /**
     * Gets the value of the hPubStartPoolName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubStartPoolName() {
        return hPubStartPoolName;
    }

    /**
     * Sets the value of the hPubStartPoolName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubStartPoolName(String value) {
        this.hPubStartPoolName = value;
    }

    /**
     * Gets the value of the merchantID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantID(String value) {
        this.merchantID = value;
    }

    /**
     * Gets the value of the mm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMm() {
        return mm;
    }

    /**
     * Sets the value of the mm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMm(String value) {
        this.mm = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Gets the value of the yy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYy() {
        return yy;
    }

    /**
     * Sets the value of the yy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYy(String value) {
        this.yy = value;
    }

    /**
     * Gets the value of the hPubAccessHandle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubAccessHandle() {
        return hPubAccessHandle;
    }

    /**
     * Sets the value of the hPubAccessHandle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubAccessHandle(String value) {
        this.hPubAccessHandle = value;
    }

    /**
     * Gets the value of the hPubStyleSheet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubStyleSheet() {
        return hPubStyleSheet;
    }

    /**
     * Sets the value of the hPubStyleSheet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubStyleSheet(String value) {
        this.hPubStyleSheet = value;
    }

}
