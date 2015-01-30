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
			response.setMemoBalance(SystematicsUtil.getRealBalance(returnMessage.substring(133,155)));
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

}
