package com.pnb.systematics.enterprise.bo;

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

public interface SystematicsBusinessObject {
	public BalanceInquiryResponse balanceInquirySA(BalanceInquiryRequest request);
	public BalanceInquiryResponse balanceInquiryCA(BalanceInquiryRequest request);
	public ServiceChargeResponse debitCa(ServiceChargeRequest request);
	public FundTransferResponse fundTrSAtoCA(FundTransferRequest request);
	public FundTransferResponse fundTrCAtoSA(FundTransferRequest request);
	public FundTransferResponse fundTrSAtoSA(FundTransferRequest request);
	public FundTransferResponse fundTrCAtoCA(FundTransferRequest request);
	public BillsPaymentResponse billPayfrSA(BillsPaymentRequest request);	
	public DebitMemoImResponse debitMemoIm(DebitMemoImRequest request);
	public DebitMemoStResponse debitMemoSt(DebitMemoStRequest request);
	public AccountDetailsInqLoanResponse accountLoan(AccountDetailsInqLoanRequest request);
	public AccountDetailsMessageIMResponse accountMessageIM(AccountDetailsMessageIMRequest request);
	public AccountDetailsMessageSTResponse accountMessageST(AccountDetailsMessageSTRequest request);
	public AccountDetailsMessageTDResponse accountMessageTD(AccountDetailsMessageTDRequest request);
    public TransactionHistoryCAResponse transactionHistoryCA(TransactionHistoryCARequest request);
    public TransactionHistorySAResponse transactionHistorySA(TransactionHistorySARequest request);

}