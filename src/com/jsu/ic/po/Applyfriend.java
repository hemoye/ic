package com.jsu.ic.po;

import java.sql.Timestamp;


/**
 * Applyfriend entity. @author MyEclipse Persistence Tools
 */

public class Applyfriend  implements java.io.Serializable {


    // Fields    

     private Integer applyId;
     private Userinfo userinfoByApplyUserId;
     private Userinfo userinfoByRecUserId;
     private String context;
     private Integer status;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;


    // Constructors

    /** default constructor */
    public Applyfriend() {
    }

	/** minimal constructor */
    public Applyfriend(Timestamp addTime, Timestamp updateTime) {
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Applyfriend(Userinfo userinfoByApplyUserId, Userinfo userinfoByRecUserId, String context, Integer status, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber) {
        this.userinfoByApplyUserId = userinfoByApplyUserId;
        this.userinfoByRecUserId = userinfoByRecUserId;
        this.context = context;
        this.status = status;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
    }

   
    // Property accessors

    public Integer getApplyId() {
        return this.applyId;
    }
    
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Userinfo getUserinfoByApplyUserId() {
        return this.userinfoByApplyUserId;
    }
    
    public void setUserinfoByApplyUserId(Userinfo userinfoByApplyUserId) {
        this.userinfoByApplyUserId = userinfoByApplyUserId;
    }

    public Userinfo getUserinfoByRecUserId() {
        return this.userinfoByRecUserId;
    }
    
    public void setUserinfoByRecUserId(Userinfo userinfoByRecUserId) {
        this.userinfoByRecUserId = userinfoByRecUserId;
    }

    public String getContext() {
        return this.context;
    }
    
    public void setContext(String context) {
        this.context = context;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
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