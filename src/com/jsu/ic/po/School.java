package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private Integer schoolId;
	private School school;
	private County county;
	private String schoolName;
	private Integer departNum;
	private Integer stuNum;
	private Timestamp addTime;
	private Timestamp updateTime;
	private Boolean isDelete;
	private Integer sortNumber;
	private Set departs = new HashSet(0);
	private Set schools = new HashSet(0);

	// Constructors

	/** default constructor */
	public School() {
	}

	/** minimal constructor */
	public School(String schoolName, Integer departNum, Integer stuNum, Timestamp addTime, Timestamp updateTime,
			Boolean isDelete, Integer sortNumber) {
		this.schoolName = schoolName;
		this.departNum = departNum;
		this.stuNum = stuNum;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	/** full constructor */
	public School(School school, County county, String schoolName, Integer departNum, Integer stuNum, Timestamp addTime,
			Timestamp updateTime, Boolean isDelete, Integer sortNumber, Set departs, Set schools) {
		this.school = school;
		this.county = county;
		this.schoolName = schoolName;
		this.departNum = departNum;
		this.stuNum = stuNum;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
		this.departs = departs;
		this.schools = schools;
	}

	// Property accessors

	public Integer getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public County getCounty() {
		return this.county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Integer getDepartNum() {
		return this.departNum;
	}

	public void setDepartNum(Integer departNum) {
		this.departNum = departNum;
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

	public Set getDeparts() {
		return this.departs;
	}

	public void setDeparts(Set departs) {
		this.departs = departs;
	}

	public Set getSchools() {
		return this.schools;
	}

	public void setSchools(Set schools) {
		this.schools = schools;
	}

}