package com.jsu.ic.po;

import java.sql.Timestamp;

/**
 * Syslog entity. @author MyEclipse Persistence Tools
 */

public class Syslog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Userinfo userinfo;
	private String logName;
	private String logTxt;
	private Timestamp logTime;
	private String logIp;
	private Boolean isSuccess;
	private Integer sortNumber;

	// Constructors

	/** default constructor */
	public Syslog() {
	}

	/** minimal constructor */
	public Syslog(String logTxt, Timestamp logTime, String logIp) {
		this.logTxt = logTxt;
		this.logTime = logTime;
		this.logIp = logIp;
	}

	/** full constructor */
	public Syslog(Userinfo userinfo, String logName, String logTxt, Timestamp logTime, String logIp, Boolean isSuccess,
			Integer sortNumber) {
		this.userinfo = userinfo;
		this.logName = logName;
		this.logTxt = logTxt;
		this.logTime = logTime;
		this.logIp = logIp;
		this.isSuccess = isSuccess;
		this.sortNumber = sortNumber;
	}

	// Property accessors

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getLogName() {
		return this.logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getLogTxt() {
		return this.logTxt;
	}

	public void setLogTxt(String logTxt) {
		this.logTxt = logTxt;
	}

	public Timestamp getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}

	public String getLogIp() {
		return this.logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public Boolean getIsSuccess() {
		return this.isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Integer getSortNumber() {
		return this.sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

}