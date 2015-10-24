package com.jsu.ic.po;

import java.sql.Timestamp;

/**
 * Userrelation entity. @author MyEclipse Persistence Tools
 */

public class Userrelation implements java.io.Serializable {

	// Fields

	private Integer relationId;
	private Userinfo userinfoByUserIdA;
	private Userinfo userinfoByUserIdB;
	private String userName;
	private Timestamp addTime;
	private Timestamp updateTime;
	private Boolean isDelete;
	private Integer sortNumber;

	// Constructors

	/** default constructor */
	public Userrelation() {
	}

	/** minimal constructor */
	public Userrelation(Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber) {
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	/** full constructor */
	public Userrelation(Userinfo userinfoByUserIdA, Userinfo userinfoByUserIdB, String userName, Timestamp addTime,
			Timestamp updateTime, Boolean isDelete, Integer sortNumber) {
		this.userinfoByUserIdA = userinfoByUserIdA;
		this.userinfoByUserIdB = userinfoByUserIdB;
		this.userName = userName;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	// Property accessors

	public Integer getRelationId() {
		return this.relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	public Userinfo getUserinfoByUserIdA() {
		return this.userinfoByUserIdA;
	}

	public void setUserinfoByUserIdA(Userinfo userinfoByUserIdA) {
		this.userinfoByUserIdA = userinfoByUserIdA;
	}

	public Userinfo getUserinfoByUserIdB() {
		return this.userinfoByUserIdB;
	}

	public void setUserinfoByUserIdB(Userinfo userinfoByUserIdB) {
		this.userinfoByUserIdB = userinfoByUserIdB;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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