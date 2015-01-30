package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BalanceInquiryResponse")
public class BalanceInquiryResponse extends InteractionBase {
	
	private String transactionStatusCode;
	private String accountId;
	private String memoBalance;
	private String floatAmount;
	private String balanceOnHold;
	private String pleadgeAmount;
	private String accountStatus;
	private String customerShortName;
	private String userReferenceNumber;
	private String errorCode;
	private String replyText;
	private String unavailableBalance;
	private String availableBalance;
	
	public String getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getUnavailableBalance() {
		return unavailableBalance;
	}

	public void setUnavailableBalance(String unavailableBalance) {
		this.unavailableBalance = unavailableBalance;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public String getTransactionStatusCode() {
		return transactionStatusCode;
	}

	public void setTransactionStatusCode(String transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getMemoBalance() {
		return memoBalance;
	}

	public void setMemoBalance(String memoBalance) {
		this.memoBalance = memoBalance;
	}

	public String getFloatAmount() {
		return floatAmount;
	}

	public void setFloatAmount(String floatAmount) {
		this.floatAmount = floatAmount;
	}

	public String getBalanceOnHold() {
		return balanceOnHold;
	}

	public void setBalanceOnHold(String balanceOnHold) {
		this.balanceOnHold = balanceOnHold;
	}

	public String getPleadgeAmount() {
		return pleadgeAmount;
	}

	public void setPleadgeAmount(String pleadgeAmount) {
		this.pleadgeAmount = pleadgeAmount;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getCustomerShortName() {
		return customerShortName;
	}

	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	}

	public String getUserReferenceNumber() {
		return userReferenceNumber;
	}

	public void setUserReferenceNumber(String userReferenceNumber) {
		this.userReferenceNumber = userReferenceNumber;
	}

}
