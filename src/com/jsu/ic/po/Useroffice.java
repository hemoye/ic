package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Useroffice entity. @author MyEclipse Persistence Tools
 */

public class Useroffice  implements java.io.Serializable {


    // Fields    

     private Integer officeId;
     private String officeName;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;
     private Set userinfos = new HashSet(0);


    // Constructors

    /** default constructor */
    public Useroffice() {
    }

	/** minimal constructor */
    public Useroffice(String officeName, Timestamp addTime, Timestamp updateTime) {
        this.officeName = officeName;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Useroffice(String officeName, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber, Set userinfos) {
        this.officeName = officeName;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
        this.userinfos = userinfos;
    }

   
    // Property accessors

    public Integer getOfficeId() {
        return this.officeId;
    }
    
    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return this.officeName;
    }
    
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
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