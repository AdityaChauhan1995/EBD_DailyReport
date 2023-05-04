package com.maxis.helper.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.maxis.com.dailyReport.dao.MonthlyReportDao;
import com.maxis.common.CustExpRptBean;
import com.maxis.helper.CustExpRptHelper;

public class CustExpReportHelperImpl implements CustExpRptHelper{
	@Autowired
	MonthlyReportDao monthlyReportDao;
	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");
	@Override
	public List<CustExpRptBean> getExpReport() {
		return monthlyReportDao.getMonthlyReport();
	}
	
	
}
