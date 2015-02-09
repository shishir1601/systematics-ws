package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;


@XmlRootElement(name = "DebitMemoStRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class DebitMemoStRequest extends InteractionBase {

	@XmlElement(name = "currencyCode", required = true)
	private String currencyCode;
	
	@XmlElement(name = "branchCode", required = true)
	private String branchCode;
	
	@XmlElement(name = "accountId", required = true)
	private String accountId;
	
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
