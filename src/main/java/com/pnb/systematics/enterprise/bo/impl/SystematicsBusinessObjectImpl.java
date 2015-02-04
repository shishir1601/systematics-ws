package com.pnb.systematics.enterprise.bo.impl;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.pnb.systematics.configuration.WebServiceUtil;
import com.pnb.systematics.enterprise.SystematicsClient;
import com.pnb.systematics.enterprise.SystematicsUtil;
import com.pnb.systematics.enterprise.bo.SystematicsBusinessObject;
import com.pnb.systematics.interaction.BalanceInquiryRequest;
import com.pnb.systematics.interaction.BalanceInquiryResponse;
import com.pnb.systematics.interaction.BillsPaymentRequest;
import com.pnb.systematics.interaction.BillsPaymentResponse;
import com.pnb.systematics.interaction.FundTransferRequest;
import com.pnb.systematics.interaction.FundTransferResponse;
import com.pnb.systematics.interaction.ServiceChargeRequest;
import com.pnb.systematics.interaction.ServiceChargeResponse;
import com.pnb.systematics.schema.GetFromTTIB2OutputProperties;
import com.pnb.systematics.schema.GetFromTTIB2ProcessWSResponse;

@Component
public class SystematicsBusinessObjectImpl implements SystematicsBusinessObject{	

	private static final SystematicsClient client = WebServiceUtil.systematicsClient();
	private static Logger logger = Logger.getLogger(SystematicsBusinessObjectImpl.class);
	
	public SystematicsBusinessObjectImpl(){
		BasicConfigurator.configure();
	}
	
	public BalanceInquiryResponse balanceInquirySA(BalanceInquiryRequest request) {
		BalanceInquiryResponse response = new BalanceInquiryResponse();
		logger.debug("Entering: Balance Inquiry SA");
		/*Sending the request*/
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBResponseSA(request.getAccountId(),request.getCurrencyCode(), request.getBranchCode());
		/*Getting the result*/
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			response.setTransactionStatusCode("99");
			response.setErrorCode("TS0304");
			response.setReplyText("ACCOUNT NOT FOUND");
			logger.fatal("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			logger.debug("TTIB return message" + returnMessage);
			response.setAccountId(request.getAccountId());
			response.setUserReferenceNumber(request.getUserReferenceNumber());
			response.setBalanceOnHold(SystematicsUtil.getRealBalance(returnMessage.substring(261,285)));
			response.setPleadgeAmount(SystematicsUtil.getRealBalance(returnMessage.substring(293,317)));
			response.setAccountStatus(returnMessage.substring(322,347));
			response.setCustomerShortName(returnMessage.substring(357,373));
			response.setTransactionStatusCode("00");
			response.setMemoBalance(SystematicsUtil.getRealBalance(returnMessage.substring(133,156)));
			response.setFloatAmount(SystematicsUtil.getRealBalance(returnMessage.substring(229,253)));
		}

		logger.debug("Exiting: Balance Inquiry SA");
		return response;
	}
	
	public BalanceInquiryResponse balanceInquiryCA(BalanceInquiryRequest request){
		BalanceInquiryResponse response = new BalanceInquiryResponse();              
		logger.debug("Entering: Balance Inquiry CA");
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
			response.setAvailableBalance(SystematicsUtil.getRealBalance(returnMessage.substring(168,193)));
			response.setUnavailableBalance(SystematicsUtil.getRealBalance(returnMessage.substring(281,303)));
			response.setAccountStatus(returnMessage.substring(351,374));
			response.setCustomerShortName(returnMessage.substring(384,404));
			response.setTransactionStatusCode("00");
		}
		logger.debug("Exiting: Balance Inquiry CA");
		return response;
	}


	public ServiceChargeResponse debitCa(ServiceChargeRequest request) {
		ServiceChargeResponse response = new ServiceChargeResponse();
		logger.debug("Entering Debit CA (Service Charge)");
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBServiceCharge(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			response.setTransactionStatusCode("99");
			response.setErrorCode("TS0304");
			response.setReplyText(prop.getErrorMessage().toUpperCase());
			logger.fatal("Error in return: " + prop.getErrorMessage());
		}else{
			String returnMessage = prop.getReturnMessage();
			String errorMessage = SystematicsUtil.getError(returnMessage);
			logger.debug("TTIB response: " + returnMessage);
			if(errorMessage.trim().length() == 0){
				response.setTransactionStatusCode("00");
				response.setAccountId(request.getAccountId());
				response.setMessageCode("I");
				response.setMessageText("PROCESS COMPLETE");
				response.setUserReferenceNumber(request.getUserReferenceNumber());
			}else{
				response.setTransactionStatusCode("99");
				response.setErrorCode("TS0304");
				response.setReplyText(prop.getErrorMessage().toUpperCase());
			}
		}
		logger.debug("Exiting Debit CA");
		return response;
	}

	public FundTransferResponse fundTrSAtoCA(FundTransferRequest request) {
		FundTransferResponse response = new FundTransferResponse();
		logger.debug("Entering Fund Transfer (SA to CA)");
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferSA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.fatal("Error in return: " + prop.getErrorMessage());
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
				logger.fatal("Error in return: " + prop.getErrorMessage());
			}
		}
		logger.debug("Exiting Fund Transfer (SA to CA)");
		return response;
	}

	public FundTransferResponse fundTrSAtoSA(FundTransferRequest request) {
		return null;
	}

	public FundTransferResponse fundTrCAtoSA(FundTransferRequest request) {
	   	FundTransferResponse response = new FundTransferResponse();
		logger.debug("Entering Fund Transfer (CA to SA)");
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBFundTransferCA(request.getCurrencyCode(), request.getFromAccountId(), request.getFromBranchCode(), request.getToAccountId(), request.getToBranchCode(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.fatal("Error in return: " + prop.getErrorMessage());
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
				logger.fatal("Error in return: " + prop.getErrorMessage());
			}
		}
		logger.debug("Exiting Fund Transfer (CA to SA)");
		return response;

	}

	public FundTransferResponse fundTrCAtoCA(FundTransferRequest request) {
		return null;
	}
	
	public BillsPaymentResponse billPayfrSA(BillsPaymentRequest request) {
		BillsPaymentResponse response = new BillsPaymentResponse();
		logger.debug("Entering Bills Payment (SA)");
		GetFromTTIB2ProcessWSResponse fromHost = client.getTTIBBillsPaymentSA(request.getCurrencyCode(), request.getBranchCode(), request.getAccountId(), request.getMerchantID(), request.getSubscriberNumber(), request.getBillNo(), request.getPayeeName(), request.getTransactionAmount());
		GetFromTTIB2OutputProperties prop = fromHost.getGetFromTTIB2ProcessWSReturn();
		if(prop.getErrorMessage().trim().length() != 0){
			String[] errorResponse = SystematicsUtil.checkForError(prop.getErrorMessage()).split("\\|");
			response.setErrorCode(errorResponse[1]);
			response.setReplyText(errorResponse[0]);
			logger.fatal("Error in return: " + prop.getErrorMessage());
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
				logger.fatal("Error in return: " + prop.getErrorMessage());
			}
		}
		logger.debug("Exiting Fund Transfer SA)");
		return response;
	}
}
