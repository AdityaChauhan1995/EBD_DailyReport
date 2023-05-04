package com.maxis.com.query.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maxis.common.CustExpRptBean;

public class MonthlyReportDataForExcelMapper implements RowMapper<CustExpRptBean>{

	
	@Override
	public CustExpRptBean mapRow(ResultSet rs, int paramInt)
			throws SQLException {

		CustExpRptBean bean = new CustExpRptBean();
		if(rs!=null)
		{
			bean.setRegId(rs.getString("RegId"));
			bean.setRegStatus(rs.getString("RegStatus"));
			bean.setDateCreated(rs.getString("dateCreated"));
			bean.setRatePlanName(rs.getString("RatePlanName"));
			bean.setMonth(rs.getString("Month"));
			bean.setYear(rs.getString("Year"));
			bean.setCompanyName(rs.getString("COMPANY_NAME"));
			bean.setBrnNo(rs.getString("CUST_BRN_NO"));
			bean.setMEScount(rs.getString("MESCOUNT"));
			bean.setDiffStatus(rs.getString("DATEDIFF"));
			bean.setFromStatus(rs.getString("FROM_STATUS"));
			bean.setToStatus(rs.getString("TO_STATUS"));
			
		}
		return bean;
	}



}
