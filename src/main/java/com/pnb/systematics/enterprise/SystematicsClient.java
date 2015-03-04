package com.pnb.systematics.enterprise;

import org.apache.log4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.jagacy.util.JagacyException;
import com.pnb.systematics.configuration.DateUtil;
import com.pnb.systematics.schema.GetFromTTIB2InputProperties;
import com.pnb.systematics.schema.GetFromTTIB2ProcessWS;
import com.pnb.systematics.schema.GetFromTTIB2ProcessWSResponse;

public class SystematicsClient extends WebServiceGatewaySupport{
	
	private static Logger logger = Logger.getLogger(SystematicsClient.class);
	
	public GetFromTTIB2ProcessWSResponse getTTIBResponseSA(String accountNumber, String currencyCode, String branchCode ){
		GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
		GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String code = "0100";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); 
		String a5 = "A5" + accountNumber;
		String a3 = "A3" + branchCode;
		String a4 = "A4000";
		String a2 = "A2" + currencyCode;
		String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";"+ a3 + ";" + a4 + ";" + a5+ ";ab0;ah1;";
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
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time	
		String a5 = "A5" + accountNumber;
		String a3 = "A3" + branchCode;
		String a4 = "A40000";
		String a2 = "A2" + currencyCode;
		String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";"+ a3 + ";" + a4 + ";" + a5+ ";ab0;ah1;";
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
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + branchCode;
	    String a5 = "A5" + accountId;
	    String a7 = "A7" + transactionAmount;
	    String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + a5 + ";" + a7 + ";ab0;ah1;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	
	public GetFromTTIB2ProcessWSResponse getTTIBDebitMemoIm(String currencyCode, String branchCode, String accountId, String transactionAmount){
	    GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
	    String code = "1660";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + branchCode;
	    String a5 = "A5" + accountId;
	    String a7 = "A7" + transactionAmount;
	    String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + a5 + ";" + a7 + ";ab0;ah1;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	
	public GetFromTTIB2ProcessWSResponse getTTIBDebitMemoSt(String currencyCode, String branchCode, String accountId, String transactionAmount){
	    GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
	    String code = "0660";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + branchCode;
	    String a5 = "A5" + accountId;
	    String a7 = "A7" + transactionAmount;
	    String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + a5 + ";" + a7 + ";ab0;ah0;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
    
	public GetFromTTIB2ProcessWSResponse getTTIBFundTransferSAtoCA(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount){
	    GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
	    String code = "0564";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "ao" + toBranchCode;
	    String af = "af" + toAccountId;
	    String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ";" + ao + ";" + af + ";AN1;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	
	public GetFromTTIB2ProcessWSResponse getTTIBFundTransferCAtoSA(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount){
	    GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
	    String code = "1564";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "ao" + toBranchCode;
	    String af = "af" + toAccountId;
	    String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ";" + ao + ";" + af + ";AN0;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	
	public GetFromTTIB2ProcessWSResponse getTTIBFundTransferSAtoSA(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount){
	    GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
	    String code = "0564";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "AO" + toBranchCode;
	    String af = "AF" + toAccountId;
	    String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ";" + ao + ";" + af + ";AN0;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	
	public GetFromTTIB2ProcessWSResponse getTTIBFundTransferCAtoCA(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount){
	    GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
	    String code = "1564";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "AO" + toBranchCode;
	    String af = "AF" + toAccountId;
	    String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ";" + ao + ";" + af + ";AN1;";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	
	public GetFromTTIB2ProcessWSResponse getTTIBBillsPaymentSA(String currencyCode, String branchCode, String accountId,String merchantID, String subscriberNumber, String billNo,String payeeName, String transactionAmount) {
		GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
		String code = "0974";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
		String a2 = "A2" + currencyCode;
		String a3 = "A3" + branchCode;
		String a4 = "A4000";
		String a5 = "A5"+ accountId;
		String aj = "AJ" + merchantID;
		String ak = "AK" + subscriberNumber;
		String ap = "AP" + billNo;
		String al = "AL" + payeeName;
		String a7 = "A7" + transactionAmount;
		String ai = "AI0005"; //sequence number
		
		String an = "AN" + a5.charAt(5);
		
		String message = code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + a4 + ";" + a5 + ";" + aj + ";" + ak + ";" + ap + ";" +al + ";" + a7 + ";" + ai + ";" + an + ";";
	    logger.debug("TTIB Message: "+ message);
	    prop.setInputString(message);
		ttib.setInputFromClient(prop);
		GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		return response;
	}
	
	public String getTTIBAccountLoanTD(String currencyCode, String branchCode, String accountId) throws JagacyException{
		String response = "";
		String code = "WSP4";
		String transId = "    ";
		String seqNum = "001";
		String currCode = currencyCode;
		String branCode = branchCode;
		String accntId = accountId;
		String message = code + transId + seqNum + currCode + branCode + accntId;
		logger.debug(message);
	    CustomCommand conn = new CustomCommand();
	    conn.open();
	    response = conn.submitCommand(message);
	    conn.close();
		return response;
	}
	
	public String getTTIBAccountLoanSA(String currencyCode, String branchCode, String accountId) throws JagacyException{
		String response = "";
		String code = "WSP5";
		String transId = "    ";
		String seqNum = "001";
		String currCode = currencyCode;
		String branCode = branchCode;
		String accntId = accountId;
		String message = code + transId + seqNum + currCode + branCode + accntId;
		logger.debug(message);
	    CustomCommand conn = new CustomCommand();
	    conn.open();
	    response = conn.submitCommand(message);
	    conn.close();
		return response;
	}
	
	public String getTTIBAccountLoanCA(String currencyCode, String branchCode, String accountId) throws JagacyException{
		String response = "";
		String code = "WSP3";
		String transId = "    ";
		String seqNum = "001";
		String currCode = currencyCode;
		String branCode = branchCode;
		String accntId = accountId;
		String message = code + transId + seqNum + currCode + branCode + accntId;
		logger.debug(message);
	    CustomCommand conn = new CustomCommand();
	    conn.open();
	    response = conn.submitCommand(message);
	    conn.close();
		return response;
	}
	
	public String getTransactionHistorySA(String currencyCode, String branchCode, String accountId, String startDate, String endDate, String nextRecordNumber, String lastKeyUsed)  throws JagacyException{
		//System.out.println(nextRecordNumber);
		String response = "";
		String code = "WSP2";
		String transId = "    ";
		String seqNum = "001";
		String currCode = currencyCode;
		String branCode = branchCode;
		String accntId = accountId;
		String strDate = startDate;
		String eDate = endDate;
		String message = code + transId + seqNum + currCode + branCode + accntId + nextRecordNumber+strDate+eDate +"**"+lastKeyUsed+"**";
		
		logger.debug(message);
	    CustomCommand conn = new CustomCommand();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		return response;
	}
	
	public String getTransactionHistoryCA(String currencyCode, String branchCode, String accountId, String startDate, String endDate, String nextRecordNumber, String lastKeyUsed) throws JagacyException{
		System.out.println(nextRecordNumber);
		String response = "";
		String code = "WSP1";
		String transId = "    ";
		String seqNum = "001";
		String currCode = currencyCode;
		String branCode = branchCode;
		String accntId = accountId;
		String strDate = startDate;
		String eDate = endDate;
		String message = code + transId + seqNum + currCode + branCode + accntId + nextRecordNumber+strDate+eDate +"**"+lastKeyUsed+"**";
		
		logger.debug(message);
	    CustomCommand conn = new CustomCommand();
	    System.out.println("Open");
	    conn.open();
	    response = conn.submitCommand(message);
	    System.out.println("Close");
	    conn.close();
		return response;
	}

	
	/*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	public String getTTIBResponseSAJagacy(String accountNumber, String currencyCode, String branchCode )throws JagacyException{
		//GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	//	GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String response = "";
		String transId = "TTIB   ";
		String code = "0100";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); 
		String a5 = "A5" + accountNumber;
		String a3 = "A3" + branchCode;
		String a4 = "A4000";
		String a2 = "A2" + currencyCode;
		String message =transId + code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";"+ a3 + ";" + a4 + ";" + a5+ ";ab0;ah0;";
		logger.debug("TTIB getTTIBResponseSAJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
	    CustomCommandTTIB conn = new CustomCommandTTIB();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}	
	

	public String getTTIBResponseCAJagacy(String accountNumber,String currencyCode, String branchCode)throws JagacyException{
		//GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
		//GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String response = "";
		String transId = "TTIB   ";
		String code = "1100";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time	
		String a5 = "A5" + accountNumber;
		String a3 = "A3" + branchCode;
		String a4 = "A40000";
		String a2 = "A2" + currencyCode;
		String message = transId + code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";"+ a3 + ";" + a4 + ";" + a5+ ";ab0;ah1;";
		logger.debug("TTIB getTTIBResponseCAJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		CustomCommandTTIB conn = new CustomCommandTTIB();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}
	
	public String getTTIBServiceChargeJagacy(String currencyCode, String branchCode, String accountId, String transactionAmount)throws JagacyException{
	    //GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    //GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String response = "";
		String transId = "TTIB   ";
	    String code = "1542";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + branchCode;
	    String a5 = "A5" + accountId;
	    String a7 = "A7" + transactionAmount;
	    String message =transId +  code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + a5 + ";" + a7 + ";ab0;ah1;";
		logger.debug("TTIB getTTIBServiceChargeJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		CustomCommandTTIB conn = new CustomCommandTTIB();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}
	
	public String getTTIBDebitMemoImJagacy(String currencyCode, String branchCode, String accountId, String transactionAmount)throws JagacyException{
	    //GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    //GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String response = "";
		String transId = "TTIB   ";
	    String code = "1660";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + branchCode;
	    String a5 = "A5" + accountId;
	    String a7 = "A7" + transactionAmount;
	    String message = transId + code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + a5 + ";" + a7 + ";ab0;ah1;";
		logger.debug("TTIB getTTIBDebitMemoImJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		CustomCommandTTIB conn = new CustomCommandTTIB();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}
	
	public String getTTIBDebitMemoStJagacy(String currencyCode, String branchCode, String accountId, String transactionAmount)throws JagacyException{
	    //GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    //GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String response = "";
		String transId = "TTIB   ";
	    	String code = "0660";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + branchCode;
	    String a5 = "A5" + accountId;
	    String a7 = "A7" + transactionAmount;
	    String message = transId + code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + a5 + ";" + a7 + ";ab0;ah0;";
		logger.debug("TTIB getTTIBDebitMemoStJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		CustomCommandTTIB conn = new CustomCommandTTIB();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}
    
	public String getTTIBFundTransferSAtoCAJagacy(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount)throws JagacyException{
	    //GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    //GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String response = "";
		String transId = "TTIB   ";
	    String code = "0564";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "ao" + toBranchCode;
	    String af = "af" + toAccountId;
	    String message = transId + code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ";" + ao + ";" + af + ";AN1;";
		logger.debug("TTIB getTTIBFundTransferSAtoCAJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		CustomCommandFundTransfer conn = new CustomCommandFundTransfer();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}
	
	public String getTTIBFundTransferCAtoSAJagacy(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount)throws JagacyException{
	    //GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    //GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String response = "";
		String transId = "TTIB   ";
	    String code = "1564";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "ao" + toBranchCode;
	    String af = "af" + toAccountId;
	    String message = transId + code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ";" + ao + ";" + af + ";AN0;";
		logger.debug("TTIB getTTIBFundTransferCAtoSAJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		CustomCommandFundTransfer conn = new CustomCommandFundTransfer();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}
	
	public String getTTIBFundTransferSAtoSAJagacy(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount)throws JagacyException{
	    //GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    //GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String response = "";
		String transId = "TTIB   ";
	    String code = "0564";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "AO" + toBranchCode;
	    String af = "AF" + toAccountId;
	    String message =transId +  code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ";" + ao + ";" + af + ";AN0;";
		logger.debug("TTIB getTTIBFundTransferSAtoSAJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		CustomCommandFundTransfer conn = new CustomCommandFundTransfer();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}
	
	public String getTTIBFundTransferCAtoCAJagacy(String currencyCode, String fromAccountId, String fromBranchCode, String toAccountId, String toBranchCode, String transactionAmount)throws JagacyException{
	    //GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
	    //GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		String response = "";
		String transId = "TTIB   ";
	    String code = "1564";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
	    String a2 = "A2" + currencyCode;
	    String a3 = "A3" + fromBranchCode;
	    String a5 = "A5" + fromAccountId;
	    String a7 = "A7" + transactionAmount;
	    String ao = "AO" + toBranchCode;
	    String af = "AF" + toAccountId;
	    String message =transId +  code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + "A4000" + ";" + a5 + ";" + a7 + ";" + ao + ";" + af + ";AN1;";
		logger.debug("TTIB getTTIBFundTransferCAtoCAJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		CustomCommandFundTransfer conn = new CustomCommandFundTransfer();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}
	
	public String getTTIBBillsPaymentSAJagacy(String currencyCode, String branchCode, String accountId,String merchantID, String subscriberNumber, String billNo,String payeeName, String transactionAmount) throws JagacyException{
		//GetFromTTIB2InputProperties prop = new GetFromTTIB2InputProperties();
		//GetFromTTIB2ProcessWS ttib = new GetFromTTIB2ProcessWS();
		String response = "";
		String transId = "TTIB   ";
		String code = "0974";
		String tellerId = "997A";
        String overrideTellerId = "0000";
        String tranSeqNum = "000"; //temporary: transaction sequence number
        String statusByte = "000"; //temporary: status byte
        String tranTime = DateUtil.getCurrentHour() + DateUtil.getCurrentMinutes() + DateUtil.getCurrentSecond(); //temporary: transaction time
		String a2 = "A2" + currencyCode;
		String a3 = "A3" + branchCode;
		String a4 = "A4000";
		String a5 = "A5"+ accountId;
		String aj = "AJ" + merchantID;
		String ak = "AK" + subscriberNumber;
		String ap = "AP" + billNo;
		String al = "AL" + payeeName;
		String a7 = "A7" + transactionAmount;
		String ai = "AI0005"; //sequence number
		
		String an = "AN" + a5.charAt(5);
		
		String message =transId +  code + tellerId + overrideTellerId + tranSeqNum + statusByte + tranTime + ";" + a2 + ";" + a3 + ";" + a4 + ";" + a5 + ";" + aj + ";" + ak + ";" + ap + ";" +al + ";" + a7 + ";" + ai + ";" + an + ";";
		logger.debug("TTIB getTTIBBillsPaymentSAJagacy message: " +  message);
		//prop.setInputString(message);
		//ttib.setInputFromClient(prop);
		//GetFromTTIB2ProcessWSResponse response = (GetFromTTIB2ProcessWSResponse) getWebServiceTemplate().marshalSendAndReceive(ttib, new SoapActionCallback("http://10.1.101.79:9080/AAFWebService/services/AAFWebService"));
		CustomCommandTTIB conn = new CustomCommandTTIB();
	    conn.open();
	    
	    response = conn.submitCommand(message);
	    conn.close();
		
		return response;
	}
	

	
	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
}
