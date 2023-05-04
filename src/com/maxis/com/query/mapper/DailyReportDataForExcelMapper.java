package com.maxis.com.query.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.maxis.common.DailyReportBean;


public class DailyReportDataForExcelMapper implements RowMapper<DailyReportBean>{

	
	@Override
	public DailyReportBean mapRow(ResultSet rs, int paramInt)
			throws SQLException {
		// TODO Auto-generated method stub
		DailyReportBean bean = new DailyReportBean();
		if(rs!=null)
		{
			bean.setRegId(rs.getString("RegId"));
			bean.setRegStatus(rs.getString("RegStatus"));
			bean.setDateCreated(rs.getString("dateCreated"));
			bean.setRatePlanName(rs.getString("RatePlanName"));
			bean.setMonth(rs.getString("Month"));
			bean.setYear(rs.getString("Year"));
			bean.setMicrosoftPackage(rs.getString("MicrosoftPackage"));
			bean.setCompanyName(rs.getString("COMPANY_NAME"));
			bean.setBrnNo(rs.getString("CUST_BRN_NO"));
			
		}
		return bean;
	}

}
