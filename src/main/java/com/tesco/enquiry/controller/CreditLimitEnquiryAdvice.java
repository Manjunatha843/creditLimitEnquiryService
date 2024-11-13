/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.CreditLimitEnquiryRequestInvalidException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryResponse;
import com.tesco.enquiry.model.StatusBlock;

/**
 * @author Manju at 04-Sep-2023 Description:this class will be used
 *
 */
@ControllerAdvice
public class CreditLimitEnquiryAdvice {
	@ResponseBody
	@ExceptionHandler(value = CreditLimitEnquiryRequestInvalidException.class)
	public ResponseEntity<EnquiryResponse> handleRequestInvalidException(
			CreditLimitEnquiryRequestInvalidException exception) {
		// prepare error response object
		EnquiryResponse enquiryResponse = buildErrorResponse(exception.getRespCode(),exception.getRespMsg());
		return new ResponseEntity<EnquiryResponse>(enquiryResponse, HttpStatus.BAD_REQUEST);
	}
	@ResponseBody
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<EnquiryResponse> handleDataError(BusinessException exception) {
		// prepare error response object
		EnquiryResponse enquiryResponse = buildErrorResponse(exception.getRespCode(),exception.getRespMsg());
		return new ResponseEntity<EnquiryResponse>(enquiryResponse, HttpStatus.BAD_REQUEST);
	}
	@ResponseBody
	@ExceptionHandler(value = SystemException.class)
	public ResponseEntity<EnquiryResponse> handleSystemError(SystemException exception) {
		// prepare error response object
		EnquiryResponse enquiryResponse = buildErrorResponse(exception.getRespCode(),exception.getRespMsg());
		return new ResponseEntity<EnquiryResponse>(enquiryResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * @param exception
	 * @return
	 */
	private EnquiryResponse buildErrorResponse(String respCode,String respMsg) {
		EnquiryResponse enquiryResponse = new EnquiryResponse();
		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(respCode);
		statusBlock.setRespMsg(respMsg);
		enquiryResponse.setStatusBlock(statusBlock);
		return enquiryResponse;
	}
}
