/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.CreditLimitEnquiryRequestInvalidException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryRequest;
import com.tesco.enquiry.model.EnquiryResponse;
import com.tesco.enquiry.service.ICreditLimitEnquiryService;
import com.tesco.enquiry.validator.CreditLimitEnquiryValidator;

/**
 * @author Manju at 04-Sep-2023
 * Description:this class will be used
 *
 */
@RestController
@RequestMapping("/v1") 
public class CreditLimitEnquiryController {
	@Autowired
	 CreditLimitEnquiryValidator creditLimitEnuiryValidator;
	@Autowired
	ICreditLimitEnquiryService CreditLimitService;

@GetMapping("/enquiry/{promocode}")
@ResponseBody
	public ResponseEntity<EnquiryResponse> enquiry(@PathVariable("promocode") String promocode,
			                           @RequestHeader("client_Id")String clientId,
			                           @RequestHeader("channel_Id")String channelId,
			                           @RequestHeader("message_ts")String messageTs,
			                           @RequestHeader("request_Id")String requestId) throws CreditLimitEnquiryRequestInvalidException, BusinessException, SystemException {
	System.out.println("entered into controller");
	
	//1.get the request from the consumer or client
	EnquiryRequest  enquiryRequest=new EnquiryRequest();
	enquiryRequest.setPromocode(promocode);
	enquiryRequest.setClientId(clientId);
	enquiryRequest.setChannelId(channelId);
	enquiryRequest.setMessageTs(messageTs);
	enquiryRequest.setRequestId(requestId);
	//2.validate the request
	
	creditLimitEnuiryValidator.validateRequest(enquiryRequest);
	
	
	//3.prepare the service request
	//4.call the service layer by passing service request and get the service response
	 EnquiryResponse enquiryResponse=CreditLimitService.enquiry(enquiryRequest);
	 System.out.println("exit from controller");
		return new ResponseEntity<EnquiryResponse>(enquiryResponse,HttpStatus.OK);
	}
}
