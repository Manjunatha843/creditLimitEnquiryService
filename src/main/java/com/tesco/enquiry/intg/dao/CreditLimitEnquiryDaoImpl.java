/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.intg.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;
import com.tesco.enquiry.util.CreditLimitEnquiryConstant;
import com.tesco.enquiry.util.CreditLimitEnquiryErrorEnum;

/**
 * @author Manju at 04-Sep-2023 Description:this class will be used
 *
 */
@Component
public class CreditLimitEnquiryDaoImpl /**implements ICreditLimitEnquiryDao*/ {
   /***
	//@Override
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) throws BusinessException, SystemException {
		System.out.println("entered into Dao");
		// 8.get the request from service layer
		// 9.prepare the request for database
		// call database and get the database response

		EnquiryDaoResponse enquiryDaoResponse;
		try {
			System.out.println("entered int try");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clep", "root",
					"Manju@123");
			String sql = "CALL clep.enquire_v001(?,?,?,?,?)";
			CallableStatement cs = connection.prepareCall(sql);
			cs.setString(1, enquiryDaoRequest.getClientId());
			cs.setString(2, enquiryDaoRequest.getChannelId());
			cs.setString(3, enquiryDaoRequest.getPromoCode());
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);

			// cs.executeQuery();
			ResultSet rs = cs.executeQuery();
			String dbRespCode = cs.getString(4);
			String dbRespMsg = cs.getString(5);
			System.out.println("dbRespCode:" + dbRespCode + "dbRespMsg:" + dbRespMsg);
			System.out.println(rs);
			if (CreditLimitEnquiryConstant.ZERO.equals(dbRespCode)) {
				enquiryDaoResponse = new EnquiryDaoResponse();
				System.out.println("is it entering");
				while (rs.next()) {
					System.out.println("enterd into while");
					enquiryDaoResponse.setRespCode(dbRespCode);
					enquiryDaoResponse.setRespMsg(dbRespMsg);
					enquiryDaoResponse.setCardnum(rs.getString("cardnum"));
					enquiryDaoResponse.setCvv(rs.getString("cvv"));
					enquiryDaoResponse.setExpdate(rs.getString("expdate"));
					enquiryDaoResponse.setNameoncard(rs.getString("nameoncard"));
					enquiryDaoResponse.setAvailableAmount(Long.valueOf(rs.getString("availableLimit")));
					enquiryDaoResponse.setIncreaseAmount(Long.valueOf(rs.getString("eligibleLimit")));

					enquiryDaoResponse.setIncreasePer(0.5f);
				}

			} else if (CreditLimitEnquiryErrorEnum.checkErrorCode(dbRespCode, "data error")) {
				throw new BusinessException(dbRespCode, dbRespMsg);
			} else {
				throw new SystemException(dbRespCode, dbRespMsg);
			}
		} catch (BusinessException be) {
			throw be;
		} catch (SystemException se) {
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException("8888", "unknown error fron Database");
		}

		System.out.println("exit from Dao");
		return enquiryDaoResponse;
	}
*/
}
