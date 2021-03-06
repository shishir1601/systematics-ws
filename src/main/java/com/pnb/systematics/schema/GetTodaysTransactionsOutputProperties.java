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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetTodaysTransactions_Output_Properties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTodaysTransactions_Output_Properties"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HPubMacroMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubScreenState" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="accountnumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="companyname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="creditCount" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="debitCount" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="enddate_dd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="enddate_mm" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="enddate_yy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="endingBalance" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="forwardBalance" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubBeanName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubBeanType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubEndChainName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubEndType" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="HPubErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubErrorOccurred" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="HPubLinkKey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubOutputParmSuffix" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubStartChainName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubStartPoolName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubStartType" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startdate_dd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startdate_mm" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startdate_yy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="todayBalance" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="todayBranch" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="todayCheckNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="todayCredit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="todayDebit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="todayTeller" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="todayTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="todayTransaction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="totalCredit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="totalDebit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubXMLProperties" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubAccessHandle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubStyleSheet" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubXMLData" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTodaysTransactions_Output_Properties", propOrder = {
    "hPubMacroMessage",
    "hPubScreenState",
    "accountnumber",
    "companyname",
    "creditCount",
    "debitCount",
    "enddateDd",
    "enddateMm",
    "enddateYy",
    "endingBalance",
    "errorMessage",
    "forwardBalance",
    "hPubBeanName",
    "hPubBeanType",
    "hPubEndChainName",
    "hPubEndType",
    "hPubErrorMessage",
    "hPubErrorOccurred",
    "hPubLinkKey",
    "hPubOutputParmSuffix",
    "hPubStartChainName",
    "hPubStartPoolName",
    "hPubStartType",
    "password",
    "startdateDd",
    "startdateMm",
    "startdateYy",
    "todayBalance",
    "todayBranch",
    "todayCheckNo",
    "todayCredit",
    "todayDebit",
    "todayTeller",
    "todayTime",
    "todayTransaction",
    "totalCredit",
    "totalDebit",
    "username",
    "hPubXMLProperties",
    "hPubAccessHandle",
    "hPubStyleSheet",
    "hPubXMLData"
})
public class GetTodaysTransactionsOutputProperties {

