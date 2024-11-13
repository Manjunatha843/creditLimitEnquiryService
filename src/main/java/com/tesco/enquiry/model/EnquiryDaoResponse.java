/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.model;

/**
 * @author Manju at 04-Sep-2023
 * Description:this class will be used
 *
 */
public class EnquiryDaoResponse {
	private String respCode;
	private String respMsg;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	private String cardNum;
	private String cvv;
	private long availableAmount;
	private long increaseAmount;
	private float increasePer;
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	
	public long getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(long availableAmount) {
		this.availableAmount = availableAmount;
	}
	public long getIncreaseAmount() {
		return increaseAmount;
	}
	public void setIncreaseAmount(long increaseAmount) {
		this.increaseAmount = increaseAmount;
	}
	public float getIncreasePer() {
		return increasePer;
	}
	public void setIncreasePer(float increasePer) {
		this.increasePer = increasePer;
	}
	
}
