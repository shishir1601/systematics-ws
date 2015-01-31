package com.pnb.systematics.enterprise;

import org.apache.log4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.pnb.systematics.schema.GetFromTTIB2InputProperties;
import com.pnb.systematics.schema.GetFromTTIB2ProcessWS;
import com.pnb.systematics.schema.GetFromTTIB2ProcessWSResponse;

public class SystematicsClient extends WebServiceGatewaySupport{
	
	private static Logger logger = Logger.getLogger(SystematicsClient.class);
	
	public GetFromTTIB2ProcessWSResponse getTTIBResponseSA(String accountNumber, String currencyCode, String branchCode ){
		GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
		GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String code = "0100";
		String tellerId = "SACT";
		String hoho = "00000000000";
		String a5 = "A5" + accountNumber;
		String a3 = "A3" + branchCode;
		String a4 = "A4000";
		String a2 = "A2" + currencyCode;
		String message = code + tellerId + hoho + ";" + a2 + ";"+ a3 + ";" + a4 + ";" + a5+ ";ab0;ah1;";
		logger.debug("TTIB message: " +  message);
		prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	

	public GetFromTTIB2ProcessWSResponse getTTIBResponseCA(String accountNumber,String currencyCode, String branchCode){
		GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
		GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String code = "1100";
		String tellerId = "SACT";
		String hoho = "00000000000";	
		String a5 = "A5" + accountNumber;
		String a3 = "A3" + branchCode;
		String a4 = "A40000";
		String a2 = "A2" + currencyCode;
		String message = code + tellerId + hoho + ";" + a2 + ";"+ a3 + ";" + a4 + ";" + a5+ ";ab0;ah1;";
		logger.debug("TTIB Message: "+ message);
		prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	
	public GetFromTTIB2ProcessWSResponse getTTIBServiceCharge(String currencyCode, String branchCode, String accountId, String transactionAmount){
	    GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
	    String code = "1542";
	    String tellerId = "SACT";
	    String hoho = "00000000000";
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + branchCode;
	    String a5 = "A5" + accountId;
	    String a7 = "A7" + transactionAmount;
	    String message = code + tellerId + hoho + ";" + a2 + ";" + a3 + ";" + a5 + ";" + a7 + ";ab0;ah1;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
    
	public GetFromTTIB2ProcessWSResponse getTTIBFundTransferSA(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount){
	    GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
	    String code = "0560";
	    String tellerId = "SACT";
	    String hoho = "00000000000";
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "ao" + toBranchCode;
	    String af = "af" + toAccountId;
	    String message = code + tellerId + hoho + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ao + ";" + af + ";an1;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	
	public GetFromTTIB2ProcessWSResponse getTTIBFundTransferCA(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount){
	    GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
	    String code = "1560";
	    String tellerId = "SACT";
	    String hoho = "00000000000";
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "ao" + toBranchCode;
	    String af = "af" + toAccountId;
	    String message = code + tellerId + hoho + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ao + ";" + af + ";an0;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}

}