package com.jsu.ic.po;

import java.util.HashSet;
import java.util.Set;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private Province province;
	private String cityName;
	private Boolean isDelete;
	private Integer sortNumber;
	private Set counties = new HashSet(0);

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(String cityName, Boolean isDelete, Integer sortNumber) {
		this.cityName = cityName;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	/** full constructor */
	public City(Province province, String cityName, Boolean isDelete, Integer sortNumber, Set counties) {
		this.province = province;
		this.cityName = cityName;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
		this.counties = counties;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public Set getCounties() {
		return this.counties;
	}

	public void setCounties(Set counties) {
		this.counties = counties;
	}

}