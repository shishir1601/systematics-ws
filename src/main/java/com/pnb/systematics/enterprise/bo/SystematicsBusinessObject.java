package com.pnb.systematics.enterprise.bo;

import com.pnb.systematics.interaction.BalanceInquiryRequest;
import com.pnb.systematics.interaction.BalanceInquiryResponse;

public interface SystematicsBusinessObject {
	public BalanceInquiryResponse balanceInquirySA(BalanceInquiryRequest request);
	public BalanceInquiryResponse balanceInquiryCA(BalanceInquiryRequest request);
}