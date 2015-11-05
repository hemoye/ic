package com.jsu.ic.vo;

import java.sql.Timestamp;

import com.jsu.ic.commons.Const;

public class UserinfoVO {

	private Integer userId;
	private UserofficeVO userofficeVO;
	private RealinfoVO realinfoVO;
	private String realName;
	private String userSex;
	private Timestamp birthday;
	private Timestamp registTime;
	private String signature;
	private Integer loginNumber;
	private Timestamp loginTime;
	private String theme;
	private String pagebuider;
	private String pageanimation;
	private String bstyle;
	private String bcolor;
	private Boolean isDelete;
	private Integer sortNumber;

	public UserinfoVO() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public UserofficeVO getUserofficeVO() {
		return userofficeVO;
	}

	public void setUserofficeVO(UserofficeVO userofficeVO) {
		this.userofficeVO = userofficeVO;
	}

	public String getOfficeName() {
		return userofficeVO == null ? "未选择" : userofficeVO.getOfficeName();
	}

	public RealinfoVO getRealinfoVO() {
		return realinfoVO;
	}

	public void setRealinfoVO(RealinfoVO realinfoVO) {
		this.realinfoVO = realinfoVO;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Timestamp getRegistTime() {
		return registTime;
	}

	public String getRegist() {
		return Const.dateToString(registTime);
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getLoginNumber() {
		return loginNumber;
	}

	public void setLoginNumber(Integer loginNumber) {
		this.loginNumber = loginNumber;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getPagebuider() {
		return pagebuider;
	}

	public void setPagebuider(String pagebuider) {
		this.pagebuider = pagebuider;
	}

	public String getPageanimation() {
		return pageanimation;
	}

	public void setPageanimation(String pageanimation) {
		this.pageanimation = pageanimation;
	}

	public String getBstyle() {
		return bstyle;
	}

	public void setBstyle(String bstyle) {
		this.bstyle = bstyle;
	}

	public String getBcolor() {
		return bcolor;
	}

	public void setBcolor(String bcolor) {
		this.bcolor = bcolor;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}
	
}
