/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.validator;

import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.CreditLimitEnquiryRequestInvalidException;
import com.tesco.enquiry.model.EnquiryRequest;

/**
 * @author Manju at 04-Sep-2023
 * Description:this class will be used
 *
 */
@Component
public class CreditLimitEnquiryValidator {

	//if request is invalid send error response(that is user defined exception)
	//if the request is valid proceed further
	public void validateRequest(EnquiryRequest enquiryRequest) throws CreditLimitEnquiryRequestInvalidException{
		if(enquiryRequest.getPromocode()==null||enquiryRequest.getPromocode().isEmpty()||enquiryRequest.getPromocode().length()<11) {
			throw new CreditLimitEnquiryRequestInvalidException("enq001","invalid promocode");
		}
		//todo:need to apply validations for all the mandatory elements
		if(enquiryRequest.getClientId()==null||"".equals(enquiryRequest.getClientId())) {
			throw new CreditLimitEnquiryRequestInvalidException("enq002","invalid client_Id");
		}
	}

}
