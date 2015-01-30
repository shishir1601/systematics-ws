package com.pnb.systematics.enterprise.bo;

import com.pnb.systematics.interaction.BalanceInquiryRequest;
import com.pnb.systematics.interaction.BalanceInquiryResponse;
import com.pnb.systematics.interaction.ServiceChargeRequest;
import com.pnb.systematics.interaction.ServiceChargeResponse;

public interface SystematicsBusinessObject {
	public BalanceInquiryResponse balanceInquirySA(BalanceInquiryRequest request);
	public BalanceInquiryResponse balanceInquiryCA(BalanceInquiryRequest request);
	public ServiceChargeResponse debitCa(ServiceChargeRequest request);
}