package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "AccountDetailsInqLoanResponse")
public class AccountDetailsInqLoanResponse extends InteractionBase{
	
	private String userReferenceNumber;
	private String productType;
	private String effectiveDate;
	private String currentRate;
	private String currentTerm;
	private String currentMaturityDate;
	private String currentPrincipalBalance;
	private String totalOVerdueAmount;
	private String accountStatus;
	private String acruedStatus;
	private String originalLoanAmt;
	private String originalProceed;
	private String customerShortName;
	private String transactionStatusCode;

	public String getTransactionStatusCode() {
		return transactionStatusCode;
	}
	public void setTransactionStatusCode(String transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}
	public String getUserReferenceNumber() {
		return userReferenceNumber;
	}
	public void setUserReferenceNumber(String userReferenceNumber) {
		this.userReferenceNumber = userReferenceNumber;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getCurrentRate() {
		return currentRate;
	}
	public void setCurrentRate(String currentRate) {
		this.currentRate = currentRate;
	}
	public String getCurrentTerm() {
		return currentTerm;
	}
	public void setCurrentTerm(String currentTerm) {
		this.currentTerm = currentTerm;
	}
	public String getCurrentMaturityDate() {
		return currentMaturityDate;
	}
	public void setCurrentMaturityDate(String currentMaturityDate) {
		this.currentMaturityDate = currentMaturityDate;
	}
	public String getCurrentPrincipalBalance() {
		return currentPrincipalBalance;
	}
	public void setCurrentPrincipalBalance(String currentPrincipalBalance) {
		this.currentPrincipalBalance = currentPrincipalBalance;
	}
	public String getTotalOVerdueAmount() {
		return totalOVerdueAmount;
	}
	public void setTotalOVerdueAmount(String totalOVerdueAmount) {
		this.totalOVerdueAmount = totalOVerdueAmount;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getAcruedStatus() {
		return acruedStatus;
	}
	public void setAcruedStatus(String acruedStatus) {
		this.acruedStatus = acruedStatus;
	}
	public String getOriginalLoanAmt() {
		return originalLoanAmt;
	}
	public void setOriginalLoanAmt(String originalLoanAmt) {
		this.originalLoanAmt = originalLoanAmt;
	}
	public String getOriginalProceed() {
		return originalProceed;
	}
	public void setOriginalProceed(String originalProceed) {
		this.originalProceed = originalProceed;
	}
	public String getCustomerShortName() {
		return customerShortName;
	}
	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	}
	
	
	
}
