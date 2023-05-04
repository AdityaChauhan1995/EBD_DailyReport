package com.maxis.batch.invoker;

import org.apache.log4j.Logger;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;



public class BatchStart {

	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");
	public static void main(String args[]){


		try {
			CommandLineJobRunner.main(new String[]{"file:config/CustomerExpMonthlyRptJob.xml","custMonthlyReportJobExecution"});
			//CommandLineJobRunner.main(new String[]{"file:config/DailyReportJob.xml","dailyReportJobExecution"});
		
			
			
		} catch (Exception e) {
			
			ebdLogger.info("BatchStart: Error "+e);
		}

	}
}