package com.pnb.systematics.enterprise.bo.impl;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jagacy.util.JagacyException;
import com.pnb.systematics.configuration.WebServiceUtil;
import com.pnb.systematics.enterprise.SystematicsClient;
import com.pnb.systematics.enterprise.SystematicsUtil;
import com.pnb.systematics.enterprise.bo.SystematicsBusinessObject;
import com.pnb.systematics.interaction.AccountDetailsInqLoanRequest;
import com.pnb.systematics.interaction.AccountDetailsInqLoanResponse;
import com.pnb.systematics.interaction.AccountDetailsMessageIMRequest;
import com.pnb.systematics.interaction.AccountDetailsMessageIMResponse;
import com.pnb.systematics.interaction.AccountDetailsMessageSTRequest;
import com.pnb.systematics.interaction.AccountDetailsMessageSTResponse;
import com.pnb.systematics.interaction.AccountDetailsMessageTDRequest;
import com.pnb.systematics.interaction.AccountDetailsMessageTDResponse;
import com.pnb.systematics.interaction.BalanceInquiryRequest;
import com.pnb.systematics.interaction.BalanceInquiryResponse;
import com.pnb.systematics.interaction.BillsPaymentRequest;
import com.pnb.systematics.interaction.BillsPaymentResponse;
import com.pnb.systematics.interaction.DebitMemoImRequest;
import com.pnb.systematics.interaction.DebitMemoImResponse;
import com.pnb.systematics.interaction.DebitMemoStRequest;
import com.pnb.systematics.interaction.DebitMemoStResponse;
import com.pnb.systematics.interaction.FundTransferRequest;
import com.pnb.systematics.interaction.FundTransferResponse;
import com.pnb.systematics.interaction.ServiceChargeRequest;
import com.pnb.systematics.interaction.ServiceChargeResponse;
import com.pnb.systematics.interaction.TransactionHistoryCARequest;
import com.pnb.systematics.interaction.TransactionHistoryCAResponse;
import com.pnb.systematics.interaction.TransactionHistorySARequest;
import com.pnb.systematics.interaction.TransactionHistorySAResponse;
import com.pnb.systematics.schema.GetFromTTIB2OutputProperties;
import com.pnb.systematics.schema.GetFromTTIB2ProcessWSResponse;
import com.teligent.crawler.LoanAccountInquiryCommand;

@Component
public class SystematicsBusinessObjectImpl implements SystematicsBusinessObject{	

	private static final SystematicsClient client = WebServiceUtil.systematicsClient();
	private static Logger logger = Logger.getLogger(SystematicsBusinessObjectImpl.class);
	
	public BalanceInquiryResponse balanceInquirySA(BalanceInquiryRequest request) {
		BalanceInquiryResponse response = new BalanceInquiryResponse();
		/*Sending the request*/
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBResponseSA(request.getAccountId(),request.getCurrencyCode(), request.getBranchCode());
		/*Getting the result*/
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			response.setTransactionStatusCode("99");
			response.setErrorCode("TS0304");
			response.setReplyText("ACCOUNT NOT FOUND");
			logger.debug("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			logger.debug("TTIB return message" + returnMessage);
			response.setAccountId(request.getAccountId());
			response.setUserReferenceNumber(request.getUserReferenceNumber());
			response.setBalanceOnHold(SystematicsUtil.getRealBalance(SystematicsUtil.getWebServiceObject(returnMessage,"HOLD  AMT", 25)));
			response.setPleadgeAmount(SystematicsUtil.getRealBalance(SystematicsUtil.getWebServiceObject(returnMessage, "PLDGE AMT", 25)));
			response.setAccountStatus(SystematicsUtil.getWebServiceObject(returnMessage, "STATUS", 25));
			response.setCustomerShortName(returnMessage.substring(357,373));
			response.setTransactionStatusCode("00");
			response.setMemoBalance(SystematicsUtil.getRealBalance(SystematicsUtil.getWebServiceObject(returnMessage,"MEMO  BAL", 25)));
			response.setFloatAmount(SystematicsUtil.getRealBalance(SystematicsUtil.getWebServiceObject(returnMessage, "FLOAT AMT", 25)));
		}
		return response;
	}
	
