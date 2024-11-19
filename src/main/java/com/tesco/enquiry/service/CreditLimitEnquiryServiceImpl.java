/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.intg.dao.ICreditLimitEnquiryDao;
import com.tesco.enquiry.model.CustomerInfo;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;
import com.tesco.enquiry.model.EnquiryRequest;
import com.tesco.enquiry.model.EnquiryResponse;
import com.tesco.enquiry.model.StatusBlock;

/**
 * @author Manju at 04-Sep-2023 Description:this class will be used
 *
 */
@Component
public class CreditLimitEnquiryServiceImpl implements ICreditLimitEnquiryService {
	@Autowired
	ICreditLimitEnquiryDao creditLimitDao;

	@Override
	public EnquiryResponse enquiry(EnquiryRequest creditLimitRequest) throws BusinessException, SystemException {
		System.out.println("entered into service");
  //5.get the request from controller
 //6.prepare the request dao integration layer
//7.call dao integration layer and get response
		EnquiryDaoRequest enquiryDaoRequest=new EnquiryDaoRequest();
		enquiryDaoRequest.setClientId(creditLimitRequest.getClientId());
		enquiryDaoRequest.setChannelId(creditLimitRequest.getChannelId());
		enquiryDaoRequest.setPromoCode(creditLimitRequest.getPromocode());
		
		EnquiryDaoResponse daoResp=creditLimitDao.enquiry(enquiryDaoRequest);
		//prepare the service response
		EnquiryResponse enquiryResponse=new EnquiryResponse(); 
		
		
		StatusBlock statusBlock=new StatusBlock();
		
		statusBlock.setRespCode(daoResp.getRespCode());
		statusBlock.setRespMsg(daoResp.getRespMsg());
		
		CustomerInfo customerInfo=new CustomerInfo();
		
		customerInfo.setAvailableAmount(daoResp.getAvailableAmount());
		customerInfo.setCardNum(daoResp.getCardnum());
		customerInfo.setCvv(daoResp.getCvv());
		customerInfo.setIncreaseAmount(daoResp.getIncreaseAmount());
		customerInfo.setIncreasePer(daoResp.getIncreasePer());
		
		enquiryResponse.setStatusBlock(statusBlock);
		enquiryResponse.setCustomerInfo(customerInfo);
		
		System.out.println("exit from service");
		return enquiryResponse;
	}

}
