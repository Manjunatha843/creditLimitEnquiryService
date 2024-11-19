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
	private String cardnum;
	private String cvv;
	private String expdate;
	private String nameoncard;
	private long availableAmount;
	private long increaseAmount;
	private float increasePer;

	
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public String getNameoncard() {
		return nameoncard;
	}
	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
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
