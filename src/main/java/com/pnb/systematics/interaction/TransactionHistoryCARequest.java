package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TransactionHistoryCARequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionHistoryCARequest extends InteractionBase {

	@XmlElement(name = "currencyCode", required = true)
	private String currencyCode;
	
	@XmlElement(name = "branchCode", required = true)
	private String branchCode;
	
	@XmlElement(name = "accountId", required = true)
	private String accountId;
	
	@XmlElement(name = "userReferenceNumber")
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
	public String getUserReferenceNumber() {
		return userReferenceNumber;
	}
	public void setUserReferenceNumber(String userReferenceNumber) {
		this.userReferenceNumber = userReferenceNumber;
	}

}
