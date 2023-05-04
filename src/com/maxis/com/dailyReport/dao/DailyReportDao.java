package com.maxis.com.dailyReport.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.maxis.common.DailyReportBean;
@Repository
public interface DailyReportDao {

	public List<DailyReportBean> getDailyReport();

}
