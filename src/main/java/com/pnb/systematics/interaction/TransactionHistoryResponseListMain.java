package com.pnb.systematics.interaction;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "TransactionHistoryRequestListMain")
@XmlAccessorType(XmlAccessType.FIELD)

public class TransactionHistoryResponseListMain {
	
@XmlElement(name = "main", required = true)	
private TransactionHistoryResponseList main;

public TransactionHistoryResponseList getMain() {
	return main;
}

public void setMain(TransactionHistoryResponseList main) {
	this.main = main;
}


}
