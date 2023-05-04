package com.maxis.helper.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.maxis.com.dailyReport.dao.DailyReportDao;
import com.maxis.common.DailyReportBean;
import com.maxis.helper.DailyReportHelper;

public class DailyReportHelperImpl implements DailyReportHelper{
	@Autowired
	DailyReportDao dailyReportDao;
	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");
	@Override
	public List<DailyReportBean> getDailyReport() {
		return dailyReportDao.getDailyReport();
	}
	
	
}