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
		return systematicsBO.balanceInquirySA(request);
	}
	
	@WebMethod(operationName = "WSBalInqCA")
	public BalanceInquiryResponse getBalanceInquiryCa(BalanceInquiryRequest request){
		return systematicsBO.balanceInquiryCA(request);
	}
	
	@WebMethod(operationName = "WSDebitCA")
	public ServiceChargeResponse debitCa(ServiceChargeRequest request){
		return systematicsBO.debitCa(request);
	}
	
	@WebMethod(operationName = "WSFundTrSAtoCA")
	public FundTransferResponse fundTrSAtoCA(FundTransferRequest request){
		return systematicsBO.fundTrSAtoCA(request);
	}
	
	@WebMethod(operationName = "WSFundTrCAtoSA")
	public FundTransferResponse fundTrCAtoSA(FundTransferRequest request){
		return systematicsBO.fundTrCAtoSA(request);
	}
	
	@WebMethod(operationName = "WSFundTrSAtoSA")
	public FundTransferResponse fundTrSAtoSA(FundTransferRequest request){
		return systematicsBO.fundTrSAtoSA(request);
	}
	
	@WebMethod(operationName = "WSFundTrCAtoCA")
	public FundTransferResponse fundTrCAtoCA(FundTransferRequest request){
		return systematicsBO.fundTrCAtoCA(request);
	}
	
	@WebMethod(operationName = "WSBillPayIBS")
	public BillsPaymentResponse billPayfrSA(BillsPaymentRequest request){
		return systematicsBO.billPayfrSA(request);
	}

	@WebMethod(operationName = "WSDebitMemoIM")
	public DebitMemoImResponse debitMemoIm(DebitMemoImRequest request){
		return systematicsBO.debitMemoIm(request);
	}
	
	@WebMethod(operationName = "WSDebitMemoST")
	public DebitMemoStResponse debitMemoSt(DebitMemoStRequest request){
		return systematicsBO.debitMemoSt(request);
	}
	
	@WebMethod(operationName = "WSAcctDetInqLN")
	public AccountDetailsInqLoanResponse accountLoan(AccountDetailsInqLoanRequest request){
		return systematicsBO.accountLoan(request);
	}
	
	@WebMethod(operationName = "WSAcctDetInqIM")
	public AccountDetailsMessageIMResponse accountMessageIM(AccountDetailsMessageIMRequest request){
		return systematicsBO.accountMessageIM(request);
	}
	
	@WebMethod(operationName = "WSAcctDetInqST")
	public AccountDetailsMessageSTResponse accountMessageST(AccountDetailsMessageSTRequest request){
		return systematicsBO.accountMessageST(request);
	}
	
	@WebMethod(operationName = "WSAcctDetInqTD")
	public AccountDetailsMessageTDResponse accountMessageTD(AccountDetailsMessageTDRequest request){
		return systematicsBO.accountMessageTD(request);
	}
	
	@WebMethod(operationName = "WSTxHistoryCA")
	public TransactionHistoryCAResponse transactionHistoryCA(TransactionHistoryCARequest request){
		return systematicsBO.transactionHistoryCA(request);
	}
	
	@WebMethod(operationName = "WSTxHistorySA")
	public TransactionHistorySAResponse transactionHistorySA(TransactionHistorySARequest request){
		return systematicsBO.transactionHistorySA(request);
	}
}
