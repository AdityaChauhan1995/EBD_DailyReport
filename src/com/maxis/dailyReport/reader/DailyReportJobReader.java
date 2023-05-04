package com.maxis.dailyReport.reader;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.maxis.common.DailyReportBean;
import com.maxis.helper.DailyReportHelper;

public class DailyReportJobReader implements ItemReader<List <DailyReportBean>> {
	@Autowired
	DailyReportHelper dailyReportHelper;
	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");
	int read=0;
	@Override
	public List<DailyReportBean> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		
		if (read <= 0) {
			ebdLogger.info("Inside DailyReport Reader ");
			read++;
			List<DailyReportBean> dailyReportList = null;
			dailyReportList = dailyReportHelper.getDailyReport();

			return dailyReportList;
		} else {
			return null;
		}
	}



}