    @XmlElement(name = "HPubMacroMessage", required = true, nillable = true)
    protected String hPubMacroMessage;
    @XmlElement(name = "HPubScreenState", required = true, nillable = true)
    protected String hPubScreenState;
    @XmlElement(required = true, nillable = true)
    protected String accountnumber;
    @XmlElement(required = true, nillable = true)
    protected String companyname;
    @XmlElement(required = true, nillable = true)
    protected String creditCount;
    @XmlElement(required = true, nillable = true)
    protected String debitCount;
    @XmlElement(name = "enddate_dd", required = true, nillable = true)
    protected String enddateDd;
    @XmlElement(name = "enddate_mm", required = true, nillable = true)
    protected String enddateMm;
    @XmlElement(name = "enddate_yy", required = true, nillable = true)
    protected String enddateYy;
    @XmlElement(required = true, nillable = true)
    protected String endingBalance;
    @XmlElement(required = true, nillable = true)
    protected String errorMessage;
    @XmlElement(required = true, nillable = true)
    protected String forwardBalance;
    @XmlElement(name = "HPubBeanName", required = true, nillable = true)
    protected String hPubBeanName;
    @XmlElement(name = "HPubBeanType", required = true, nillable = true)
    protected String hPubBeanType;
    @XmlElement(name = "HPubEndChainName", required = true, nillable = true)
    protected String hPubEndChainName;
    @XmlElement(name = "HPubEndType")
    protected int hPubEndType;
    @XmlElement(name = "HPubErrorMessage", required = true, nillable = true)
    protected String hPubErrorMessage;
    @XmlElement(name = "HPubErrorOccurred")
    protected int hPubErrorOccurred;
    @XmlElement(name = "HPubLinkKey", required = true, nillable = true)
    protected String hPubLinkKey;
    @XmlElement(name = "HPubOutputParmSuffix", required = true, nillable = true)
    protected String hPubOutputParmSuffix;
    @XmlElement(name = "HPubStartChainName", required = true, nillable = true)
    protected String hPubStartChainName;
    @XmlElement(name = "HPubStartPoolName", required = true, nillable = true)
    protected String hPubStartPoolName;
    @XmlElement(name = "HPubStartType")
    protected int hPubStartType;
    @XmlElement(required = true, nillable = true)
    protected String password;
    @XmlElement(name = "startdate_dd", required = true, nillable = true)
    protected String startdateDd;
    @XmlElement(name = "startdate_mm", required = true, nillable = true)
    protected String startdateMm;
    @XmlElement(name = "startdate_yy", required = true, nillable = true)
    protected String startdateYy;
    @XmlElement(required = true, nillable = true)
    protected String todayBalance;
    @XmlElement(required = true, nillable = true)
    protected String todayBranch;
    @XmlElement(required = true, nillable = true)
    protected String todayCheckNo;
    @XmlElement(required = true, nillable = true)
    protected String todayCredit;
    @XmlElement(required = true, nillable = true)
    protected String todayDebit;
    @XmlElement(required = true, nillable = true)
    protected String todayTeller;
    @XmlElement(required = true, nillable = true)
    protected String todayTime;
    @XmlElement(required = true, nillable = true)
    protected String todayTransaction;
    @XmlElement(required = true, nillable = true)
    protected String totalCredit;
    @XmlElement(required = true, nillable = true)
    protected String totalDebit;
    @XmlElement(required = true, nillable = true)
    protected String username;
    @XmlElement(name = "HPubXMLProperties", required = true, nillable = true)
    protected String hPubXMLProperties;
    @XmlElement(name = "HPubAccessHandle", required = true, nillable = true)
    protected String hPubAccessHandle;
    @XmlElement(name = "HPubStyleSheet", required = true, nillable = true)
    protected String hPubStyleSheet;
    @XmlElement(name = "HPubXMLData", required = true, nillable = true)
    protected String hPubXMLData;

    /**
     * Gets the value of the hPubMacroMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubMacroMessage() {
        return hPubMacroMessage;
    }

    /**
     * Sets the value of the hPubMacroMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubMacroMessage(String value) {
        this.hPubMacroMessage = value;
    }

    /**
     * Gets the value of the hPubScreenState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubScreenState() {
        return hPubScreenState;
    }

    /**
     * Sets the value of the hPubScreenState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubScreenState(String value) {
        this.hPubScreenState = value;
    }

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
     * Gets the value of the creditCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCount() {
        return creditCount;
    }

    /**
     * Sets the value of the creditCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCount(String value) {
        this.creditCount = value;
    }

    /**
     * Gets the value of the debitCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebitCount() {
        return debitCount;
    }

    /**
     * Sets the value of the debitCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebitCount(String value) {
        this.debitCount = value;
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
     * Gets the value of the endingBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndingBalance() {
        return endingBalance;
    }

    /**
     * Sets the value of the endingBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndingBalance(String value) {
        this.endingBalance = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the forwardBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForwardBalance() {
        return forwardBalance;
    }

    /**
     * Sets the value of the forwardBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForwardBalance(String value) {
        this.forwardBalance = value;
    }

    /**
     * Gets the value of the hPubBeanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubBeanName() {
        return hPubBeanName;
    }

    /**
     * Sets the value of the hPubBeanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubBeanName(String value) {
        this.hPubBeanName = value;
    }

    /**
     * Gets the value of the hPubBeanType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubBeanType() {
        return hPubBeanType;
    }

    /**
     * Sets the value of the hPubBeanType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubBeanType(String value) {
        this.hPubBeanType = value;
    }

    /**
     * Gets the value of the hPubEndChainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubEndChainName() {
        return hPubEndChainName;
    }

    /**
     * Sets the value of the hPubEndChainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubEndChainName(String value) {
        this.hPubEndChainName = value;
    }

    /**
     * Gets the value of the hPubEndType property.
     * 
     */
    public int getHPubEndType() {
        return hPubEndType;
    }

