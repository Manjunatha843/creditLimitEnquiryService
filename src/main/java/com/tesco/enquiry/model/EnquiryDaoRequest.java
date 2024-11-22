/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.model;

/**
 * @author Manju at 04-Sep-2023
 * Description:this class will be used
 *
 */
public class EnquiryDaoRequest {
	
	private  String clientId;
	private  String channelId;
	private String promoCode;
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	@Override
	public String toString() {
		return "EnquiryDaoRequest [promoCode=" + promoCode + ", clientId=" + clientId + ", channelId=" + channelId
				+ "]";
	}
	
	
	
}
