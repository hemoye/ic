package com.jsu.ic.po;

import java.util.HashSet;
import java.util.Set;

/**
 * County entity. @author MyEclipse Persistence Tools
 */

public class County implements java.io.Serializable {

	// Fields

	private Integer countyId;
	private City city;
	private String countyName;
	private Boolean isDelete;
	private Integer sortNumber;
	private Set userinfos = new HashSet(0);
	private Set schools = new HashSet(0);

	// Constructors

	/** default constructor */
	public County() {
	}

	/** minimal constructor */
	public County(String countyName, Boolean isDelete, Integer sortNumber) {
		this.countyName = countyName;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	/** full constructor */
	public County(City city, String countyName, Boolean isDelete, Integer sortNumber, Set userinfos, Set schools) {
		this.city = city;
		this.countyName = countyName;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
		this.userinfos = userinfos;
		this.schools = schools;
	}

	// Property accessors

	public Integer getCountyId() {
		return this.countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getCountyName() {
		return this.countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
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

	public Set getSchools() {
		return this.schools;
	}

	public void setSchools(Set schools) {
		this.schools = schools;
	}

}