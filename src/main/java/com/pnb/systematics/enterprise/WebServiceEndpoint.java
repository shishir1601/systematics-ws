package com.pnb.systematics.enterprise;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;

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

@WebService(serviceName="SystematicsWebservice")
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
		SystematicsUtil.logRequestResponse(request, "BalanceInquiryRequest Request");
		return systematicsBO.balanceInquirySA(request);
	}
	
	@WebMethod(operationName = "WSBalInqCA")
	public BalanceInquiryResponse getBalanceInquiryCa(BalanceInquiryRequest request){
		SystematicsUtil.logRequestResponse(request, "BalanceInquiryRequest Request");
		return systematicsBO.balanceInquiryCA(request);
	}
	
	@WebMethod(operationName = "WSDebitCA")
	public ServiceChargeResponse debitCa(ServiceChargeRequest request){
		SystematicsUtil.logRequestResponse(request, "ServiceChargeRequest Request");
		return systematicsBO.debitCa(request);
	}
	
	@WebMethod(operationName = "WSFundTrSAtoCA")
	public FundTransferResponse fundTrSAtoCA(FundTransferRequest request){
		SystematicsUtil.logRequestResponse(request, "FundTransferRequest Request");
		return systematicsBO.fundTrSAtoCA(request);
	}
	
	@WebMethod(operationName = "WSFundTrCAtoSA")
	public FundTransferResponse fundTrCAtoSA(FundTransferRequest request){
		SystematicsUtil.logRequestResponse(request, "FundTransferRequest Request");
		return systematicsBO.fundTrCAtoSA(request);
	}
	
	@WebMethod(operationName = "WSFundTrSAtoSA")
	public FundTransferResponse fundTrSAtoSA(FundTransferRequest request){
		SystematicsUtil.logRequestResponse(request, "FundTransferRequest Request");
		return systematicsBO.fundTrSAtoSA(request);
	}
	
	@WebMethod(operationName = "WSFundTrCAtoCA")
	public FundTransferResponse fundTrCAtoCA(FundTransferRequest request){
		SystematicsUtil.logRequestResponse(request, "FundTransferRequest Request");
		return systematicsBO.fundTrCAtoCA(request);
	}
	
	@WebMethod(operationName = "WSBillPayIBS")
	public BillsPaymentResponse billPayfrSA(BillsPaymentRequest request){
		SystematicsUtil.logRequestResponse(request, "BillsPaymentRequest Request");
		return systematicsBO.billPayfrSA(request);
	}

	@WebMethod(operationName = "WSDebitMemoIM")
	public DebitMemoImResponse debitMemoIm(DebitMemoImRequest request){
		SystematicsUtil.logRequestResponse(request, "DebitMemoImRequest Request");
		return systematicsBO.debitMemoIm(request);
	}
	
	@WebMethod(operationName = "WSDebitMemoST")
	public DebitMemoStResponse debitMemoSt(DebitMemoStRequest request){
		SystematicsUtil.logRequestResponse(request, "DebitMemoStRequest Request");
		return systematicsBO.debitMemoSt(request);
	}
	
	@WebMethod(operationName = "WSAcctDetInqLN")
	public AccountDetailsInqLoanResponse accountLoan(AccountDetailsInqLoanRequest request){
		SystematicsUtil.logRequestResponse(request, "AccountDetailsInqLoanRequest Request");
		return systematicsBO.accountLoan(request);
	}
	
	@WebMethod(operationName = "WSAcctDetInqIM")
	public AccountDetailsMessageIMResponse accountMessageIM(AccountDetailsMessageIMRequest request){
		SystematicsUtil.logRequestResponse(request, "AccountDetailsMessageIMRequest Request");
		return systematicsBO.accountMessageIM(request);
	}
	
	@WebMethod(operationName = "WSAcctDetInqST")
	public AccountDetailsMessageSTResponse accountMessageST(AccountDetailsMessageSTRequest request){
		SystematicsUtil.logRequestResponse(request, "AccountDetailsMessageSTRequest Request");
		return systematicsBO.accountMessageST(request);
	}
	
	@WebMethod(operationName = "WSAcctDetInqTD")
	public AccountDetailsMessageTDResponse accountMessageTD(AccountDetailsMessageTDRequest request){
		SystematicsUtil.logRequestResponse(request, "AccountDetailsMessageTDRequest Request");
		return systematicsBO.accountMessageTD(request);
	}
	
	@WebMethod(operationName = "WSTxHistoryCA")
	public TransactionHistoryCAResponse transactionHistoryCA(TransactionHistoryCARequest request){
		SystematicsUtil.logRequestResponse(request, "TransactionHistoryCARequest Request");
		return systematicsBO.transactionHistoryCA(request);
	}
	
	@WebMethod(operationName = "WSTxHistorySA")
	public TransactionHistorySAResponse transactionHistorySA(TransactionHistorySARequest request){
		SystematicsUtil.logRequestResponse(request,"TransactionHistorySARequest Request");
		return systematicsBO.transactionHistorySA(request);
	}
	
	
}
