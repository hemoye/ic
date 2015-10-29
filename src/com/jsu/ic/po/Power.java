package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Power entity. @author MyEclipse Persistence Tools
 */

public class Power implements java.io.Serializable {

	// Fields

	private Integer powerId;
	private Userrole userrole;
	private Power power;
	private String icon;
	private String powerName;
	private String powerUrl;
	private String powerDesc;
	private Timestamp addTime;
	private Timestamp updateTime;
	private Boolean isDelete;
	private Integer sortNumber;
	private Set powers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Power() {
	}

	/** minimal constructor */
	public Power(String powerName, Timestamp addTime, Timestamp updateTime) {
		this.powerName = powerName;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public Power(Userrole userrole, Power power, String icon, String powerName, String powerUrl, String powerDesc,
			Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber, Set powers) {
		this.userrole = userrole;
		this.power = power;
		this.icon = icon;
		this.powerName = powerName;
		this.powerUrl = powerUrl;
		this.powerDesc = powerDesc;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
		this.powers = powers;
	}

	// Property accessors

	public Integer getPowerId() {
		return this.powerId;
	}

	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}

	public Userrole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}

	public Power getPower() {
		return this.power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPowerName() {
		return this.powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getPowerUrl() {
		return this.powerUrl;
	}

	public void setPowerUrl(String powerUrl) {
		this.powerUrl = powerUrl;
	}

	public String getPowerDesc() {
		return this.powerDesc;
	}

	public void setPowerDesc(String powerDesc) {
		this.powerDesc = powerDesc;
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

}