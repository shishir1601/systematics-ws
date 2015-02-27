package com.pnb.systematics.enterprise.bo.impl;


import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.jagacy.Seconds;
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
import com.pnb.systematics.interaction.TransactionHistoryResponseList;
import com.pnb.systematics.interaction.TransactionHistoryResponseListMain;
import com.pnb.systematics.interaction.TransactionHistorySARequest;
import com.pnb.systematics.interaction.TransactionHistorySAResponse;
import com.pnb.systematics.schema.GetFromTTIB2OutputProperties;
import com.pnb.systematics.schema.GetFromTTIB2ProcessWSResponse;
import com.teligent.crawler.LoanAccountInquiryCommand;

@Component
public class SystematicsBusinessObjectImpl implements SystematicsBusinessObject{	

	private static final SystematicsClient client = WebServiceUtil.systematicsClient();
	private static Logger logger = Logger.getLogger(SystematicsBusinessObjectImpl.class);
	private String nullError;
	
	String nullField;
	
	public BalanceInquiryResponse balanceInquirySA(BalanceInquiryRequest request) {
		BalanceInquiryResponse response = new BalanceInquiryResponse();
		/*Sending the request*/
	
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBResponseSA(request.getAccountId(),request.getCurrencyCode(), request.getBranchCode());
		if(!request.getAccountId().equals("") && !request.getCurrencyCode().equals("") && !request.getBranchCode().equals("")){
			
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
		
		}else{
			nullError="";
			nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
			System.out.println(request.getAccountId());
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "BalanceInquiryResponse response");
		 }
		return response;
	}
	
	public BalanceInquiryResponse balanceInquiryCA(BalanceInquiryRequest request){
		BalanceInquiryResponse response = new BalanceInquiryResponse();              
		/*Sending the request*/
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBResponseCA(request.getAccountId(), request.getCurrencyCode(), request.getBranchCode());
		
		if(!request.getAccountId().equals("") && !request.getCurrencyCode().equals("") && !request.getBranchCode().equals("")){
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
		}else{
			nullError="";
			nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
			System.out.println(request.getAccountId());
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "BalanceInquiryResponse response");
		 }
		
		return response;
	}


	public ServiceChargeResponse debitCa(ServiceChargeRequest request) {
		ServiceChargeResponse response = new ServiceChargeResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBServiceCharge(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getTransactionAmount());
		if(!request.getCurrencyCode().equals("") && !request.getBranchCode().equals("") && !request.getAccountId().equals("") && !request.getTransactionAmount().equals("")){
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
		}else{
			nullError="";
			nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
			nullError=nullError + ((request.getTransactionAmount().equals("")) ? "Transaction Amount \t" : "");
			System.out.println(request.getAccountId());
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "ServiceChargeResponse response");
		 }
		return response;
	}
	
	public DebitMemoImResponse debitMemoIm(DebitMemoImRequest request) {
		DebitMemoImResponse response = new DebitMemoImResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBDebitMemoIm(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getTransactionAmount());
		if(!request.getCurrencyCode().equals("") && !request.getBranchCode().equals("") && !request.getAccountId().equals("") && !request.getTransactionAmount().equals("")){
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
		}else{
			nullError="";
			nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
			nullError=nullError + ((request.getTransactionAmount().equals("")) ? "Transaction Amount \t" : "");
			System.out.println(request.getAccountId());
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "DebitMemoImResponse response");
		 }
		return response;
	}
	
	public DebitMemoStResponse debitMemoSt(DebitMemoStRequest request) {
		DebitMemoStResponse response = new DebitMemoStResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBDebitMemoSt(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getTransactionAmount());
		if(!request.getCurrencyCode().equals("") && !request.getBranchCode().equals("") && !request.getAccountId().equals("") && !request.getTransactionAmount().equals("")){
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
		}else{
			nullError="";
			nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
			nullError=nullError + ((request.getTransactionAmount().equals("")) ? "Transaction Amount \t" : "");
			System.out.println(request.getAccountId());
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "DebitMemoStResponse response");
		 }
		return response;
	}

	public FundTransferResponse fundTrSAtoCA(FundTransferRequest request) {
		FundTransferResponse response = new FundTransferResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferSAtoCA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		if(!request.getCurrencyCode().equals("") && !request.getFromAccountId().equals("") && !request.getFromBranchCode().equals("") && !request.getToAccountId().equals("") && !request.getToBranchCode().equals("") && !request.getTransactionAmount().equals("")){
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
		}else{
			nullError="";
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getFromAccountId().equals("")) ? "From Account ID \t" : "");
			nullError=nullError + ((request.getFromBranchCode().equals("")) ? "From Branch Code \t" : "");
			nullError=nullError + ((request.getToAccountId().equals("")) ? "To Account ID \t" : "");
			nullError=nullError + ((request.getToBranchCode().equals("")) ? "To Branch Code \t" : "");
			nullError=nullError + ((request.getTransactionAmount().equals("")) ? "Transaction Amount \t" : "");
			
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "FundTransferResponse SAtoCA response");
		 }
		return response;
	}

	public FundTransferResponse fundTrCAtoSA(FundTransferRequest request) {
	   	FundTransferResponse response = new FundTransferResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferCAtoSA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		if(!request.getCurrencyCode().equals("") && !request.getFromAccountId().equals("") && !request.getFromBranchCode().equals("") && !request.getToAccountId().equals("") && !request.getToBranchCode().equals("") && !request.getTransactionAmount().equals("")){
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
		}else{
			nullError="";
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getFromAccountId().equals("")) ? "From Account ID \t" : "");
			nullError=nullError + ((request.getFromBranchCode().equals("")) ? "From Branch Code \t" : "");
			nullError=nullError + ((request.getToAccountId().equals("")) ? "To Account ID \t" : "");
			nullError=nullError + ((request.getToBranchCode().equals("")) ? "To Branch Code \t" : "");
			nullError=nullError + ((request.getTransactionAmount().equals("")) ? "Transaction Amount \t" : "");
			
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "FundTransferResponse CAtoSA response");
		 }
		return response;
	}
	
	public FundTransferResponse fundTrSAtoSA(FundTransferRequest request) {
	   	FundTransferResponse response = new FundTransferResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferSAtoSA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		if(!request.getCurrencyCode().equals("") && !request.getFromAccountId().equals("") && !request.getFromBranchCode().equals("") && !request.getToAccountId().equals("") && !request.getToBranchCode().equals("") && !request.getTransactionAmount().equals("")){
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
		}else{
			nullError="";
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getFromAccountId().equals("")) ? "From Account ID \t" : "");
			nullError=nullError + ((request.getFromBranchCode().equals("")) ? "From Branch Code \t" : "");
			nullError=nullError + ((request.getToAccountId().equals("")) ? "To Account ID \t" : "");
			nullError=nullError + ((request.getToBranchCode().equals("")) ? "To Branch Code \t" : "");
			nullError=nullError + ((request.getTransactionAmount().equals("")) ? "Transaction Amount \t" : "");
			
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "FundTransferResponse SAtoSA response");
		 }
		return response;

	}
	
	public FundTransferResponse fundTrCAtoCA(FundTransferRequest request) {
	   	FundTransferResponse response = new FundTransferResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferCAtoCA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		if(!request.getCurrencyCode().equals("") && !request.getFromAccountId().equals("") && !request.getFromBranchCode().equals("") && !request.getToAccountId().equals("") && !request.getToBranchCode().equals("") && !request.getTransactionAmount().equals("")){
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
		}else{
			nullError="";
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getFromAccountId().equals("")) ? "From Account ID \t" : "");
			nullError=nullError + ((request.getFromBranchCode().equals("")) ? "From Branch Code \t" : "");
			nullError=nullError + ((request.getToAccountId().equals("")) ? "To Account ID \t" : "");
			nullError=nullError + ((request.getToBranchCode().equals("")) ? "To Branch Code \t" : "");
			nullError=nullError + ((request.getTransactionAmount().equals("")) ? "Transaction Amount \t" : "");
			
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "FundTransferResponse CAtoCA response");
		 }
		return response;

	}
	
	public BillsPaymentResponse billPayfrSA(BillsPaymentRequest request) {
		BillsPaymentResponse response = new BillsPaymentResponse();
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBBillsPaymentSA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getMerchantID(), request.getSubscriberNumber(), request.getBillNo(), request.getPayeeName(), request.getTransactionAmount());
		if(!request.getCurrencyCode().equals("") && !request.getBranchCode().equals("") && !request.getAccountId().equals("") && !request.getMerchantID().equals("") && !request.getSubscriberNumber().equals("") && !request.getBillNo().equals("") && !request.getPayeeName().equals("") && !request.getTransactionAmount().equals("")){
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
		}else{
			nullError="";
			nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
			nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
			nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
			nullError=nullError + ((request.getMerchantID().equals("")) ? "Merchant ID \t" : "");
			nullError=nullError + ((request.getSubscriberNumber().equals("")) ? "Subscriber Number \t" : "");
			nullError=nullError + ((request.getBillNo().equals("")) ? "Bill Number \t" : "");
			nullError=nullError + ((request.getPayeeName().equals("")) ? "Payee Name \t" : "");
			nullError=nullError + ((request.getTransactionAmount().equals("")) ? "Transaction Amount \t" : "");
			response.setErrorCode("99");
			response.setReplyText("Required fields: " + nullError);
			logger.debug(response);
		}
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "BillsPaymentResponse response");
		 }
		
		return response;
	}
	

	public AccountDetailsInqLoanResponse accountLoan(AccountDetailsInqLoanRequest request){
		AccountDetailsInqLoanResponse response = new AccountDetailsInqLoanResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			if(!request.getCurrencyCode().equals("") && !request.getBranchCode().equals("") && !request.getAccountId().equals("") && !request.getUserReferenceNumber().equals("")){
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
			}else{
				nullError="";
				nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
				nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
				nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
				nullError=nullError + ((request.getUserReferenceNumber().equals("")) ? "Reference Number \t" : "");
				response.setErrorCode("99");
				response.setReplyText("Required fields: " + nullError);
				logger.debug(response);
			}
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "AccountDetailsInqLoanResponse response");
		 }
		return response;
	}
	public AccountDetailsMessageIMResponse accountMessageIM(AccountDetailsMessageIMRequest request){
		AccountDetailsMessageIMResponse response = new AccountDetailsMessageIMResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			if(!request.getCurrencyCode().equals("") && !request.getBranchCode().equals("") && !request.getAccountId().equals("") && !request.getUserReferenceNumber().equals("")){
				String returnValue = client.getTTIBAccountLoanCA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId());
				logger.debug(returnValue);
				if(returnValue == ""){
					response.setErrorCode("99");
					response.setReplyText("Error in connecting to mainframe");
				}else if(returnValue.contains("ERROR READING")){
					response.setErrorCode("99");
					response.setReplyText(returnValue.substring(6,35));
				}else{
					response.setTransactionStatusCode(returnValue.substring(5,7)); //length:2
					response.setCurrencyCode(returnValue.substring(6,9)); //length:3
					response.setBranchCode(returnValue.substring(9,12)); //length:3
					response.setAccountId(returnValue.substring(12,22)); //length:10
					response.setAccountStatus(returnValue.substring(22,24)); //length:2
					response.setCustomerShortName(returnValue.substring(24,37)); //length:13
					response.setCurrentBalance(returnValue.substring(37,60)); //length:23
					response.setDepositTerm(returnValue.substring(60,66)); //length:6
					response.setInterestRate(returnValue.substring(66,77));////length:11
					response.setAccruedInterest(returnValue.substring(77,100)); //length:23
					response.setDateOpened(returnValue.substring(100,108)); //length:8
					response.setProductCode(returnValue.substring(108,111)); //length:3
					response.setEmployeeAccount(returnValue.substring(111,112)); //length:1
					response.setJointAccount(returnValue.substring(112,115)); //length:3
				}
				command.close();
			}else{
				nullError="";
				nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
				nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
				nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
				nullError=nullError + ((request.getUserReferenceNumber().equals("")) ? "Reference Number \t" : "");
				response.setErrorCode("99");
				response.setReplyText("Required fields: " + nullError);
				logger.debug(response);
			}
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "AccountDetailsMessageIMResponse response");
		 }
		return response;
	}
	public AccountDetailsMessageSTResponse accountMessageST(AccountDetailsMessageSTRequest request){
		AccountDetailsMessageSTResponse response = new AccountDetailsMessageSTResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			if(!request.getCurrencyCode().equals("") && !request.getBranchCode().equals("") && !request.getAccountId().equals("") && !request.getUserReferenceNumber().equals("")){
				String returnValue = client.getTTIBAccountLoanSA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId());
				logger.debug(returnValue);
				if(returnValue == ""){
					response.setErrorCode("99");
					response.setReplyText("Error in connecting to mainframe");
				}else if(returnValue.contains("ERROR READING")){
					response.setErrorCode("99");
					response.setReplyText(returnValue.substring(6,35));
				}else{
					response.setTransactionStatusCode(returnValue.substring(5,7)); //length:2
					response.setCurrencyCode(returnValue.substring(6,9)); //length:3
					response.setBranchCode(returnValue.substring(9,12)); //length:3
					response.setAccountId(returnValue.substring(12,22)); //length:10
					response.setAccountStatus(returnValue.substring(22,24)); //length:2
					response.setCustomerShortName(returnValue.substring(24,37)); //length:13
					response.setCurrentBalance(returnValue.substring(37,60)); //length:23
					response.setDepositTerm(returnValue.substring(60,66)); //length:6
					response.setInterestRate(returnValue.substring(66,77));////length:11
					response.setAccruedInterest(returnValue.substring(77,100)); //length:23
					response.setDateOpened(returnValue.substring(100,108)); //length:8
					response.setProductCode(returnValue.substring(108,111)); //length:3
					response.setEmployeeAccount(returnValue.substring(111,112)); //length:1
					response.setJointAccount(returnValue.substring(112,115)); //length:3
				}
				command.close();
				}else{
					nullError="";
					nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
					nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
					nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
					nullError=nullError + ((request.getUserReferenceNumber().equals("")) ? "Reference Number \t" : "");
					response.setErrorCode("99");
					response.setReplyText("Required fields: " + nullError);
					logger.debug(response);
				}
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "AccountDetailsMessageSTResponse response");
		 }
		return response;
	}
	
	public AccountDetailsMessageTDResponse accountMessageTD(AccountDetailsMessageTDRequest request){
		AccountDetailsMessageTDResponse response = new AccountDetailsMessageTDResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			if(!request.getCurrencyCode().equals("") && !request.getBranchCode().equals("") && !request.getAccountId().equals("") && !request.getUserReferenceNumber().equals("")){
				String returnValue = client.getTTIBAccountLoanTD(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId());
				logger.debug(returnValue);
				if(returnValue == ""){
					response.setErrorCode("99");
					response.setReplyText("Error in connecting to mainframe");
				}else if(returnValue.contains("ERROR READING")){
					response.setErrorCode("99");
					response.setReplyText(returnValue.substring(6,35));
				}else{
					response.setTransactionStatusCode(returnValue.substring(5,7)); //length:2
					response.setCurrencyCode(returnValue.substring(6,9)); //length:3
					response.setBranchCode(returnValue.substring(9,12)); //length:3
					response.setAccountId(returnValue.substring(12,22)); //length:10
					response.setAccountStatus(returnValue.substring(22,24)); //length:2
					response.setCustomerShortName(returnValue.substring(24,37)); //length:13
					response.setCurrentBalance(returnValue.substring(37,60)); //length:23
					response.setDepositTerm(returnValue.substring(60,66)); //length:6
					response.setInterestRate(returnValue.substring(66,77));////length:11
					response.setAccruedInterest(returnValue.substring(77,100)); //length:23
					response.setDateOpened(returnValue.substring(100,108)); //length:8
					response.setProductCode(returnValue.substring(108,111)); //length:3
					response.setEmployeeAccount(returnValue.substring(111,112)); //length:1
					response.setJointAccount(returnValue.substring(112,115)); //length:3
				}
				command.close();
			}else{
				nullError="";
				nullError=nullError + ((request.getCurrencyCode().equals("")) ? "Currency Code \t" : "");
				nullError=nullError + ((request.getBranchCode().equals("")) ? "Branch Code \t" : "");
				nullError=nullError + ((request.getAccountId().equals("")) ? "Account ID \t" : "");
				nullError=nullError + ((request.getUserReferenceNumber().equals("")) ? "Reference Number \t" : "");
				response.setErrorCode("99");
				response.setReplyText("Required fields: " + nullError);
				logger.debug(response);
			}
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		
		if(response!=null){
			 SystematicsUtil.logRequestResponse(response, "AccountDetailsMessageTDResponse response");
		 }
		return response;
	}
	
	//collection used to store all the records before response
	List<TransactionHistoryResponseList> responseList;
	int nextRecordNumber;
	String lastDataFlag;
	boolean responseHasMoreRecord;
	private int numberOfResponse=500;
	int seqNumber;
	public TransactionHistoryCAResponse transactionHistoryCA(TransactionHistoryCARequest request){
		TransactionHistoryCAResponse response = new TransactionHistoryCAResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		responseList = new ArrayList<TransactionHistoryResponseList>();
		
		responseHasMoreRecord=false;
		seqNumber=1;
		String returnValue="";
	
		try {
			//String requestValue="First Request:WSP1" + "    " + request.getCurrencyCode()+request.getBranchCode()+request.getAccountId()+SystematicsUtil.getNextRecordNumber(nextRecordNumber)+request.getStartDate()+request.getEndDate();
			//logger.debug(requestValue);
			
			
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			//check if request has null field/s
			
			if(!SystematicsUtil.getNotNullString(request.getCurrencyCode()).equals("") && !SystematicsUtil.getNotNullString(request.getBranchCode()).equals("") && !SystematicsUtil.getNotNullString(request.getAccountId()).equals("")  && !SystematicsUtil.getNotNullString(request.getStartDate()).equals("") && !SystematicsUtil.getNotNullString(request.getEndDate()).equals("") && !SystematicsUtil.getNotNullString(request.getStartingRecord()).equals("")){
			//if(request.getCurrencyCode()!=null){
				nextRecordNumber=Integer.parseInt(request.getStartingRecord());	
					returnValue = client.getTransactionHistoryCA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getStartDate(), request.getEndDate(), SystematicsUtil.getNextRecordNumber(nextRecordNumber), "");
					System.out.println("Return: "+returnValue);
					logger.debug(returnValue);
					if(returnValue == ""){
						response.setErrorCode("99");
						response.setReplyText("Error in connecting to mainframe");
					}else if(returnValue.contains("ERROR READING")){
						response.setErrorCode("99");
						response.setReplyText(returnValue.substring(6,35));
					}else{
						
						response.setTranId(returnValue.substring(0,4));
						response.setTransactionStatusCode(returnValue.substring(4,6));
						//to insert 0 value
						response.setCurrencyCode(returnValue.substring(6,9));
						response.setBranchCode(returnValue.substring(9,12));
						response.setAccountId(returnValue.substring(12,22));
						response.setAccountStatus(returnValue.substring(22,24));
						response.setCurrentBalance(returnValue.substring(24,47));
						response.setAvailableBalance(returnValue.substring(47,70));
						response.setProductCode(returnValue.substring(70,73));
						response.setOpeningDate(returnValue.substring(73,81));
						//response.setLastDataFlag(returnValue.substring(81,82));
						response.setNumberOfRecords(returnValue.substring(82,84));
						
						
						////get the number of records
						String recordCount=response.getNumberOfRecords().trim();
						
						int recordNumber=Integer.parseInt(recordCount);
					
						//List<TransactionHistoryResponseList> responseList = response.getResponse();
						
						//loop
						int numOfHeadingChar=85;
						int numOfChar=0;
						
						for(int ctr=0;ctr<recordNumber;ctr++){
							TransactionHistoryResponseList th = new TransactionHistoryResponseList();
							th.setRecordSequence(returnValue.substring(numOfHeadingChar+numOfChar,3+numOfHeadingChar+numOfChar));
							th.setPostingDate(returnValue.substring(3+numOfHeadingChar+numOfChar,11+numOfHeadingChar+numOfChar));
							th.setTransAmount(returnValue.substring(11+numOfHeadingChar+numOfChar,34+numOfHeadingChar+numOfChar));
							th.setDebitCreditFlag(returnValue.substring(34+numOfHeadingChar+numOfChar,35+numOfHeadingChar+numOfChar));
							th.setCheckNumber(returnValue.substring(35+numOfHeadingChar+numOfChar,45+numOfHeadingChar+numOfChar));
							th.setTransactionDecs(returnValue.substring(45+numOfHeadingChar+numOfChar,75+numOfHeadingChar+numOfChar));
							th.setRunningTotal(returnValue.substring(75+numOfHeadingChar+numOfChar,98+numOfHeadingChar+numOfChar));
							responseList.add(th);
							
							numOfChar+=99;
						}
						nextRecordNumber+=responseList.size();
						String lastKeyUsed=returnValue.substring(1571,1607);
						System.out.println("last key: " + lastKeyUsed);
						//yes or no character
						//String datxaFlag=returnValue.substring(response);
						//check if data flag yes or no
						//response.setResponse(responseList);	
						lastDataFlag=returnValue.substring(81,82);
						
						while((lastDataFlag.equals("Y") && responseList.size()<numberOfResponse)  && !lastKeyUsed.equalsIgnoreCase("") ){
							if(!lastKeyUsed.equals("")){
								String requestNextValue="Second Request:WSP1" + "    " +request.getCurrencyCode()+request.getBranchCode()+request.getAccountId()+SystematicsUtil.getNextRecordNumber(nextRecordNumber)+request.getStartDate()+request.getEndDate() +lastKeyUsed;
								logger.debug(requestNextValue);
								String returnSecondValue = client.getTransactionHistoryCA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getStartDate(), request.getEndDate(), SystematicsUtil.getNextRecordNumber(nextRecordNumber), lastKeyUsed);
								logger.debug(returnSecondValue);
								lastKeyUsed=settransactionHistoryCAResponse(response,  returnSecondValue);

							}
						}
						response.setHasMoreRecord("N");
						if(responseHasMoreRecord){
							response.setHasMoreRecord("Y");
						}
					
						response.setNumberOfRecords(""+responseList.size());
						response.setResponse(responseList);	
						//System.out.println("Number of records:"+responseList.size());
						//responseList.clear();
					   // response.setRecordSequence(responseList.);
				       // end loop
						
						if(response!=null){
							 SystematicsUtil.logRequestResponse(response, "TransactionHistoryCAResponse response");
						 }
						
						 
					}
					
					
				
					command.close();
					
			}else{
				nullError="";
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getCurrencyCode()).equals("")) ? "Currency Code \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getBranchCode()).equals("")) ? "Branch Code \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getAccountId()).equals("")) ? "Account ID \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getStartDate()).equals("")) ? "Start Date \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getEndDate()).equals("")) ? "End Date \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getStartingRecord()).equals("")) ? "Starting Record \t" : "");
				response.setErrorCode("99");
				response.setReplyText("Required fields: " + nullError);
				logger.debug(response);
			}
			
			
		} catch (JagacyException e) {
			//e.printStackTrace();
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
			logger.debug("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}catch (Exception e) {
			//e.printStackTrace();
			response.setErrorCode("99");
			response.setReplyText("Response error: " + returnValue);
			logger.debug("Response error: " + returnValue);
		}
		return response;
	}
	
	///set the response before send
	public String settransactionHistoryCAResponse(TransactionHistoryCAResponse response, String returnValue){
		String lastKeyUsed="";
		try{
			//logger.debug(returnValue);
			if(returnValue.equals("") ){
				//System.out.println("empty return");
				response.setErrorCode("99");
				response.setReplyText("Error in connecting to mainframe");
			}else if(returnValue.contains("ERROR READING")){
				response.setErrorCode("99");
				response.setReplyText(returnValue.substring(6,35));
			}else{
				
				/*response.setTranId(returnValue.substring(0,4));
				response.setTransactionStatusCode(returnValue.substring(4,6));
				//to insert 0 value
				response.setCurrencyCode(returnValue.substring(6,9));
				response.setBranchCode(returnValue.substring(9,12));
				response.setAccountId(returnValue.substring(12,22));
				response.setAccountStatus(returnValue.substring(22,24));
				response.setCurrentBalance(returnValue.substring(24,47));
				response.setAvailableBalance(returnValue.substring(47,70));
				response.setProductCode(returnValue.substring(70,73));
				response.setOpeningDate(returnValue.substring(73,81));*/
				//response.setLastDataFlag(returnValue.substring(81,82));
				//response.setNumberOfRecords(returnValue.substring(82,84));
				
				////get the number of records
				String recordCount=returnValue.substring(82,84);
				lastDataFlag=returnValue.substring(81,82);
				int recordNumber=Integer.parseInt(recordCount);
			
				//List<TransactionHistoryResponseList> responseList = response.getResponse();
				
				//loop
				int numOfHeadingChar=85;
				int numOfChar=0;
				int numberOfRecords=0;
				for(int ctr=0;ctr<recordNumber;ctr++){
					if(responseList.size()<numberOfResponse){
						TransactionHistoryResponseList th = new TransactionHistoryResponseList();
						th.setRecordSequence(returnValue.substring(numOfHeadingChar+numOfChar,3+numOfHeadingChar+numOfChar));
						th.setPostingDate(returnValue.substring(3+numOfHeadingChar+numOfChar,11+numOfHeadingChar+numOfChar));
						th.setTransAmount(returnValue.substring(11+numOfHeadingChar+numOfChar,34+numOfHeadingChar+numOfChar));
						th.setDebitCreditFlag(returnValue.substring(34+numOfHeadingChar+numOfChar,35+numOfHeadingChar+numOfChar));
						th.setCheckNumber(returnValue.substring(35+numOfHeadingChar+numOfChar,45+numOfHeadingChar+numOfChar));
						th.setTransactionDecs(returnValue.substring(45+numOfHeadingChar+numOfChar,75+numOfHeadingChar+numOfChar));
						th.setRunningTotal(returnValue.substring(75+numOfHeadingChar+numOfChar,98+numOfHeadingChar+numOfChar));
						responseList.add(th);
						numberOfRecords++;
						numOfChar+=99;
					}else{
						System.out.println("Last break :"+returnValue.substring(35+numOfHeadingChar+numOfChar,45+numOfHeadingChar+numOfChar));
						responseHasMoreRecord=true;
						break;
					}
					
				}
				nextRecordNumber+=numberOfRecords;
				//System.out.println("number of records:"+numberOfRecords);
				 lastKeyUsed=returnValue.substring(1571,1607);
				 if(lastDataFlag.equals("Y")){
					 responseHasMoreRecord=true;
				 }else{
					 responseHasMoreRecord=false;
				 }
				//yes or no character
				//String dataFlag=returnValue.substring(response);
				//check if data flag yes or no
				//response.setResponse(responseList);	
			}
		
		}
		catch(Exception e){
			
		}finally{
			return lastKeyUsed;	
		}
		
	
	}
	
	public TransactionHistorySAResponse transactionHistorySA(TransactionHistorySARequest request){
		TransactionHistorySAResponse response = new TransactionHistorySAResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		responseList = new ArrayList<TransactionHistoryResponseList>();
		responseHasMoreRecord=false;
		String returnValue="";
		
		ByteArrayOutputStream baos=null;
		XMLEncoder xmlEncoder=null;
		String responseLog="";
		try {
			//log first     currCode + branCode + accntId + nextRecordNumber+strDate+eDate +"**"+lastKeyUsed+"**";
			/*
			 * String response = "";
		String code = "WSP2";
		String transId = "    ";
		String seqNum = "001";
		String currCode = currencyCode;
		String branCode = branchCode;
		String accntId = accountId;
		String strDate = startDate;
		String eDate = endDate;
			 * 
			 */
			
			//String requestValue="First Request:WSP2" + "    " + "001" +request.getCurrencyCode()+request.getBranchCode()+request.getAccountId()+SystematicsUtil.getNextRecordNumber(nextRecordNumber)+request.getStartDate()+request.getEndDate();
			//logger.debug(requestValue);
			
			 
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			//check if request has null field/s
			if(!SystematicsUtil.getNotNullString(request.getCurrencyCode()).equals("") && !SystematicsUtil.getNotNullString(request.getBranchCode()).equals("") && !SystematicsUtil.getNotNullString(request.getAccountId()).equals("")  && !SystematicsUtil.getNotNullString(request.getStartDate()).equals("") && !SystematicsUtil.getNotNullString(request.getEndDate()).equals("") && !SystematicsUtil.getNotNullString(request.getStartingRecord()).equals("")){
			//if(request.getCurrencyCode()!=null){
				
					nextRecordNumber=Integer.parseInt(request.getStartingRecord());
					//System.out.println("First record:"+nextRecordNumber);
					returnValue = client.getTransactionHistorySA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getStartDate(), request.getEndDate(), SystematicsUtil.getNextRecordNumber(nextRecordNumber), "");
					System.out.println("Return: "+returnValue);
					logger.debug(returnValue);
					if(returnValue == ""){
						response.setErrorCode("99");
						response.setReplyText("Error in connecting to mainframe");
					}else if(returnValue.contains("ERROR READING")){
						response.setErrorCode("99");
						response.setReplyText(returnValue.substring(6,35));
					}else{
						response.setTranId(returnValue.substring(0,4));
						response.setTransactionStatusCode(returnValue.substring(4,6));
						//to insert 0 value
						response.setCurrencyCode(returnValue.substring(6,9));
						response.setBranchCode(returnValue.substring(9,12));
						response.setAccountId(returnValue.substring(12,22));
						response.setAccountStatus(returnValue.substring(22,24));
						response.setCurrentBalance(returnValue.substring(24,47));
						response.setAvailableBalance(returnValue.substring(47,70));
						response.setProductCode(returnValue.substring(70,73));
						response.setOpeningDate(returnValue.substring(73,81));
						response.setNumberOfRecords(returnValue.substring(82,84));
						//response.setLastDataFlag(returnValue.substring(81,82));
						

						
						////get the number of records
						String recordCount=response.getNumberOfRecords().trim();
						
						int recordNumber=Integer.parseInt(recordCount);
					
						//List<TransactionHistoryResponseList> responseList = response.getResponse();
						
						//loop
						int numOfHeadingChar=85;
						int numOfChar=0;
						
						for(int ctr=0;ctr<recordNumber;ctr++){
							TransactionHistoryResponseList th = new TransactionHistoryResponseList();
							th.setRecordSequence(returnValue.substring(numOfHeadingChar+numOfChar,3+numOfHeadingChar+numOfChar));
							th.setPostingDate(returnValue.substring(3+numOfHeadingChar+numOfChar,11+numOfHeadingChar+numOfChar));
							th.setTransAmount(returnValue.substring(11+numOfHeadingChar+numOfChar,34+numOfHeadingChar+numOfChar));
							th.setDebitCreditFlag(returnValue.substring(34+numOfHeadingChar+numOfChar,35+numOfHeadingChar+numOfChar));
							th.setCheckNumber(returnValue.substring(35+numOfHeadingChar+numOfChar,45+numOfHeadingChar+numOfChar));
							th.setTransactionDecs(returnValue.substring(45+numOfHeadingChar+numOfChar,75+numOfHeadingChar+numOfChar));
							th.setRunningTotal(returnValue.substring(75+numOfHeadingChar+numOfChar,98+numOfHeadingChar+numOfChar));
							responseList.add(th);
							
							numOfChar+=99;
						}
						nextRecordNumber+=responseList.size();
						String lastKeyUsed=returnValue.substring(1571,1607);
						System.out.println("last key: " + lastKeyUsed);
						//yes or no character
						//String datxaFlag=returnValue.substring(response);
						//check if data flag yes or no
						//response.setResponse(responseList);	
						lastDataFlag=returnValue.substring(81,82);
						
						while((lastDataFlag.equals("Y") && responseList.size()<numberOfResponse)  && !lastKeyUsed.equalsIgnoreCase("") ){
							if(!lastKeyUsed.equals("")){
								String requestNextValue="Second Request:WSP2" + "    " +request.getCurrencyCode()+request.getBranchCode()+request.getAccountId()+SystematicsUtil.getNextRecordNumber(nextRecordNumber)+request.getStartDate()+request.getEndDate() +lastKeyUsed;
								logger.debug(requestNextValue);
								String returnSecondValue = client.getTransactionHistorySA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getStartDate(), request.getEndDate(), SystematicsUtil.getNextRecordNumber(nextRecordNumber), lastKeyUsed);
								logger.debug(returnSecondValue);
								lastKeyUsed=settransactionHistorySAResponse(response,  returnSecondValue);

							}
						}
						
						response.setHasMoreRecord("N");
						if(responseHasMoreRecord){
							response.setHasMoreRecord("Y");
						}

						response.setNumberOfRecords(""+responseList.size());
						response.setResponse(responseList);	
						//System.out.println("Number of records:"+responseList.size());
						
						 if(response!=null){
							 SystematicsUtil.logRequestResponse(response, "TransactionHistorySAResponse response");
						 }
						
						
					}
					
					
				
					command.close();
					
			}else{
				nullError="";
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getCurrencyCode()).equals("")) ? "Currency Code \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getBranchCode()).equals("")) ? "Branch Code \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getAccountId()).equals("")) ? "Account ID \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getStartDate()).equals("")) ? "Start Date \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getEndDate()).equals("")) ? "End Date \t" : "");
				nullError=nullError + ((SystematicsUtil.getNotNullString(request.getStartingRecord()).equals("")) ? "Starting Record \t" : "");
				response.setErrorCode("99");
				response.setReplyText("Required fields: " + nullError);
				logger.debug(response);
			}
			
			
		} catch (JagacyException e) {
			
			//e.printStackTrace();
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
			logger.debug("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}catch (Exception e) {
			//e.printStackTrace();
			response.setErrorCode("99");
			response.setReplyText("Response error:" +returnValue);
			logger.debug("Response error: " + returnValue);
		}
		return response;
		
		
		
		
		
		/*TransactionHistorySAResponse response = new TransactionHistorySAResponse();
		System.setProperty("jagacy.properties.dir","classpath");
		try {
			LoanAccountInquiryCommand command = new LoanAccountInquiryCommand();
			command.open();
			String returnValue = client.getTransactionHistorySA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getStartDate(), request.getEndDate());
			logger.debug(returnValue);
			if(returnValue == ""){
				response.setErrorCode("99");
				response.setReplyText("Error in connecting to mainframe");
			}else if(returnValue.contains("ERROR READING")){
				response.setErrorCode("99");
				response.setReplyText(returnValue.substring(6,35));
			}else{
				response.setTranId(returnValue.substring(0,4));
				response.setTransactionStatusCode(returnValue.substring(4,6));
				//to insert 0 value
				response.setCurrencyCode(returnValue.substring(7,10));
				response.setBranchCode(returnValue.substring(10,13));
				response.setAccountId(returnValue.substring(13,23));
				response.setAccountStatus(returnValue.substring(23,25));
				response.setCurrentBalance(returnValue.substring(25,48));
				response.setAvailableBalance(returnValue.substring(48,71));
				response.setProductCode(returnValue.substring(71,74));
				response.setOpeningDate(returnValue.substring(74,82));
				response.setLastDataFlag(returnValue.substring(82,83));
				response.setNumberOfRecords(returnValue.substring(83,85));
				
				/*
				//List<TransactionHistoryResponseList> responseList = response.getResponse();
				List<TransactionHistoryResponseList> responseList = new ArrayList<TransactionHistoryResponseList>();
				
				//loop
				int numOfHeadingChar=84;
				int numOfChar=0;
				for(int ctr=0;ctr<15;ctr++){
					TransactionHistoryResponseList th = new TransactionHistoryResponseList();
					th.setRecordSequence(returnValue.substring(7+numOfChar+numOfHeadingChar,10+numOfChar+numOfHeadingChar));
					//th.setPostingDate(returnValue.substring(7+numOfChar+numOfHeadingChar,10+numOfChar+numOfHeadingChar));
					responseList.add(th);
					numOfChar+=110;
				}
				System.out.println(responseList.size());
			   // response.setRecordSequence(responseList.);
				//end loop
				 
				 
			}
			command.close();
		} catch (JagacyException e) {
			response.setErrorCode("99");
			response.setReplyText("Error in connecting to mainframe. More INFO: " + e.getMessage());
		}
		return response;*/
	}
	
	///set the response of SA before send
	public String settransactionHistorySAResponse(TransactionHistorySAResponse response, String returnValue){
			String lastKeyUsed="";
			try{
			//logger.debug(returnValue);
			if(returnValue.equals("") ){
				System.out.println("empty return");
				response.setErrorCode("99");
				response.setReplyText("Error in connecting to mainframe");
			}else if(returnValue.contains("ERROR READING")){
				response.setErrorCode("99");
				response.setReplyText(returnValue.substring(6,35));
				}else{
					
					/*response.setTranId(returnValue.substring(0,4));
					response.setTransactionStatusCode(returnValue.substring(4,6));
					//to insert 0 value
					response.setCurrencyCode(returnValue.substring(6,9));
					response.setBranchCode(returnValue.substring(9,12));
					response.setAccountId(returnValue.substring(12,22));
					response.setAccountStatus(returnValue.substring(22,24));
					response.setCurrentBalance(returnValue.substring(24,47));
					response.setAvailableBalance(returnValue.substring(47,70));
					response.setProductCode(returnValue.substring(70,73));
					response.setOpeningDate(returnValue.substring(73,81));*/
					//response.setLastDataFlag(returnValue.substring(81,82));
					//response.setNumberOfRecords(returnValue.substring(82,84));
					
					////get the number of records
					String recordCount=returnValue.substring(82,84);
					lastDataFlag=returnValue.substring(81,82);
					int recordNumber=Integer.parseInt(recordCount);
				
					//List<TransactionHistoryResponseList> responseList = response.getResponse();
					
					//loop
					int numOfHeadingChar=85;
					int numOfChar=0;
					int numberOfRecords=0;
					for(int ctr=0;ctr<recordNumber;ctr++){
						if(responseList.size()<numberOfResponse){
							TransactionHistoryResponseList th = new TransactionHistoryResponseList();
							th.setRecordSequence(returnValue.substring(numOfHeadingChar+numOfChar,3+numOfHeadingChar+numOfChar));
							th.setPostingDate(returnValue.substring(3+numOfHeadingChar+numOfChar,11+numOfHeadingChar+numOfChar));
							th.setTransAmount(returnValue.substring(11+numOfHeadingChar+numOfChar,34+numOfHeadingChar+numOfChar));
							th.setDebitCreditFlag(returnValue.substring(34+numOfHeadingChar+numOfChar,35+numOfHeadingChar+numOfChar));
							th.setCheckNumber(returnValue.substring(35+numOfHeadingChar+numOfChar,45+numOfHeadingChar+numOfChar));
							th.setTransactionDecs(returnValue.substring(45+numOfHeadingChar+numOfChar,75+numOfHeadingChar+numOfChar));
							th.setRunningTotal(returnValue.substring(75+numOfHeadingChar+numOfChar,98+numOfHeadingChar+numOfChar));
							responseList.add(th);
							numberOfRecords++;
							numOfChar+=99;
						}else{
							//System.out.println("break already last "+returnValue.substring(75+numOfHeadingChar+numOfChar,98+numOfHeadingChar+numOfChar));
							responseHasMoreRecord=true;
							break;
						}
						
					}
					nextRecordNumber+=numberOfRecords;
				//	System.out.println("number of records:"+numberOfRecords);
					 lastKeyUsed=returnValue.substring(1571,1607);
					 
					 if(lastDataFlag.equals("Y")){
						 responseHasMoreRecord=true;
					 }else{
						 responseHasMoreRecord=false;
					 }
					//yes or no character
					//String dataFlag=returnValue.substring(response);
					//check if data flag yes or no
					//response.setResponse(responseList);	
				}
			
			}
			catch(Exception e){
				
			}finally{
				return lastKeyUsed;	
			}
			
		
		}
	
}
