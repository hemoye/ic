package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Depart entity. @author MyEclipse Persistence Tools
 */

public class Depart  implements java.io.Serializable {


    // Fields    

     private Integer departId;
     private School school;
     private String departName;
     private Integer classNum;
     private Integer stuNum;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;
     private Set clazzs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Depart() {
    }

	/** minimal constructor */
    public Depart(String departName, Timestamp addTime, Timestamp updateTime) {
        this.departName = departName;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Depart(School school, String departName, Integer classNum, Integer stuNum, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber, Set clazzs) {
        this.school = school;
        this.departName = departName;
        this.classNum = classNum;
        this.stuNum = stuNum;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
        this.clazzs = clazzs;
    }

   
    // Property accessors

    public Integer getDepartId() {
        return this.departId;
    }
    
    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public School getSchool() {
        return this.school;
    }
    
    public void setSchool(School school) {
        this.school = school;
    }

    public String getDepartName() {
        return this.departName;
    }
    
    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public Integer getClassNum() {
        return this.classNum;
    }
    
    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public Integer getStuNum() {
        return this.stuNum;
    }
    
    public void setStuNum(Integer stuNum) {
        this.stuNum = stuNum;
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

    public Set getClazzs() {
        return this.clazzs;
    }
    
    public void setClazzs(Set clazzs) {
        this.clazzs = clazzs;
    }
   








}