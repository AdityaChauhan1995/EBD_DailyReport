package com.maxis.com.dailyReport.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.maxis.com.dailyReport.dao.MonthlyReportDao;
import com.maxis.com.query.mapper.MonthlyReportDataForExcelMapper;
import com.maxis.common.Constants;
import com.maxis.common.DBQueries;
import com.maxis.common.CustExpRptBean;

public class MonthlyReportDaoImpl implements MonthlyReportDao {
	private JdbcTemplate jdbcTemplate;
	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");

	public void setTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CustExpRptBean> getMonthlyReport() {
		List <CustExpRptBean> dataForExcel;
		ebdLogger.info(DBQueries.getQueryProperties(Constants.CUST_EXP_MONTHLY_REPORT_FETCH_READER_DATA));
		dataForExcel = jdbcTemplate.query(DBQueries.getQueryProperties(Constants.CUST_EXP_MONTHLY_REPORT_FETCH_READER_DATA),new MonthlyReportDataForExcelMapper());

		return dataForExcel;
	}
}
