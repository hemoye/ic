package com.jsu.ic.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Province entity. @author MyEclipse Persistence Tools
 */

public class Province implements java.io.Serializable {

	// Fields

	private Integer provinceId;
	private String provinceName;
	private Boolean isDelete;
	private Integer sortNumber;
	private Set cities = new HashSet(0);

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** minimal constructor */
	public Province(String provinceName, Boolean isDelete, Integer sortNumber) {
		this.provinceName = provinceName;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	/** full constructor */
	public Province(String provinceName, Boolean isDelete, Integer sortNumber, Set cities) {
		this.provinceName = provinceName;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
		this.cities = cities;
	}

	// Property accessors

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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

	public Set getCities() {
		return this.cities;
	}

	public void setCities(Set cities) {
		this.cities = cities;
	}

}