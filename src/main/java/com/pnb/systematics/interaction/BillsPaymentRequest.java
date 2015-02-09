package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BillsPaymentRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillsPaymentRequest extends InteractionBase {
	
    
	@XmlElement(name = "currencyCode", required = true)
	private String currencyCode;
	
	@XmlElement(name = "branchCode", required = true)
	private String branchCode;
	
	@XmlElement(name = "accountId", required = true)
	private String accountId;
	
	@XmlElement(name = "merchantID", required = true)
	private String merchantID;
	
	@XmlElement(name = "subscriberNumber", required = true)
	private String subscriberNumber;
	
	@XmlElement(name = "billNo", required = true)
	private String billNo; 
	
	@XmlElement(name = "payeeName", required = true)
	private String payeeName;
	
	@XmlElement(name = "transactionAmount", required = true)
	private String transactionAmount;
	
	@XmlElement(name = "userReferenceNumber", required = true)
	private String userReferenceNumber;
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}
	public String getSubscriberNumber() {
		return subscriberNumber;
	}
	public void setSubscriberNumber(String subscriberNumber) {
		this.subscriberNumber = subscriberNumber;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getUserReferenceNumber() {
		return userReferenceNumber;
	}
	public void setUserReferenceNumber(String userReferenceNumber) {
		this.userReferenceNumber = userReferenceNumber;
	}

}
