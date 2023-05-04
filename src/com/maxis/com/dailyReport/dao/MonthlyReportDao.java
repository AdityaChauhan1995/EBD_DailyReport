package com.maxis.com.dailyReport.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.maxis.common.CustExpRptBean;

@Repository
public interface MonthlyReportDao {
	public List<CustExpRptBean> getMonthlyReport();

}
