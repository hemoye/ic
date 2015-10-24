package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Useroffice useroffice;
	private Realinfo realinfo;
	private User user;
	private County county;
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
	private Set userposts = new HashSet(0);
	private Set applyfriendsForApplyUserId = new HashSet(0);
	private Set userrelationsForUserIdB = new HashSet(0);
	private Set keywords = new HashSet(0);
	private Set userrelationsForUserIdA = new HashSet(0);
	private Set syslogs = new HashSet(0);
	private Set replies = new HashSet(0);
	private Set applyfriendsForRecUserId = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(User user, Timestamp birthday, Timestamp registTime, Integer loginNumber, Timestamp loginTime,
			Boolean isDelete, Integer sortNumber) {
		this.user = user;
		this.birthday = birthday;
		this.registTime = registTime;
		this.loginNumber = loginNumber;
		this.loginTime = loginTime;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	/** full constructor */
	public Userinfo(Useroffice useroffice, Realinfo realinfo, User user, County county, String realName, String userSex,
			Timestamp birthday, Timestamp registTime, String signature, Integer loginNumber, Timestamp loginTime, String theme,
			String pagebuider, String pageanimation, String bstyle, String bcolor, Boolean isDelete, Integer sortNumber,
			Set userposts, Set applyfriendsForApplyUserId, Set userrelationsForUserIdB, Set keywords,
			Set userrelationsForUserIdA, Set syslogs, Set replies, Set applyfriendsForRecUserId) {
		this.useroffice = useroffice;
		this.realinfo = realinfo;
		this.user = user;
		this.county = county;
		this.realName = realName;
		this.userSex = userSex;
		this.birthday = birthday;
		this.registTime = registTime;
		this.signature = signature;
		this.loginNumber = loginNumber;
		this.loginTime = loginTime;
		this.theme = theme;
		this.pagebuider = pagebuider;
		this.pageanimation = pageanimation;
		this.bstyle = bstyle;
		this.bcolor = bcolor;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
		this.userposts = userposts;
		this.applyfriendsForApplyUserId = applyfriendsForApplyUserId;
		this.userrelationsForUserIdB = userrelationsForUserIdB;
		this.keywords = keywords;
		this.userrelationsForUserIdA = userrelationsForUserIdA;
		this.syslogs = syslogs;
		this.replies = replies;
		this.applyfriendsForRecUserId = applyfriendsForRecUserId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Useroffice getUseroffice() {
		return this.useroffice;
	}

	public void setUseroffice(Useroffice useroffice) {
		this.useroffice = useroffice;
	}

	public Realinfo getRealinfo() {
		return this.realinfo;
	}

	public void setRealinfo(Realinfo realinfo) {
		this.realinfo = realinfo;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public County getCounty() {
		return this.county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Timestamp getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getLoginNumber() {
		return this.loginNumber;
	}

	public void setLoginNumber(Integer loginNumber) {
		this.loginNumber = loginNumber;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getPagebuider() {
		return this.pagebuider;
	}

	public void setPagebuider(String pagebuider) {
		this.pagebuider = pagebuider;
	}

	public String getPageanimation() {
		return this.pageanimation;
	}

	public void setPageanimation(String pageanimation) {
		this.pageanimation = pageanimation;
	}

	public String getBstyle() {
		return this.bstyle;
	}

	public void setBstyle(String bstyle) {
		this.bstyle = bstyle;
	}

	public String getBcolor() {
		return this.bcolor;
	}

	public void setBcolor(String bcolor) {
		this.bcolor = bcolor;
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

	public Set getUserposts() {
		return this.userposts;
	}

	public void setUserposts(Set userposts) {
		this.userposts = userposts;
	}

	public Set getApplyfriendsForApplyUserId() {
		return this.applyfriendsForApplyUserId;
	}

	public void setApplyfriendsForApplyUserId(Set applyfriendsForApplyUserId) {
		this.applyfriendsForApplyUserId = applyfriendsForApplyUserId;
	}

	public Set getUserrelationsForUserIdB() {
		return this.userrelationsForUserIdB;
	}

	public void setUserrelationsForUserIdB(Set userrelationsForUserIdB) {
		this.userrelationsForUserIdB = userrelationsForUserIdB;
	}

	public Set getKeywords() {
		return this.keywords;
	}

	public void setKeywords(Set keywords) {
		this.keywords = keywords;
	}

	public Set getUserrelationsForUserIdA() {
		return this.userrelationsForUserIdA;
	}

	public void setUserrelationsForUserIdA(Set userrelationsForUserIdA) {
		this.userrelationsForUserIdA = userrelationsForUserIdA;
	}

	public Set getSyslogs() {
		return this.syslogs;
	}

	public void setSyslogs(Set syslogs) {
		this.syslogs = syslogs;
	}

	public Set getReplies() {
		return this.replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

	public Set getApplyfriendsForRecUserId() {
		return this.applyfriendsForRecUserId;
	}

	public void setApplyfriendsForRecUserId(Set applyfriendsForRecUserId) {
		this.applyfriendsForRecUserId = applyfriendsForRecUserId;
	}

}