/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.util;

/**
 * @author Manju at 04-Sep-2023 Description:this class will be used
 *
 */
public enum CreditLimitEnquiryErrorEnum {
	    error_100("100","promocode is expired","data error"),
		error_101("101","promocode is already used","data error"),
		error_102("102","promocode is not active","data error"),
		error_103("103","promocode is invalid","data error"),
		error_104("104","client id id invalid","data error"),
		error_111("111","database down","data error"),
		error_222("222","sql sysntax error","data error");
   

	private String errorCode;
	private String errorMsg;
	private String errorType;


	private CreditLimitEnquiryErrorEnum(String errorCode, String errorMsg, String errorType) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.errorType = errorType;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public static boolean checkErrorCode(String errorCode, String errorType) {
		boolean flag = false;
		for (CreditLimitEnquiryErrorEnum creditEnum : CreditLimitEnquiryErrorEnum.values()) {
			if (errorCode.equals(creditEnum.getErrorCode()) && errorType.equals(creditEnum.getErrorType())) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	

	/**
	 * @return
	 */


}
