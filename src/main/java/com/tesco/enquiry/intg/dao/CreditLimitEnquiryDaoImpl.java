/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.intg.dao;

import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;

/**
 * @author Manju at 04-Sep-2023 Description:this class will be used
 *
 */
@Component
public class CreditLimitEnquiryDaoImpl implements ICreditLimitEnquiryDao {

	@Override
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) throws BusinessException, SystemException {
		System.out.println("entered into Dao");
		//8.get the request from service layer
		//9.prepare the request for database
		//call database and get the database response
		String dbRespCode="0";
		String dbRespMsg="success";
		EnquiryDaoResponse enquiryDaoResponse=new EnquiryDaoResponse();
		try {
		if("0".equals(dbRespCode)) {
			enquiryDaoResponse.setRespCode("0");
			enquiryDaoResponse.setRespMsg("success");
			enquiryDaoResponse.setAvailableAmount(10000);
			enquiryDaoResponse.setCardNum("2345678910");
			enquiryDaoResponse.setCvv("123");
			enquiryDaoResponse.setIncreaseAmount(50000);
			enquiryDaoResponse.setIncreasePer(0.5f);
		}else if("1000".equals(dbRespCode)||"101".equals(dbRespCode)||"102".equals(dbRespCode)){
			throw new BusinessException(dbRespCode,dbRespMsg);
		}else {
			throw new SystemException(dbRespCode,dbRespMsg);
		}
		}catch(BusinessException be) {
			throw be;
		}catch(SystemException se){
			throw se;
		}
	{

	}

	System.out.println("exit from Dao");return enquiryDaoResponse;
}

}
