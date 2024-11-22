/*@Copyright 2023,All rights reserved,Tesco bank Pvt ltd,we should not disclose the information outside
 * otherwise terms and conditions will apply
 */
package com.tesco.enquiry.intg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;
import com.tesco.enquiry.util.CreditLimitEnquiryConstant;
import com.tesco.enquiry.util.CreditLimitEnquiryErrorEnum;

/**
 * @author Manju at 22-Nov-2024 Description:this class will be used
 *
 */
@Component
public class CreditLimitEnquiryDaoSpringJdbcDaoImpl extends StoredProcedure
		implements ICreditLimitEnquiryDao, RowMapper<EnquiryDaoResponse> {
	public CreditLimitEnquiryDaoSpringJdbcDaoImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, CreditLimitEnquiryConstant.SP_NAME);
		registerParams();

	}

	/**
	 * 
	 */
	private void registerParams() {
		// register input params
		declareParameter(new SqlParameter(CreditLimitEnquiryConstant.CLIENT_ID_IN, Types.VARCHAR));
		declareParameter(new SqlParameter(CreditLimitEnquiryConstant.CHANNEL_ID_IN, Types.VARCHAR));
		declareParameter(new SqlParameter(CreditLimitEnquiryConstant.PROMOCODE_IN, Types.VARCHAR));
		// register output params
		declareParameter(new SqlOutParameter(CreditLimitEnquiryConstant.RESPCODE_OUT, Types.VARCHAR));
		declareParameter(new SqlOutParameter(CreditLimitEnquiryConstant.RESPMSG_OUT, Types.VARCHAR));
		// register resultset
		declareParameter(new SqlReturnResultSet(CreditLimitEnquiryConstant.RESULTSET_NAME, this));

	}

	@Override
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) throws BusinessException, SystemException {
		// prepare stored procedure request
		System.out.println("entered into spring jdbc" + enquiryDaoRequest);
		EnquiryDaoResponse enquiryDaoResponse = new EnquiryDaoResponse();
		try {
			Map<String, Object> requestMap = new HashMap<String, Object>();
			requestMap.put(CreditLimitEnquiryConstant.CLIENT_ID_IN, enquiryDaoRequest.getClientId());
			requestMap.put(CreditLimitEnquiryConstant.CHANNEL_ID_IN, enquiryDaoRequest.getChannelId());
			requestMap.put(CreditLimitEnquiryConstant.PROMOCODE_IN, enquiryDaoRequest.getPromoCode());

			Map<String, Object> reqMap = super.execute(requestMap);
			String dbRespCode = reqMap.get(CreditLimitEnquiryConstant.RESPCODE_OUT).toString();
			String dbRespMsg = reqMap.get(CreditLimitEnquiryConstant.RESPMSG_OUT).toString();

			if (CreditLimitEnquiryConstant.ZERO.equals(dbRespCode)) {
				// prepare the dao response with the help of result set

				List<EnquiryDaoResponse> daoResp = (List<EnquiryDaoResponse>) reqMap
						.get(CreditLimitEnquiryConstant.RESULTSET_NAME);
				enquiryDaoResponse = daoResp.get(0);
				enquiryDaoResponse.setRespCode(dbRespCode);
				enquiryDaoResponse.setRespMsg(dbRespMsg);
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

		System.out.println("enquiry dao response in dao impl is" + enquiryDaoResponse);

		return enquiryDaoResponse;
	}

	@Override
	public EnquiryDaoResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("entered into map row");
		EnquiryDaoResponse enquiryDaoResponse = new EnquiryDaoResponse();

		enquiryDaoResponse.setCardnum(rs.getString("cardnum"));
		enquiryDaoResponse.setCvv(rs.getString("cvv"));
		enquiryDaoResponse.setExpdate(rs.getString("expdate"));
		enquiryDaoResponse.setNameoncard(rs.getString("nameoncard"));
		enquiryDaoResponse.setAvailableAmount(Long.valueOf(rs.getString("availableLimit")));
		enquiryDaoResponse.setIncreaseAmount(Long.valueOf(rs.getString("eligibleLimit")));
		enquiryDaoResponse.setIncreasePer(0.5f);
		System.out.println("exited from map row" + enquiryDaoResponse);
		return enquiryDaoResponse;
	}

}
