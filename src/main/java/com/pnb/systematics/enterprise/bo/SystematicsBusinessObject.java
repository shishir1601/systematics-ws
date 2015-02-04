package com.pnb.systematics.enterprise.bo;

import com.pnb.systematics.interaction.BalanceInquiryRequest;
import com.pnb.systematics.interaction.BalanceInquiryResponse;
import com.pnb.systematics.interaction.BillsPaymentRequest;
import com.pnb.systematics.interaction.BillsPaymentResponse;
import com.pnb.systematics.interaction.FundTransferRequest;
import com.pnb.systematics.interaction.FundTransferResponse;
import com.pnb.systematics.interaction.ServiceChargeRequest;
import com.pnb.systematics.interaction.ServiceChargeResponse;

public interface SystematicsBusinessObject {
	public BalanceInquiryResponse balanceInquirySA(BalanceInquiryRequest request);
	public BalanceInquiryResponse balanceInquiryCA(BalanceInquiryRequest request);
	public ServiceChargeResponse debitCa(ServiceChargeRequest request);
	public FundTransferResponse fundTrSAtoCA(FundTransferRequest request);
	public FundTransferResponse fundTrSAtoSA(FundTransferRequest request);
	public FundTransferResponse fundTrCAtoSA(FundTransferRequest request);
	public FundTransferResponse fundTrCAtoCA(FundTransferRequest request);
	public BillsPaymentResponse billPayfrSA(BillsPaymentRequest request);
}