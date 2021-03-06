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
 * <p>Java class for OnMerchantChangePassword_Output_Properties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OnMerchantChangePassword_Output_Properties"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HPubMacroMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="HPubScreenState" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="confirmPassword" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
 *         &lt;element name="merchantID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="newPassword" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="retMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "OnMerchantChangePassword_Output_Properties", propOrder = {
    "hPubMacroMessage",
    "hPubScreenState",
    "confirmPassword",
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
    "merchantID",
    "newPassword",
    "password",
    "retMessage",
    "userID",
    "hPubXMLProperties",
    "hPubAccessHandle",
    "hPubStyleSheet",
    "hPubXMLData"
})
public class OnMerchantChangePasswordOutputProperties {

    @XmlElement(name = "HPubMacroMessage", required = true, nillable = true)
    protected String hPubMacroMessage;
    @XmlElement(name = "HPubScreenState", required = true, nillable = true)
    protected String hPubScreenState;
    @XmlElement(required = true, nillable = true)
    protected String confirmPassword;
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
    protected String merchantID;
    @XmlElement(required = true, nillable = true)
    protected String newPassword;
    @XmlElement(required = true, nillable = true)
    protected String password;
    @XmlElement(required = true, nillable = true)
    protected String retMessage;
    @XmlElement(required = true, nillable = true)
    protected String userID;
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
     * Gets the value of the confirmPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Sets the value of the confirmPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmPassword(String value) {
        this.confirmPassword = value;
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
     * Gets the value of the newPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the value of the newPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPassword(String value) {
        this.newPassword = value;
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
     * Gets the value of the retMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetMessage() {
        return retMessage;
    }

    /**
     * Sets the value of the retMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetMessage(String value) {
        this.retMessage = value;
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
