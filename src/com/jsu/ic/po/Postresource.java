package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Postresource entity. @author MyEclipse Persistence Tools
 */

public class Postresource  implements java.io.Serializable {


    // Fields    

     private Integer resourceId;
     private Resourcetype resourcetype;
     private Timestamp uploadTime;
     private String resourceUrl;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;
     private Set userposts = new HashSet(0);


    // Constructors

    /** default constructor */
    public Postresource() {
    }

	/** minimal constructor */
    public Postresource(Timestamp uploadTime, String resourceUrl, Timestamp addTime, Timestamp updateTime) {
        this.uploadTime = uploadTime;
        this.resourceUrl = resourceUrl;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Postresource(Resourcetype resourcetype, Timestamp uploadTime, String resourceUrl, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber, Set userposts) {
        this.resourcetype = resourcetype;
        this.uploadTime = uploadTime;
        this.resourceUrl = resourceUrl;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
        this.userposts = userposts;
    }

   
    // Property accessors

    public Integer getResourceId() {
        return this.resourceId;
    }
    
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Resourcetype getResourcetype() {
        return this.resourcetype;
    }
    
    public void setResourcetype(Resourcetype resourcetype) {
        this.resourcetype = resourcetype;
    }

    public Timestamp getUploadTime() {
        return this.uploadTime;
    }
    
    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }
    
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
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

    public Set getUserposts() {
        return this.userposts;
    }
    
    public void setUserposts(Set userposts) {
        this.userposts = userposts;
    }
   








}