package com.pnb.systematics.interaction;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ServiceChargeResponse")
public class ServiceChargeResponse extends InteractionBase {
	
	private String transactionStatusCode;
	private String accountId;
	private String messageCode;
	private String messageText;
	private String userReferenceNumber;
	
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
	public String getUserReferenceNumber() {
		return userReferenceNumber;
	}
	public void setUserReferenceNumber(String userReferenceNumber) {
		this.userReferenceNumber = userReferenceNumber;
	}
	
	
	

}

