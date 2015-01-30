package com.pnb.systematics.enterprise;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;

import com.pnb.systematics.enterprise.bo.SystematicsBusinessObject;
import com.pnb.systematics.interaction.BalanceInquiryRequest;
import com.pnb.systematics.interaction.BalanceInquiryResponse;
import com.pnb.systematics.interaction.ServiceChargeRequest;
import com.pnb.systematics.interaction.ServiceChargeResponse;

@WebService(serviceName="SystematicsWebservices")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class WebServiceEndpoint {
	
	@Autowired
	SystematicsBusinessObject systematicsBO;

	@WebMethod(exclude = true)
	public void setSystematicsBusinessObject(SystematicsBusinessObject systematicsBO) {
		this.systematicsBO = systematicsBO;
	}
	
	@WebMethod(operationName = "WSBalInqSA")
	public BalanceInquiryResponse getBalanceInquirySa(BalanceInquiryRequest request){
		return systematicsBO.balanceInquirySA(request);
	}
	
	@WebMethod(operationName = "WSBalInqCA")
	public BalanceInquiryResponse getBalanceInquiryCa(BalanceInquiryRequest request){
		return systematicsBO.balanceInquiryCA(request);
	}
	
	@WebMethod(operationName = "WSDebitCA")
	public ServiceChargeResponse debitCa(ServiceChargeRequest request){
		return null;
	}
}
