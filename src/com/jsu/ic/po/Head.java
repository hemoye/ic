package com.jsu.ic.po;

import java.sql.Timestamp;


/**
 * Head entity. @author MyEclipse Persistence Tools
 */

public class Head  implements java.io.Serializable {


    // Fields    

     private Integer headId;
     private String headUrl;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;


    // Constructors

    /** default constructor */
    public Head() {
    }

	/** minimal constructor */
    public Head(String headUrl, Timestamp addTime, Timestamp updateTime) {
        this.headUrl = headUrl;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Head(String headUrl, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber) {
        this.headUrl = headUrl;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
    }

   
    // Property accessors

    public Integer getHeadId() {
        return this.headId;
    }
    
    public void setHeadId(Integer headId) {
        this.headId = headId;
    }

    public String getHeadUrl() {
        return this.headUrl;
    }
    
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
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