package com.maxis.custExpReport.processor;

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
import com.maxis.common.CustExpRptBean;
import com.maxis.helper.CustExpRptHelper;
import com.maxis.helper.CustExpRptDataHelper;

public class CustExpReportJobProcessor implements ItemProcessor<List<CustExpRptBean>, HSSFWorkbook> {
	@Autowired
	CustExpRptHelper custExpRptHelper;
	@Autowired
	CustExpRptDataHelper custExpRptDataHelper;

	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");

	@Override
	public HSSFWorkbook process(List<CustExpRptBean> custExpRpt) throws Exception {
		
		// TODO Auto-generated method stub
	try{
		if(!custExpRpt.isEmpty())
		{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		ebdLogger.info("Inside Processor Going to create excel");
		SimpleDateFormat dateform = new SimpleDateFormat("ddMMyyyy");
		String strDate = dateform.format(new Date());  
		ebdLogger.info("Creating excel with records "+custExpRpt.size());
		HSSFWorkbook workbook=null;
		workbook= custExpRptDataHelper.createDataFormExcel(custExpRpt);
		
		String filename = MessageFormat.format(ConfigurationManager.getProperty(Constants.FILE_NAME_MONTHLY_RPT), new Object[] {strDate}) ;
		custExpRptDataHelper.placeDailyReport(workbook, filename+".xls");
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
