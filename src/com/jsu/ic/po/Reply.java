package com.jsu.ic.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply implements java.io.Serializable {

	// Fields

	private Integer replyId;
	private Userinfo userinfo;
	private Reply reply;
	private Userpost userpost;
	private String replyContext;
	private Integer replyNumber;
	private String replyUrl;
	private Timestamp replyTime;
	private Integer status;
	private Boolean isDelete;
	private Integer sortNumber;
	private Set replies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** minimal constructor */
	public Reply(String replyContext, Timestamp replyTime, Integer status, Boolean isDelete, Integer sortNumber) {
		this.replyContext = replyContext;
		this.replyTime = replyTime;
		this.status = status;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
	}

	/** full constructor */
	public Reply(Userinfo userinfo, Reply reply, Userpost userpost, String replyContext, Integer replyNumber, String replyUrl,
			Timestamp replyTime, Integer status, Boolean isDelete, Integer sortNumber, Set replies) {
		this.userinfo = userinfo;
		this.reply = reply;
		this.userpost = userpost;
		this.replyContext = replyContext;
		this.replyNumber = replyNumber;
		this.replyUrl = replyUrl;
		this.replyTime = replyTime;
		this.status = status;
		this.isDelete = isDelete;
		this.sortNumber = sortNumber;
		this.replies = replies;
	}

	// Property accessors

	public Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Reply getReply() {
		return this.reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public Userpost getUserpost() {
		return this.userpost;
	}

	public void setUserpost(Userpost userpost) {
		this.userpost = userpost;
	}

	public String getReplyContext() {
		return this.replyContext;
	}

	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}

	public Integer getReplyNumber() {
		return this.replyNumber;
	}

	public void setReplyNumber(Integer replyNumber) {
		this.replyNumber = replyNumber;
	}

	public String getReplyUrl() {
		return this.replyUrl;
	}

	public void setReplyUrl(String replyUrl) {
		this.replyUrl = replyUrl;
	}

	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
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

	public Set getReplies() {
		return this.replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

}