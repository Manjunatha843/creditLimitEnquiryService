/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.exception;

/**
 * @author Manju at 04-Sep-2023
 * Description:this class will be used
 *
 */
public class CreditLimitEnquiryRequestInvalidException extends Exception {
	private String respCode;
	private String respMsg;
	public CreditLimitEnquiryRequestInvalidException(String respCode, String respMsg) {
		super();
		this.respCode = respCode;
		this.respMsg = respMsg;
	}
	
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

	@Override
	public String toString() {
		return "CreditLimitEnquiryRequestInvalidException [respCode=" + respCode + ", respMsg=" + respMsg + "]";
	}

}
