package com.maxis.helper;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.maxis.common.DailyReportBean;

public interface DailyReporDataHelper {

	public HSSFWorkbook createDataFormExcel(List<DailyReportBean> dataList);
	public boolean placeReport(HSSFWorkbook workBook,String fileName);
}
