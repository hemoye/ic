package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Userrole entity. @author MyEclipse Persistence Tools
 */

public class Userrole  implements java.io.Serializable {


    // Fields    

     private Integer roleId;
     private String roleName;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;
     private Set powers = new HashSet(0);
     private Set users = new HashSet(0);


    // Constructors

    /** default constructor */
    public Userrole() {
    }

	/** minimal constructor */
    public Userrole(String roleName, Timestamp addTime, Timestamp updateTime) {
        this.roleName = roleName;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Userrole(String roleName, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber, Set powers, Set users) {
        this.roleName = roleName;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
        this.powers = powers;
        this.users = users;
    }

   
    // Property accessors

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Set getPowers() {
        return this.powers;
    }
    
    public void setPowers(Set powers) {
        this.powers = powers;
    }

    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }
   








}