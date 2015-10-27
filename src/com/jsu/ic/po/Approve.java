package com.jsu.ic.po;

import java.sql.Timestamp;


/**
 * Approve entity. @author MyEclipse Persistence Tools
 */

public class Approve  implements java.io.Serializable {


    // Fields    

     private Integer approveId;
     private Clazz clazz;
     private Userinfo userinfo;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;


    // Constructors

    /** default constructor */
    public Approve() {
    }

	/** minimal constructor */
    public Approve(Timestamp addTime, Timestamp updateTime) {
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Approve(Clazz clazz, Userinfo userinfo, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber) {
        this.clazz = clazz;
        this.userinfo = userinfo;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
    }

   
    // Property accessors

    public Integer getApproveId() {
        return this.approveId;
    }
    
    public void setApproveId(Integer approveId) {
        this.approveId = approveId;
    }

    public Clazz getClazz() {
        return this.clazz;
    }
    
    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Userinfo getUserinfo() {
        return this.userinfo;
    }
    
    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public Timestamp getAddTime() {
        return this.addTime;
    }
    
    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
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