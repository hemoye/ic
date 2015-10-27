package com.jsu.ic.po;

import java.sql.Timestamp;


/**
 * Attention entity. @author MyEclipse Persistence Tools
 */

public class Attention  implements java.io.Serializable {


    // Fields    

     private Integer attentionId;
     private Userinfo userinfo;
     private Userpost userpost;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;


    // Constructors

    /** default constructor */
    public Attention() {
    }

	/** minimal constructor */
    public Attention(Timestamp addTime, Timestamp updateTime) {
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Attention(Userinfo userinfo, Userpost userpost, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber) {
        this.userinfo = userinfo;
        this.userpost = userpost;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
    }

   
    // Property accessors

    public Integer getAttentionId() {
        return this.attentionId;
    }
    
    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
    }

    public Userinfo getUserinfo() {
        return this.userinfo;
    }
    
    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public Userpost getUserpost() {
        return this.userpost;
    }
    
    public void setUserpost(Userpost userpost) {
        this.userpost = userpost;
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