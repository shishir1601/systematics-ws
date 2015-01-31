package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FundTransferRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class FundTransferRequest extends InteractionBase {
	
	@XmlElement(name = "currencyCode", required = true)
	private String currencyCode;
	
	@XmlElement(name = "fromAccountId", required = true)
	private String fromAccountId;
	
	@XmlElement(name = "fromBranchCode", required = true)
	private String fromBranchCode;
	
	@XmlElement(name = "toAccountId", required = true)
	private String toAccountId;
	
	@XmlElement(name = "toBranchCode", required = true)
	private String toBranchCode;
	
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
	public String getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public String getFromBranchCode() {
		return fromBranchCode;
	}
	public void setFromBranchCode(String fromBranchCode) {
		this.fromBranchCode = fromBranchCode;
	}
	public String getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}
	public String getToBranchCode() {
		return toBranchCode;
	}
	public void setToBranchCode(String toBranchCode) {
		this.toBranchCode = toBranchCode;
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
