package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Realinfo entity. @author MyEclipse Persistence Tools
 */

public class Realinfo  implements java.io.Serializable {


    // Fields    

     private Integer realId;
     private Clazz clazz;
     private String realName;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;
     private Set userinfos = new HashSet(0);


    // Constructors

    /** default constructor */
    public Realinfo() {
    }

	/** minimal constructor */
    public Realinfo(String realName, Timestamp addTime, Timestamp updateTime) {
        this.realName = realName;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Realinfo(Clazz clazz, String realName, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber, Set userinfos) {
        this.clazz = clazz;
        this.realName = realName;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
        this.userinfos = userinfos;
    }

   
    // Property accessors

    public Integer getRealId() {
        return this.realId;
    }
    
    public void setRealId(Integer realId) {
        this.realId = realId;
    }

    public Clazz getClazz() {
        return this.clazz;
    }
    
    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String getRealName() {
        return this.realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
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

    public Set getUserinfos() {
        return this.userinfos;
    }
    
    public void setUserinfos(Set userinfos) {
        this.userinfos = userinfos;
    }
   








}