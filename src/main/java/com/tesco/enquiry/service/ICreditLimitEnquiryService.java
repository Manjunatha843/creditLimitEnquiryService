/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.service;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryRequest;
import com.tesco.enquiry.model.EnquiryResponse;

/**
 * @author Manju at 04-Sep-2023
 * Description:this class will be used
 *
 */
public interface ICreditLimitEnquiryService {
	public EnquiryResponse enquiry(EnquiryRequest  creditLimitRequest) throws BusinessException, SystemException;
}
