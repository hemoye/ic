package com.jsu.ic.vo;

import java.sql.Timestamp;

import com.jsu.ic.annotation.PO2VO;

/**
 * 实体User的表现层对象
 * 
 * @author hadoop
 * 
 */
@PO2VO({ "userinfo", "userrole" })
public class UserVO {

	private Integer userId;
	private String userName;
	private String userPwd;
	private String userHead;
	private String userEmail;
	private String userTel;
	private Timestamp frostTime;
	private Integer frostLength;
	private Integer status;
	private Boolean isDelete;
	private Integer sortNumber;

	private UserroleVO userroleVO;
	private UserinfoVO userinfoVO;

	public UserVO() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public String getUserEmail() {
		return userEmail == null ? "未填写" : userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public Timestamp getFrostTime() {
		return frostTime;
	}

	public void setFrostTime(Timestamp frostTime) {
		this.frostTime = frostTime;
	}

	public Integer getFrostLength() {
		return frostLength;
	}

	public void setFrostLength(Integer frostLength) {
		this.frostLength = frostLength;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public UserroleVO getUserroleVO() {
		return userroleVO;
	}

	public void setUserroleVO(UserroleVO userroleVO) {
		this.userroleVO = userroleVO;
	}

	public UserinfoVO getUserinfoVO() {
		return userinfoVO;
	}

	public void setUserinfoVO(UserinfoVO userinfoVO) {
		this.userinfoVO = userinfoVO;
	}

}
