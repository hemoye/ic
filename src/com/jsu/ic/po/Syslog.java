package com.jsu.ic.po;

import java.sql.Timestamp;


/**
 * Syslog entity. @author MyEclipse Persistence Tools
 */

public class Syslog  implements java.io.Serializable {


    // Fields    

     private Integer logId;
     private Userinfo userinfo;
     private String logTxt;
     private Timestamp logTime;
     private String logIp;
     private Boolean isDelete;
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
    public Syslog(Userinfo userinfo, String logTxt, Timestamp logTime, String logIp, Boolean isDelete, Integer sortNumber) {
        this.userinfo = userinfo;
        this.logTxt = logTxt;
        this.logTime = logTime;
        this.logIp = logIp;
        this.isDelete = isDelete;
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

    public Boolean getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSortNumber() {
        return this.sortNumber;
    }
    
    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }
   








}