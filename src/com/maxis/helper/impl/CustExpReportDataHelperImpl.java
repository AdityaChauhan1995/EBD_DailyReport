package com.maxis.helper.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.maxis.common.ConfigurationManager;
import com.maxis.common.Constants;
import com.maxis.common.CustExpRptBean;
import com.maxis.helper.CustExpRptDataHelper;

public class CustExpReportDataHelperImpl  implements CustExpRptDataHelper {
	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");

	@Override
	public HSSFWorkbook createDataFormExcel(List<CustExpRptBean> dataList) {
		// TODO Auto-generated method stub
		
		HSSFWorkbook workBook = new HSSFWorkbook();
		
		try{
		
			ebdLogger.info("Creating Excel Sheet");
		 HSSFSheet sheet = workBook.createSheet("Customer Experience Report");
		 HSSFRow rowhead = sheet.createRow((int) 0);
		 rowhead.createCell((int) 0).setCellValue("REG ID");
		 rowhead.createCell((int) 1).setCellValue("REG STATUS");
		 rowhead.createCell((int) 2).setCellValue("DATE CREATED");
		 rowhead.createCell((int) 3).setCellValue("RATEPLAN");
		 rowhead.createCell((int) 4).setCellValue("MONTH");
		 rowhead.createCell((int) 5).setCellValue("YEAR");
		 rowhead.createCell((int) 6).setCellValue("COMPANY NAME");
		 rowhead.createCell((int) 7).setCellValue("BRN");
		 rowhead.createCell((int) 8).setCellValue("MES COUNT");
		 rowhead.createCell((int) 9).setCellValue("TIME TAKEN IN DAYS");
		 rowhead.createCell((int) 10).setCellValue("FROM STATUS");
		 rowhead.createCell((int) 11).setCellValue("TO STATUS");
		 int index = 1;
		 for(CustExpRptBean getDataForExcel:dataList)
			{	
			 HSSFRow row = sheet.createRow((int) index);
			 ebdLogger.info(getDataForExcel.getRegId());
			 row.createCell((int) 0).setCellValue(getDataForExcel.getRegId());
			 ebdLogger.info(getDataForExcel.getRegStatus());
			 row.createCell((int) 1).setCellValue(getDataForExcel.getRegStatus());
			 ebdLogger.info(getDataForExcel.getDateCreated());
			 row.createCell((int) 2).setCellValue(getDataForExcel.getDateCreated());
			 ebdLogger.info(getDataForExcel.getRatePlanName());
			 row.createCell((int) 3).setCellValue(getDataForExcel.getRatePlanName());
			 ebdLogger.info(getDataForExcel.getMonth());
			 row.createCell((int) 4).setCellValue(getDataForExcel.getMonth());
			 ebdLogger.info(getDataForExcel.getYear());
			 row.createCell((int) 5).setCellValue(getDataForExcel.getYear());
			 ebdLogger.info(getDataForExcel.getCompanyName());
			 row.createCell((int) 6).setCellValue(getDataForExcel.getCompanyName());
			 ebdLogger.info(getDataForExcel.getBrnNo());
			 row.createCell((int) 7).setCellValue(getDataForExcel.getBrnNo());
			 row.createCell((int) 8).setCellValue(getDataForExcel.getMEScount());
			 row.createCell((int) 9).setCellValue(getDataForExcel.getDiffStatus());
			 row.createCell((int) 10).setCellValue(getDataForExcel.getFromStatus());
			 row.createCell((int) 11).setCellValue(getDataForExcel.getToStatus());
			 index++;
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return workBook;
	}
	
	public boolean placeDailyReport(HSSFWorkbook workBook,String fileName) {
		// TODO Auto-generated method stub
				FileOutputStream fout=null;
				
				boolean fileMoved=false;
				try {
					
					String monthlyRptDrive=ConfigurationManager.getProperty(Constants.MONTHLY_RPT_MAP_DRIVE);
					String monthlyRptUnmapDrive=ConfigurationManager.getProperty(Constants.MONTHLY_RPT_UNMAP_DRIVE);
					String monthlyReportSharedLocation=ConfigurationManager.getProperty(Constants.MONTHLY_REPORT_SHAREDLOCATION_DIRECTORY)+fileName;
					 ByteArrayOutputStream baos = new ByteArrayOutputStream();
					 String[] array = { "cmd.exe", "/c", "start", monthlyRptDrive, "exit" };
					 try{
						 mapDailyRpt(array);
						
					 }catch (InterruptedException e) {
							e.printStackTrace();
							ebdLogger.info(e.getMessage());
						}
						catch (IOException e) {
							ebdLogger.info("IOException occurred during local drive mapping:"+e);
						}
						try {
							Thread.sleep(10000);
						}
						catch(InterruptedException ie) {
							Thread.currentThread().interrupt();
						}
					try{
						fout = new FileOutputStream(monthlyReportSharedLocation);
						writeTofile( workBook, baos, fout);
						}catch(IOException ex)
						{
							ebdLogger.info("Error while writing file "+ex.getLocalizedMessage());
						}
						try { 
							String[] array2 = { "cmd.exe", "/c", "start", monthlyRptUnmapDrive};
							unMapDailyRpt(array2);
							try {
								Thread.sleep(1000);
							}
							catch(InterruptedException ie) {
								Thread.currentThread().interrupt();
							}
						}
						catch (InterruptedException e) {
							e.printStackTrace();
							ebdLogger.info(e.getMessage());
						}
						catch (IOException e) {
							e.printStackTrace();
							ebdLogger.info(e.getMessage());
						}

					 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ebdLogger.info(e.getMessage());
				}
				
				return fileMoved;
	}

	private void writeTofile(HSSFWorkbook workBook,ByteArrayOutputStream baos,FileOutputStream fout) throws IOException {
		workBook.write(baos);
		 byte [] bytes =baos.toByteArray();
		fout.write(bytes);
		ebdLogger.info("Customer Experience Report is moved to shared Location successfully!");
		fout.close();
	}
	private void mapDailyRpt(String[] array) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 Process proc = Runtime.getRuntime().exec(array);
			  proc.waitFor();
			ebdLogger.info("Mapping to local drive: " );
		
	}


	private void unMapDailyRpt(String[] array2) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Process proc = Runtime.getRuntime().exec(array2);
		  proc.waitFor();
		ebdLogger.info("Unmapping local drive: ");
	
	}


}