	public BalanceInquiryResponse balanceInquiryCA(BalanceInquiryRequest request){
		BalanceInquiryResponse response = new BalanceInquiryResponse();              
		/*Sending the request*/
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBResponseCA(request.getAccountId(), request.getCurrencyCode(), request.getBranchCode());
		/*Getting the result*/
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			response.setTransactionStatusCode("99");
			response.setErrorCode("TS0304");
			response.setReplyText("ACCOUNT NOT FOUND");
		}else{
			String returnMessage = prop.getReturnMessage();
			logger.debug("TTIB return message: " + returnMessage);
			response.setAccountId(request.getAccountId());
			response.setUserReferenceNumber(request.getUserReferenceNumber());
			response.setAvailableBalance(SystematicsUtil.getRealBalance(SystematicsUtil.getWebServiceObject(returnMessage, "AVAIL BAL", 29)));
			response.setUnavailableBalance(SystematicsUtil.getRealBalance(SystematicsUtil.getWebServiceObject(returnMessage, "UNAVAIL    AMT", 24)));
			response.setAccountStatus(SystematicsUtil.getWebServiceObject(returnMessage, "ACCT STATUS", 24));
			response.setCustomerShortName(SystematicsUtil.getWebServiceObject(returnMessage, "ACCT NAME", 21));
			response.setTransactionStatusCode("00");
		}
		return response;
	}


	public ServiceChargeResponse debitCa(ServiceChargeRequest request) {
		ServiceChargeResponse response = new ServiceChargeResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBServiceCharge(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			logger.debug("Error Response: " + errorResponse);
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.debug("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			String errorMessage = SystematicsUtil.checkForError(returnMessage);
			if(errorMessage.trim().length() == 0){
				response.setTransactionStatusCode("00");
				response.setMessageCode("I");
				response.setMessageText("PROCESS COMPLETE");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
			}else{
				logger.debug("TTIB Response: " + returnMessage);
				String[] errorResponse = errorMessage.split("\\|");
				response.setErrorCode(errorResponse[1]);
				response.setReplyText(errorResponse[0]);
				logger.debug("Error in return: " + prop.getErrorMessage());
			}
		}
		return response;
	}
	
	public DebitMemoImResponse debitMemoIm(DebitMemoImRequest request) {
		DebitMemoImResponse response = new DebitMemoImResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBDebitMemoIm(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.debug("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			String errorMessage = SystematicsUtil.checkForError(returnMessage);
			logger.debug("TTIB response: " + returnMessage);
			if(errorMessage.trim().length() == 0){
				response.setTransactionStatusCode("00");
				response.setMessageCode("I");
				response.setMessageText("PROCESS COMPLETE");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
			}else{
				String[] errorResponse = errorMessage.split("\\|");
				response.setErrorCode(errorResponse[1]);
				response.setReplyText(errorResponse[0]);
				logger.debug("Error in return: " + prop.getErrorMessage());
			}
		}
		return response;
	}
	
	public DebitMemoStResponse debitMemoSt(DebitMemoStRequest request) {
		DebitMemoStResponse response = new DebitMemoStResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBDebitMemoSt(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.debug("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			String errorMessage = SystematicsUtil.checkForError(returnMessage);
			logger.debug("TTIB response: " + returnMessage);
			if(errorMessage.trim().length() == 0){
				response.setTransactionStatusCode("00");
				response.setMessageCode("I");
				response.setMessageText("PROCESS COMPLETE");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
			}else{
				String[] errorResponse = errorMessage.split("\\|");
				response.setErrorCode(errorResponse[1]);
				response.setReplyText(errorResponse[0]);
				logger.debug("Error in return: " + prop.getErrorMessage());
			}
		}
		return response;
	}

	public FundTransferResponse fundTrSAtoCA(FundTransferRequest request) {
		FundTransferResponse response = new FundTransferResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferSAtoCA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.debug("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			String errorMessage = SystematicsUtil.checkForError(returnMessage);
			logger.debug("TTIB response: " + returnMessage);
			if(errorMessage.trim().length() == 0){
				response.setTransactionStatusCode("00");
				response.setMessageCode("I");
				response.setMessageText("PROCESS COMPLETE");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
			}else{
				String[] errorResponse = errorMessage.split("\\|");
				response.setErrorCode(errorResponse[1]);
				response.setReplyText(errorResponse[0]);
				logger.debug("Error in return: " + prop.getErrorMessage());
			}
		}
		return response;
	}

	public FundTransferResponse fundTrCAtoSA(FundTransferRequest request) {
	   	FundTransferResponse response = new FundTransferResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferCAtoSA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.debug("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			String errorMessage = SystematicsUtil.checkForError(returnMessage);
			logger.debug("TTIB response: " + returnMessage);
			if(errorMessage.trim().length() == 0){
				response.setTransactionStatusCode("00");
				response.setMessageCode("I");
				response.setMessageText("PROCESS COMPLETE");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
			}else{
				String[] errorResponse = errorMessage.split("\\|");
				response.setErrorCode(errorResponse[1]);
				response.setReplyText(errorResponse[0]);
				logger.debug("Error in return: " + prop.getErrorMessage());
			}
		}
		return response;
	}
	
	public FundTransferResponse fundTrSAtoSA(FundTransferRequest request) {
	   	FundTransferResponse response = new FundTransferResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferSAtoSA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.debug("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			String errorMessage = SystematicsUtil.checkForError(returnMessage);
			logger.debug("TTIB response: " + returnMessage);
			if(errorMessage.trim().length() == 0){
				response.setTransactionStatusCode("00");
				response.setMessageCode("I");
				response.setMessageText("PROCESS COMPLETE");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
			}else{
				String[] errorResponse = errorMessage.split("\\|");
				response.setErrorCode(errorResponse[1]);
				response.setReplyText(errorResponse[0]);
				logger.debug("Error in return: " + prop.getErrorMessage());
			}
		}
		return response;

	}
	
	public FundTransferResponse fundTrCAtoCA(FundTransferRequest request) {
	   	FundTransferResponse response = new FundTransferResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferCAtoCA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.debug("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			String errorMessage = SystematicsUtil.checkForError(returnMessage);
			logger.debug("TTIB response: " + returnMessage);
			if(errorMessage.trim().length() == 0){
				response.setTransactionStatusCode("00");
				response.setMessageCode("I");
				response.setMessageText("PROCESS COMPLETE");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
			}else{
				String[] errorResponse = errorMessage.split("\\|");
				response.setErrorCode(errorResponse[1]);
				response.setReplyText(errorResponse[0]);
				logger.debug("Error in return: " + prop.getErrorMessage());
			}
		}
		return response;

	}
	
	public BillsPaymentResponse billPayfrSA(BillsPaymentRequest request) {
		BillsPaymentResponse response = new BillsPaymentResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBBillsPaymentSA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getMerchantID(), request.getSubscriberNumber(), request.getBillNo(), request.getPayeeName(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.debug("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			String errorMessage = SystematicsUtil.checkForError(returnMessage);
			logger.debug("TTIB response: " + returnMessage);
			if(errorMessage.trim().length() == 0){
				response.setTransactionStatusCode("00");
				response.setMessageCode("I");
				response.setMessageText("PROCESS COMPLETE");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
			}else{
				String[] errorResponse = errorMessage.split("\\|");
				response.setErrorCode(errorResponse[1]);
				response.setReplyText(errorResponse[0]);
				logger.debug("Error in return: " + prop.getErrorMessage());
			}
		}
		return response;
	}
	
	
	public AccountDetailsInqLoanResponse accountLoan(AccountDetailsInqLoanRequest request){
		AccountDetailsInqLoanResponse response = new AccountDetailsInqLoanResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			String returnValue = command.submitCommand(request.getAccountId());
			logger.debug(returnValue);
			if(returnValue == ""){
				response.setErrorCode("99");
				response.setReplyText("Error in connecting to mainframe. More INFO: ");
			}else if(returnValue.contains("F:")){
				response.setErrorCode("99");
				response.setReplyText("Account Not Found");
			}else{
				response.setTransactionStatusCode("00");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
				response.setProductType(returnValue.substring(547,560));
				response.setEffectiveDate(returnValue.substring(226,240));
				response.setCurrentRate(returnValue.substring(521,535));
				response.setCurrentTerm(returnValue.substring(947,960));
				response.setCurrentMaturityDate(returnValue.substring(925,935));
				response.setCurrentPrincipalBalance(returnValue.substring(814,828));
				response.setTotalOverdueAmount(returnValue.substring(1134,1148));
				response.setAccountStatus(returnValue.substring(297,320));
				response.setPastDueDate(returnValue.substring(1165,1175));
				response.setOriginalLoanAmt(returnValue.substring(495,508));
				response.setOriginalProceed(returnValue.substring(575,588));
				response.setCustomerShortName(returnValue.substring(1361,1417));
			}
			command.close();
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		
		return response;
	}
	public AccountDetailsMessageIMResponse accountMessageIM(AccountDetailsMessageIMRequest request){
		AccountDetailsMessageIMResponse response = new AccountDetailsMessageIMResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			String returnValue = client.getTTIBAccountLoanCA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId());
			logger.debug(returnValue);
			if(returnValue == ""){
				response.setErrorCode("99");
				response.setReplyText("Error in connecting to mainframe");
			}else if(returnValue.contains("ERROR READING")){
				response.setErrorCode("99");
				response.setReplyText(returnValue.substring(7, 35));
			}else{
				response.setTransactionStatusCode(returnValue.substring(5,7));
				response.setCurrencyCode(returnValue.substring(6,9));
				response.setBranchCode(returnValue.substring(9,12));
				response.setAccountId(returnValue.substring(12,22));
				response.setAccountStatus(returnValue.substring(22,24));
				response.setCustomerShortName(returnValue.substring(24,37));
				response.setCurrentBalance(returnValue.substring(37,60));
				response.setDepositTerm(returnValue.substring(60,67)); //length: 4? temporary
				response.setInterestRate(returnValue.substring(67,77));//length: 10? temporary
				response.setAccruedInterest(returnValue.substring(77,100)); //length: 23? temporary
				response.setDateOpened(returnValue.substring(100,108));
				response.setProductCode(returnValue.substring(108,111));
				response.setEmployeeAccount(returnValue.substring(111,112));
				response.setJointAccount(returnValue.substring(112,115));
			}
			command.close();
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		return response;
	}
	public AccountDetailsMessageSTResponse accountMessageST(AccountDetailsMessageSTRequest request){
		AccountDetailsMessageSTResponse response = new AccountDetailsMessageSTResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			String returnValue = client.getTTIBAccountLoanSA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId());
			logger.debug(returnValue);
			if(returnValue == ""){
				response.setErrorCode("99");
				response.setReplyText("Error in connecting to mainframe");
			}else if(returnValue.contains("ERROR READING")){
				response.setErrorCode("99");
				response.setReplyText(returnValue.substring(7, 35));
			}else{
				response.setTransactionStatusCode(returnValue.substring(5,7));
				response.setCurrencyCode(returnValue.substring(6,9));
				response.setBranchCode(returnValue.substring(9,12));
				response.setAccountId(returnValue.substring(12,22));
				response.setAccountStatus(returnValue.substring(22,24));
				response.setCustomerShortName(returnValue.substring(24,37));
				response.setCurrentBalance(returnValue.substring(37,60));
				response.setDepositTerm(returnValue.substring(60,67)); //length: 4? temporary
				response.setInterestRate(returnValue.substring(67,77));//length: 10? temporary
				response.setAccruedInterest(returnValue.substring(77,100)); //length: 23? temporary
				response.setDateOpened(returnValue.substring(100,108));
				response.setProductCode(returnValue.substring(108,111));
				response.setEmployeeAccount(returnValue.substring(111,112));
				response.setJointAccount(returnValue.substring(112,115));
			}
			command.close();
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		return response;
	}
	public AccountDetailsMessageTDResponse accountMessageTD(AccountDetailsMessageTDRequest request){
		AccountDetailsMessageTDResponse response = new AccountDetailsMessageTDResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			String returnValue = client.getTTIBAccountLoanTD(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId());
			logger.debug(returnValue);
			if(returnValue == ""){
				response.setErrorCode("99");
				response.setReplyText("Error in connecting to mainframe");
			}else if(returnValue.contains("ERROR READING")){
				response.setErrorCode("99");
				response.setReplyText(returnValue.substring(7, 35));
			}else{
				response.setTransactionStatusCode(returnValue.substring(5,7));
				response.setCurrencyCode(returnValue.substring(6,9));
				response.setBranchCode(returnValue.substring(9,12));
				response.setAccountId(returnValue.substring(12,22));
				response.setAccountStatus(returnValue.substring(22,24));
				response.setCustomerShortName(returnValue.substring(24,37));
				response.setCurrentBalance(returnValue.substring(37,60));
				response.setDepositTerm(returnValue.substring(60,67)); //length: 4? temporary
				response.setInterestRate(returnValue.substring(67,77));//length: 10? temporary
				response.setAccruedInterest(returnValue.substring(77,100)); //length: 23? temporary
				response.setDateOpened(returnValue.substring(100,108));
				response.setProductCode(returnValue.substring(108,111));
				response.setEmployeeAccount(returnValue.substring(111,112));
				response.setJointAccount(returnValue.substring(112,115));
			}
			command.close();
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		return response;
	}
	
	public TransactionHistoryCAResponse transactionHistoryCA(TransactionHistoryCARequest request){
		return null;
	}
	
	public TransactionHistorySAResponse transactionHistorySA(TransactionHistorySARequest request){
		TransactionHistorySAResponse response = new TransactionHistorySAResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			String returnValue = client.getTransactionHistorySA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId());
			logger.debug(returnValue);
			if(returnValue == ""){
				response.setErrorCode("99");
				response.setReplyText("Error in connecting to mainframe");
			}else if(returnValue.contains("ERROR READING")){
				response.setErrorCode("99");
				response.setReplyText(returnValue.substring(7, 35));
			}else{
				/*response.setTransactionStatusCode(returnValue.substring(5,7));
				response.setCurrencyCode(returnValue.substring(6,9));
				response.setBranchCode(returnValue.substring(9,12));
				response.setAccountId(returnValue.substring(12,22));
				response.setAccountStatus(returnValue.substring(22,24));
				response.setCustomerShortName(returnValue.substring(24,37));
				response.setCurrentBalance(returnValue.substring(37,60));
				response.setDepositTerm(returnValue.substring(60,67)); //length: 4?
				response.setInterestRate(returnValue.substring(67,77));//length: 10?
				response.setAccruedInterest(returnValue.substring(77,100)); //length: 23?
				response.setDateOpened(returnValue.substring(100,108));
				response.setProductCode(returnValue.substring(108,111));
				response.setEmployeeAccount(returnValue.substring(111,112));
				response.setJointAccount(returnValue.substring(112,115));*/
			}
			command.close();
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		return response;
	}
}
