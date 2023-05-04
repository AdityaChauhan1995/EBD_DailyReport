package com.maxis.dailyReport.writer;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.batch.item.ItemWriter;

public class DailyReportJobProcessorWriter implements ItemWriter<HSSFWorkbook> {

	@Override
	public void write(List<? extends HSSFWorkbook> hssworkBook) throws Exception {
		
	}
}
