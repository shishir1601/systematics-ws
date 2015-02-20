package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "AccountDetailsMessageTDResponse")
public class AccountDetailsMessageTDResponse extends InteractionBase {

	private String transactionStatusCode;
	private String currencyCode;
	private String branchCode;
	private String accountId;
	private String accountStatus;
	private String customerShortName;
	private String currentBalance;
	private String depositTerm;
	private String interestRate;
	private String accruedInterest;
	private String dateOpened;
	private String userReferenceNumber;
	private String productCode;
	private String errorCode;
	private String replyText;
	private String messageCode;
	private String messageText;
	private String employeeAccount;
	private String jointAccount;
	
	public String getEmployeeAccount() {
		return employeeAccount;
	}
	public void setEmployeeAccount(String employeeAccount) {
		this.employeeAccount = employeeAccount;
	}
	public String getJointAccount() {
		return jointAccount;
	}
	public void setJointAccount(String jointAccount) {
		this.jointAccount = jointAccount;
	}
	
		public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	
	public String getTransactionStatusCode() {
		return transactionStatusCode;
	}
	public void setTransactionStatusCode(String transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}
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
	public String getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getDepositTerm() {
		return depositTerm;
	}
	public void setDepositTerm(String depositTerm) {
		this.depositTerm = depositTerm;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getAccruedInterest() {
		return accruedInterest;
	}
	public void setAccruedInterest(String accruedInterest) {
		this.accruedInterest = accruedInterest;
	}
	public String getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
	public String getUserReferenceNumber() {
		return userReferenceNumber;
	}
	public void setUserReferenceNumber(String userReferenceNumber) {
		this.userReferenceNumber = userReferenceNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	
}

