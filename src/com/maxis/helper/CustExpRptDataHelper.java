package com.maxis.helper;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.maxis.common.CustExpRptBean;

public interface CustExpRptDataHelper {
	public HSSFWorkbook createDataFormExcel(List<CustExpRptBean> dataList);
	public boolean placeDailyReport(HSSFWorkbook workBook,String fileName);
}
