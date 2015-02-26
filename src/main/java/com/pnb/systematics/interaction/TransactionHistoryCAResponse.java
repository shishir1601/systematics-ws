package com.pnb.systematics.interaction;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TransactionHistoryCAResponse")
public class TransactionHistoryCAResponse extends InteractionBase {

	private String transactionStatusCode;
	private String accountId;
	private String userReferenceNumber;
	private String branchCode;
	private String currencyCode;
	private String currentBalance;
	private String accountStatus;
	private String productCode;
	private String availableBalance;
	private String openingDate;
	private List<TransactionHistoryResponseList> response=new ArrayList<TransactionHistoryResponseList>();
	private String listRunningTotal;
	private String errorCode;
	private String replyText;
	private String startDate;
	private String endDate;
	private String numberOfRecords;
	private String recordSequence;
	private String postDate;
	private String transAmount;
	private String debitCreditFlag;
	private String checkNumber;
	private String transactionDesc;
	private String runningTotal;
	private String filler;
	private String lastKeyUsed;
	private String tranId;
	private String recordSequense;
	private String hasMoreRecord;
	
	public String getHasMoreRecord() {
		return hasMoreRecord;
	}

	public void setHasMoreRecord(String hasMoreRecord) {
		this.hasMoreRecord = hasMoreRecord;
	}

	public String getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(String numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	public String getRecordSequence() {
		return recordSequence;
	}

	public void setRecordSequence(String recordSequence) {
		this.recordSequence = recordSequence;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}

	public String getDebitCreditFlag() {
		return debitCreditFlag;
	}

	public void setDebitCreditFlag(String debitCreditFlag) {
		this.debitCreditFlag = debitCreditFlag;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	public String getRunningTotal() {
		return runningTotal;
	}

	public void setRunningTotal(String runningTotal) {
		this.runningTotal = runningTotal;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public String getLastKeyUsed() {
		return lastKeyUsed;
	}

	public void setLastKeyUsed(String lastKeyUsed) {
		this.lastKeyUsed = lastKeyUsed;
	}

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public String getRecordSequense() {
		return recordSequense;
	}

	public void setRecordSequense(String recordSequense) {
		this.recordSequense = recordSequense;
	}

	public void setResponse(List<TransactionHistoryResponseList> response) {
		this.response = response;
	}


	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getUserReferenceNumber() {
		return userReferenceNumber;
	}

	public void setUserReferenceNumber(String userReferenceNumber) {
		this.userReferenceNumber = userReferenceNumber;
	}

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

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getListRunningTotal() {
		return listRunningTotal;
	}

	public void setListRunningTotal(String listRunningTotal) {
		this.listRunningTotal = listRunningTotal;
	}

	public List<TransactionHistoryResponseList> getResponse() {
		return response;
	}

}
