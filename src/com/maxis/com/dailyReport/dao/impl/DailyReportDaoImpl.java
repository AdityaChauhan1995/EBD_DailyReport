package com.maxis.com.dailyReport.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.maxis.com.dailyReport.dao.DailyReportDao;
import com.maxis.com.query.mapper.DailyReportDataForExcelMapper;
import com.maxis.common.Constants;
import com.maxis.common.DBQueries;
import com.maxis.common.DailyReportBean;

public class DailyReportDaoImpl implements DailyReportDao{
	/* @Autowired */
	private JdbcTemplate jdbcTemplate;
	private static final Logger ebdLogger = Logger.getLogger("ebdLogger");

	public void setTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*private final String queryDailyReport = "select  a.trans_msid,e.task_desc as Task, a.REG_ID as RegId,f.name as RegStatus,b.date_created as dateCreated, a.rateplan_name as RatePlanName, TO_CHAR(d.created_date,'MON') as Month,TO_CHAR(d.created_date,'YYYY') as Year,g.dw_ms_package as MicrosoftPackage,c.COMPANY_NAME,b.CUST_BRN_NO " + 
											" from portal_trans_dw_attribute a, PORTAL_REGISTRATION_MASTER b ,PORTAL_CUST_INFO c,portal_trans_Task d, portal_task_master e,portal_ref_reg_status f,portal_ref_rateplan g " + 
											"  	where a.REG_ID = b.REG_ID " + 
											"    and b.CUST_ID=c.CUST_ID " + 
											"    and a.reg_id = d.reg_id " +
											"    and b.reg_status = f.reg_status " + 
											"    and a.rateplan_id = g.rateplan_id "+
											//"    and a.trans_msid = d.trans_msid " + 
											"    and e.task_id = d.task_id " + 
											"    and d.task_id = 202 "+
											"    and a.reg_id in (select reg_id from portal_trans_task " + 
											"    where upper(status)  = 'COMPLETED' " + 
											"    and task_id = 202 )" +
											"    and modified_datetime like sysdate-1) " ; /*/
	
	

	@Override
	public List<DailyReportBean> getDailyReport() {
		List <DailyReportBean> dataForExcel;
		dataForExcel = jdbcTemplate.query(DBQueries.getQueryProperties(Constants.DAILY_REPORT_FETCH_READER_DATA),new DailyReportDataForExcelMapper());

		return dataForExcel;
	}

	

}
