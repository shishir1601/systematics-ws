package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TransactionHistoryRequestList")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionHistoryResponseList {

	@XmlElement(name = "recordSequence", required = true)
	private String recordSequence;

	@XmlElement(name = "postingDate", required = true)
	private String postingDate;
	
	@XmlElement(name = "transAmount", required = true)
	private String transAmount;
	
	@XmlElement(name = "debitCreditFlag", required = true)
	private String debitCreditFlag;
	
	@XmlElement(name = "checkNumber", required = true)
	private String checkNumber;
	
	@XmlElement(name = "transactionDecs", required = true)
	private String transactionDecs;
	
	@XmlElement(name = "runningTotal", required = true)
	private String runningTotal;
	
	public String getRecordSequence() {
		return recordSequence;
	}

	public void setRecordSequence(String recordSequence) {
		this.recordSequence = recordSequence;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
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

	public String getTransactionDecs() {
		return transactionDecs;
	}

	public void setTransactionDecs(String transactionDecs) {
		this.transactionDecs = transactionDecs;
	}

	public String getRunningTotal() {
		return runningTotal;
	}

	public void setRunningTotal(String runningTotal) {
		this.runningTotal = runningTotal;
	}

	
}
