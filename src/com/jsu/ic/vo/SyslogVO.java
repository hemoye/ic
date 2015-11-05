package com.jsu.ic.vo;

import java.sql.Timestamp;

import com.jsu.ic.commons.Const;

public class SyslogVO {

	private Integer logId;
	private String logName;
	private String logTxt;
	private Timestamp logTime;
	private String logIp;
	private Boolean isSuccess;
	private Integer sortNumber;

	private String userName;

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getLogTxt() {
		return logTxt;
	}

	public void setLogTxt(String logTxt) {
		this.logTxt = logTxt;
	}

	public String getSysLogTime() {
		return Const.dateToString(logTime);
	}

	public Timestamp getLogTime() {
		return logTime;
	}

	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}

	public String getLogIp() {
		return logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
