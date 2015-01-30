package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "BalanceInquiryRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class BalanceInquiryRequest extends InteractionBase {
	
	@XmlElement(required = true)
	private String accountId;

	@XmlElement(required = true)
	private String userReferenceNumber;
	
	@XmlElement(required = true)
	private String currencyCode;
	
	@XmlElement(required = true)
	private String branchCode;
	
	

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
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
