package com.jsu.ic.vo;

import java.sql.Timestamp;

import com.jsu.ic.commons.Const;

public class KeyWordVO {

	private Integer wordId;
	private String word;
	private String replaceTo;
	private Timestamp addTime;
	private Timestamp updateTime;
	private Boolean isDelete;
	private Integer sortNumber;

	public Integer getWordId() {
		return wordId;
	}

	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getReplaceTo() {
		return replaceTo;
	}

	public void setReplaceTo(String replaceTo) {
		this.replaceTo = replaceTo;
	}
	
	public String getTimeAdd() {
		return Const.dateToString(addTime);
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	
	public String getTimeUpdate() {
		return Const.dateToString(updateTime);
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
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
