package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Userrole userrole;
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
	private Set messagesForUserIdB = new HashSet(0);
	private Set messagesForUserIdA = new HashSet(0);
	private Userinfo userinfo;

	// Constructors

	/** default constructor */
	public User() {
	}
	
	public User(Integer userId) {
		this.userId = userId;
	}

	/** minimal constructor */
	public User(String userName, String userPwd, Timestamp frostTime, Boolean isDelete, Integer sortNumber) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.frostTime = frostTime;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	/** full constructor */
	public User(Userrole userrole, String userName, String userPwd, String userHead, String userEmail, String userTel,
			Timestamp frostTime, Integer frostLength, Integer status, Boolean isDelete, Integer sortNumber,
			Set messagesForUserIdB, Set messagesForUserIdA, Userinfo userinfo) {
		this.userrole = userrole;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userHead = userHead;
		this.userEmail = userEmail;
		this.userTel = userTel;
		this.frostTime = frostTime;
		this.frostLength = frostLength;
		this.status = status;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
		this.messagesForUserIdB = messagesForUserIdB;
		this.messagesForUserIdA = messagesForUserIdA;
		this.userinfo = userinfo;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Userrole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserHead() {
		return this.userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public Timestamp getFrostTime() {
		return this.frostTime;
	}

	public void setFrostTime(Timestamp frostTime) {
		this.frostTime = frostTime;
	}

	public Integer getFrostLength() {
		return this.frostLength;
	}

	public void setFrostLength(Integer frostLength) {
		this.frostLength = frostLength;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Set getMessagesForUserIdB() {
		return this.messagesForUserIdB;
	}

	public void setMessagesForUserIdB(Set messagesForUserIdB) {
		this.messagesForUserIdB = messagesForUserIdB;
	}

	public Set getMessagesForUserIdA() {
		return this.messagesForUserIdA;
	}

	public void setMessagesForUserIdA(Set messagesForUserIdA) {
		this.messagesForUserIdA = messagesForUserIdA;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

}