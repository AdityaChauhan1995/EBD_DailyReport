package com.maxis.common;

public class CustExpRptBean {
	
	private String regId;
	private String regStatus;
	private String dateCreated;
	private String ratePlanName;
	private String month;
	private String year;
	private String companyName;
	private String BrnNo;
	private String MEScount;
	private String fromStatus;
	private String toStatus;
	private String diffStatus;
	
	
	public String getMEScount() {
		return MEScount;
	}
	public void setMEScount(String mEScount) {
		MEScount = mEScount;
	}
	public String getFromStatus() {
		return fromStatus;
	}
	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}
	public String getToStatus() {
		return toStatus;
	}
	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}
	public String getDiffStatus() {
		return diffStatus;
	}
	public void setDiffStatus(String diffStatus) {
		this.diffStatus = diffStatus;
	}

	
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getRegStatus() {
		return regStatus;
	}
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getRatePlanName() {
		return ratePlanName;
	}
	public void setRatePlanName(String ratePlanName) {
		this.ratePlanName = ratePlanName;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBrnNo() {
		return BrnNo;
	}
	public void setBrnNo(String brnNo) {
		BrnNo = brnNo;
	}
	

}
