package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Userpost entity. @author MyEclipse Persistence Tools
 */

public class Userpost implements java.io.Serializable {

	// Fields

	private Integer postId;
	private Postresource postresource;
	private Posttype posttype;
	private Userinfo userinfo;
	private String postTitle;
	private String postContext;
	private Timestamp postTime;
	private String postUrl;
	private Timestamp replyTime;
	private Integer clickNumber;
	private Integer replyNumber;
	private Boolean isDelete;
	private Integer sortNumber;
	private Set replies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userpost() {
	}

	/** minimal constructor */
	public Userpost(String postTitle, String postContext, Timestamp postTime, Timestamp replyTime, Integer clickNumber,
			Integer replyNumber, Boolean isDelete, Integer sortNumber) {
		this.postTitle = postTitle;
		this.postContext = postContext;
		this.postTime = postTime;
		this.replyTime = replyTime;
		this.clickNumber = clickNumber;
		this.replyNumber = replyNumber;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	/** full constructor */
	public Userpost(Postresource postresource, Posttype posttype, Userinfo userinfo, String postTitle, String postContext,
			Timestamp postTime, String postUrl, Timestamp replyTime, Integer clickNumber, Integer replyNumber, Boolean isDelete,
			Integer sortNumber, Set replies) {
		this.postresource = postresource;
		this.posttype = posttype;
		this.userinfo = userinfo;
		this.postTitle = postTitle;
		this.postContext = postContext;
		this.postTime = postTime;
		this.postUrl = postUrl;
		this.replyTime = replyTime;
		this.clickNumber = clickNumber;
		this.replyNumber = replyNumber;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
		this.replies = replies;
	}

	// Property accessors

	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Postresource getPostresource() {
		return this.postresource;
	}

	public void setPostresource(Postresource postresource) {
		this.postresource = postresource;
	}

	public Posttype getPosttype() {
		return this.posttype;
	}

	public void setPosttype(Posttype posttype) {
		this.posttype = posttype;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getPostTitle() {
		return this.postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContext() {
		return this.postContext;
	}

	public void setPostContext(String postContext) {
		this.postContext = postContext;
	}

	public Timestamp getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

	public String getPostUrl() {
		return this.postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public Integer getClickNumber() {
		return this.clickNumber;
	}

	public void setClickNumber(Integer clickNumber) {
		this.clickNumber = clickNumber;
	}

	public Integer getReplyNumber() {
		return this.replyNumber;
	}

	public void setReplyNumber(Integer replyNumber) {
		this.replyNumber = replyNumber;
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

	public Set getReplies() {
		return this.replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

}