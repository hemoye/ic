package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Clazz entity. @author MyEclipse Persistence Tools
 */

public class Clazz  implements java.io.Serializable {


    // Fields    

     private Integer classId;
     private Depart depart;
     private String classNum;
     private Integer stuNum;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;
     private Set realinfos = new HashSet(0);
     private Set approves = new HashSet(0);


    // Constructors

    /** default constructor */
    public Clazz() {
    }

	/** minimal constructor */
    public Clazz(String classNum, Timestamp addTime, Timestamp updateTime) {
        this.classNum = classNum;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Clazz(Depart depart, String classNum, Integer stuNum, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber, Set realinfos, Set approves) {
        this.depart = depart;
        this.classNum = classNum;
        this.stuNum = stuNum;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
        this.realinfos = realinfos;
        this.approves = approves;
    }

   
    // Property accessors

    public Integer getClassId() {
        return this.classId;
    }
    
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Depart getDepart() {
        return this.depart;
    }
    
    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    public String getClassNum() {
        return this.classNum;
    }
    
    public void setClassNum(String classNum) {
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

    public Set getRealinfos() {
        return this.realinfos;
    }
    
    public void setRealinfos(Set realinfos) {
        this.realinfos = realinfos;
    }

    public Set getApproves() {
        return this.approves;
    }
    
    public void setApproves(Set approves) {
        this.approves = approves;
    }
   








}