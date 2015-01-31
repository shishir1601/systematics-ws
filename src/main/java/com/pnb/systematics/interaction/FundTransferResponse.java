package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FundTransferResponse")
public class FundTransferResponse extends InteractionBase {
	
	private String transactionStatusCode;
	private String errorCode;
	private String replyText;
	private String userReferenceNumber;

	public String getTransactionStatusCode() {
		return transactionStatusCode;
	}
	public void setTransactionStatusCode(String transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
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
	public String getUserReferenceNumber() {
		return userReferenceNumber;
	}
	public void setUserReferenceNumber(String userReferenceNumber) {
		this.userReferenceNumber = userReferenceNumber;
	}
	
	
	
	

}
