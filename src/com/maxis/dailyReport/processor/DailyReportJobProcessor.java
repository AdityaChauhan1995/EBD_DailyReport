package com.maxis.dailyReport.processor;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.maxis.common.ConfigurationManager;
import com.maxis.common.Constants;
import com.maxis.common.DailyReportBean;
import com.maxis.helper.DailyReporDataHelper;
import com.maxis.helper.DailyReportHelper;

public class DailyReportJobProcessor implements ItemProcessor<List<DailyReportBean>, HSSFWorkbook> {
	@Autowired
	DailyReportHelper dailyReportHelper;
	@Autowired
	DailyReporDataHelper dailyReportDataHelper;

	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");

	@Override
	public HSSFWorkbook process(List<DailyReportBean> dailyReport) throws Exception {
		
		// TODO Auto-generated method stub
	try{
		if(!dailyReport.isEmpty())
		{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		ebdLogger.info("Inside Processor Going to create excel");
		SimpleDateFormat dateform = new SimpleDateFormat("ddMMyyyy");
		String strDate = dateform.format(new Date());  
		ebdLogger.info("Creating excel with records "+dailyReport.size());
		HSSFWorkbook workbook=null;
		workbook= dailyReportDataHelper.createDataFormExcel(dailyReport);
		
		String filename = MessageFormat.format(ConfigurationManager.getProperty(Constants.FILE_NAME), new Object[] {strDate}) ;
		dailyReportDataHelper.placeReport(workbook, filename+".xls");
		}else{
			ebdLogger.info("No Data To send Records found 0");
		}
		}catch(Exception e){
		ebdLogger.error("Exception While Sending email ");
		ebdLogger.error(e.getLocalizedMessage());
		ebdLogger.error(e.getStackTrace());
		e.printStackTrace();
	}
		return null;
	}

	

}
