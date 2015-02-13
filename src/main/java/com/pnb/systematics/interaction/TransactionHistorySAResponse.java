package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TransactionHistorySAResponse")
public class TransactionHistorySAResponse extends InteractionBase {

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
	private String listRecSeq;
	private String listPostingDate;
	private String listAmountInAccountCurrency;
	private String listAmountInLocalCurrency;
	private String listAmountInTransactionCurrency;
	private String listTransactionAmount;
	private String listCreditDebitFlag;
	private String listChequeNumber;
	private String listTxDesc;
	private String listRunningTotal;
	private String errorCode;
	private String replyText;
	
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
	public String getListRecSeq() {
		return listRecSeq;
	}
	public void setListRecSeq(String listRecSeq) {
		this.listRecSeq = listRecSeq;
	}
	public String getListPostingDate() {
		return listPostingDate;
	}
	public void setListPostingDate(String listPostingDate) {
		this.listPostingDate = listPostingDate;
	}
	public String getListAmountInAccountCurrency() {
		return listAmountInAccountCurrency;
	}
	public void setListAmountInAccountCurrency(String listAmountInAccountCurrency) {
		this.listAmountInAccountCurrency = listAmountInAccountCurrency;
	}
	public String getListAmountInLocalCurrency() {
		return listAmountInLocalCurrency;
	}
	public void setListAmountInLocalCurrency(String listAmountInLocalCurrency) {
		this.listAmountInLocalCurrency = listAmountInLocalCurrency;
	}
	public String getListAmountInTransactionCurrency() {
		return listAmountInTransactionCurrency;
	}
	public void setListAmountInTransactionCurrency(
			String listAmountInTransactionCurrency) {
		this.listAmountInTransactionCurrency = listAmountInTransactionCurrency;
	}
	public String getListTransactionAmount() {
		return listTransactionAmount;
	}
	public void setListTransactionAmount(String listTransactionAmount) {
		this.listTransactionAmount = listTransactionAmount;
	}
	public String getListCreditDebitFlag() {
		return listCreditDebitFlag;
	}
	public void setListCreditDebitFlag(String listCreditDebitFlag) {
		this.listCreditDebitFlag = listCreditDebitFlag;
	}
	public String getListChequeNumber() {
		return listChequeNumber;
	}
	public void setListChequeNumber(String listChequeNumber) {
		this.listChequeNumber = listChequeNumber;
	}
	public String getListTxDesc() {
		return listTxDesc;
	}
	public void setListTxDesc(String listTxDesc) {
		this.listTxDesc = listTxDesc;
	}
	public String getListRunningTotal() {
		return listRunningTotal;
	}
	public void setListRunningTotal(String listRunningTotal) {
		this.listRunningTotal = listRunningTotal;
	}
		
}

