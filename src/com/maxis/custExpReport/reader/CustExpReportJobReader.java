package com.maxis.custExpReport.reader;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.maxis.common.CustExpRptBean;
import com.maxis.helper.CustExpRptHelper;

public class CustExpReportJobReader implements ItemReader<List <CustExpRptBean>> {
	@Autowired
	CustExpRptHelper custExpRpHelper;
	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");
	int read=0;
	@Override
	public List<CustExpRptBean> read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		
		if (read <= 0) {
			ebdLogger.info("Inside DailyReport Reader ");
			read++;
			List<CustExpRptBean> custExpReportList = null;
			custExpReportList = custExpRpHelper.getExpReport();

			return custExpReportList;
		} else {
			return null;
		}
	}



}
