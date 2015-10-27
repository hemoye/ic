package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Resourcetype entity. @author MyEclipse Persistence Tools
 */

public class Resourcetype  implements java.io.Serializable {


    // Fields    

     private Integer typeId;
     private String typeName;
     private String typeDesc;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;
     private Set postresources = new HashSet(0);


    // Constructors

    /** default constructor */
    public Resourcetype() {
    }

	/** minimal constructor */
    public Resourcetype(String typeName, Timestamp addTime, Timestamp updateTime) {
        this.typeName = typeName;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Resourcetype(String typeName, String typeDesc, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber, Set postresources) {
        this.typeName = typeName;
        this.typeDesc = typeDesc;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
        this.postresources = postresources;
    }

   
    // Property accessors

    public Integer getTypeId() {
        return this.typeId;
    }
    
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return this.typeDesc;
    }
    
    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
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

    public Set getPostresources() {
        return this.postresources;
    }
    
    public void setPostresources(Set postresources) {
        this.postresources = postresources;
    }
   








}