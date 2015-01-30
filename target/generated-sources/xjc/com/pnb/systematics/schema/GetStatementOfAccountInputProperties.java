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
 * <p>Java class for GetStatementOfAccount_Input_Properties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetStatementOfAccount_Input_Properties"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountnumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="companyname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="enddate_dd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="enddate_mm" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="enddate_yy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubLinkKey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubStartPoolName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startdate_dd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startdate_mm" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startdate_yy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "GetStatementOfAccount_Input_Properties", propOrder = {
    "accountnumber",
    "companyname",
    "enddateDd",
    "enddateMm",
    "enddateYy",
    "hPubLinkKey",
    "hPubStartPoolName",
    "password",
    "startdateDd",
    "startdateMm",
    "startdateYy",
    "username",
    "hPubAccessHandle",
    "hPubStyleSheet"
})
public class GetStatementOfAccountInputProperties {

    @XmlElement(required = true, nillable = true)
    protected String accountnumber;
    @XmlElement(required = true, nillable = true)
    protected String companyname;
    @XmlElement(name = "enddate_dd", required = true, nillable = true)
    protected String enddateDd;
    @XmlElement(name = "enddate_mm", required = true, nillable = true)
    protected String enddateMm;
    @XmlElement(name = "enddate_yy", required = true, nillable = true)
    protected String enddateYy;
    @XmlElement(name = "HPubLinkKey", required = true, nillable = true)
    protected String hPubLinkKey;
    @XmlElement(name = "HPubStartPoolName", required = true, nillable = true)
    protected String hPubStartPoolName;
    @XmlElement(required = true, nillable = true)
    protected String password;
    @XmlElement(name = "startdate_dd", required = true, nillable = true)
    protected String startdateDd;
    @XmlElement(name = "startdate_mm", required = true, nillable = true)
    protected String startdateMm;
    @XmlElement(name = "startdate_yy", required = true, nillable = true)
    protected String startdateYy;
    @XmlElement(required = true, nillable = true)
    protected String username;
    @XmlElement(name = "HPubAccessHandle", required = true, nillable = true)
    protected String hPubAccessHandle;
    @XmlElement(name = "HPubStyleSheet", required = true, nillable = true)
    protected String hPubStyleSheet;

    /**
     * Gets the value of the accountnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountnumber() {
        return accountnumber;
    }

    /**
     * Sets the value of the accountnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountnumber(String value) {
        this.accountnumber = value;
    }

    /**
     * Gets the value of the companyname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * Sets the value of the companyname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyname(String value) {
        this.companyname = value;
    }

    /**
     * Gets the value of the enddateDd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnddateDd() {
        return enddateDd;
    }

    /**
     * Sets the value of the enddateDd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnddateDd(String value) {
        this.enddateDd = value;
    }

    /**
     * Gets the value of the enddateMm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnddateMm() {
        return enddateMm;
    }

    /**
     * Sets the value of the enddateMm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnddateMm(String value) {
        this.enddateMm = value;
    }

    /**
     * Gets the value of the enddateYy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnddateYy() {
        return enddateYy;
    }

    /**
     * Sets the value of the enddateYy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnddateYy(String value) {
        this.enddateYy = value;
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
     * Gets the value of the startdateDd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartdateDd() {
        return startdateDd;
    }

    /**
     * Sets the value of the startdateDd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartdateDd(String value) {
        this.startdateDd = value;
    }

    /**
     * Gets the value of the startdateMm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartdateMm() {
        return startdateMm;
    }

    /**
     * Sets the value of the startdateMm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartdateMm(String value) {
        this.startdateMm = value;
    }

    /**
     * Gets the value of the startdateYy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartdateYy() {
        return startdateYy;
    }

    /**
     * Sets the value of the startdateYy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartdateYy(String value) {
        this.startdateYy = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
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