    /**
     * Sets the value of the hPubEndType property.
     * 
     */
    public void setHPubEndType(int value) {
        this.hPubEndType = value;
    }

    /**
     * Gets the value of the hPubErrorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubErrorMessage() {
        return hPubErrorMessage;
    }

    /**
     * Sets the value of the hPubErrorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubErrorMessage(String value) {
        this.hPubErrorMessage = value;
    }

    /**
     * Gets the value of the hPubErrorOccurred property.
     * 
     */
    public int getHPubErrorOccurred() {
        return hPubErrorOccurred;
    }

    /**
     * Sets the value of the hPubErrorOccurred property.
     * 
     */
    public void setHPubErrorOccurred(int value) {
        this.hPubErrorOccurred = value;
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
     * Gets the value of the hPubOutputParmSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubOutputParmSuffix() {
        return hPubOutputParmSuffix;
    }

    /**
     * Sets the value of the hPubOutputParmSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubOutputParmSuffix(String value) {
        this.hPubOutputParmSuffix = value;
    }

    /**
     * Gets the value of the hPubStartChainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubStartChainName() {
        return hPubStartChainName;
    }

    /**
     * Sets the value of the hPubStartChainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubStartChainName(String value) {
        this.hPubStartChainName = value;
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
     * Gets the value of the hPubStartType property.
     * 
     */
    public int getHPubStartType() {
        return hPubStartType;
    }

    /**
     * Sets the value of the hPubStartType property.
     * 
     */
    public void setHPubStartType(int value) {
        this.hPubStartType = value;
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
     * Gets the value of the todayBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTodayBalance() {
        return todayBalance;
    }

    /**
     * Sets the value of the todayBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTodayBalance(String value) {
        this.todayBalance = value;
    }

    /**
     * Gets the value of the todayBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTodayBranch() {
        return todayBranch;
    }

    /**
     * Sets the value of the todayBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTodayBranch(String value) {
        this.todayBranch = value;
    }

    /**
     * Gets the value of the todayCheckNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTodayCheckNo() {
        return todayCheckNo;
    }

    /**
     * Sets the value of the todayCheckNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTodayCheckNo(String value) {
        this.todayCheckNo = value;
    }

    /**
     * Gets the value of the todayCredit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTodayCredit() {
        return todayCredit;
    }

    /**
     * Sets the value of the todayCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTodayCredit(String value) {
        this.todayCredit = value;
    }

    /**
     * Gets the value of the todayDebit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTodayDebit() {
        return todayDebit;
    }

    /**
     * Sets the value of the todayDebit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTodayDebit(String value) {
        this.todayDebit = value;
    }

    /**
     * Gets the value of the todayTeller property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTodayTeller() {
        return todayTeller;
    }

    /**
     * Sets the value of the todayTeller property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTodayTeller(String value) {
        this.todayTeller = value;
    }

    /**
     * Gets the value of the todayTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTodayTime() {
        return todayTime;
    }

    /**
     * Sets the value of the todayTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTodayTime(String value) {
        this.todayTime = value;
    }

    /**
     * Gets the value of the todayTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTodayTransaction() {
        return todayTransaction;
    }

    /**
     * Sets the value of the todayTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTodayTransaction(String value) {
        this.todayTransaction = value;
    }

    /**
     * Gets the value of the totalCredit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalCredit() {
        return totalCredit;
    }

    /**
     * Sets the value of the totalCredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalCredit(String value) {
        this.totalCredit = value;
    }

    /**
     * Gets the value of the totalDebit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalDebit() {
        return totalDebit;
    }

    /**
     * Sets the value of the totalDebit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalDebit(String value) {
        this.totalDebit = value;
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
     * Gets the value of the hPubXMLProperties property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubXMLProperties() {
        return hPubXMLProperties;
    }

    /**
     * Sets the value of the hPubXMLProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubXMLProperties(String value) {
        this.hPubXMLProperties = value;
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

    /**
     * Gets the value of the hPubXMLData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHPubXMLData() {
        return hPubXMLData;
    }

    /**
     * Sets the value of the hPubXMLData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHPubXMLData(String value) {
        this.hPubXMLData = value;
    }

}
