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

}