package com.jsu.ic.po;

import java.sql.Timestamp;


/**
 * Keyword entity. @author MyEclipse Persistence Tools
 */

public class Keyword  implements java.io.Serializable {


    // Fields    

     private Integer wordId;
     private Userinfo userinfo;
     private String word;
     private String replaceTo;
     private Timestamp addTime;
     private Timestamp updateTime;
     private Boolean isDelete;
     private Integer sortNumber;


    // Constructors

    /** default constructor */
    public Keyword() {
    }

	/** minimal constructor */
    public Keyword(String word, Timestamp addTime, Timestamp updateTime) {
        this.word = word;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Keyword(Userinfo userinfo, String word, String replaceTo, Timestamp addTime, Timestamp updateTime, Boolean isDelete, Integer sortNumber) {
        this.userinfo = userinfo;
        this.word = word;
        this.replaceTo = replaceTo;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
    }

   
    // Property accessors

    public Integer getWordId() {
        return this.wordId;
    }
    
    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public Userinfo getUserinfo() {
        return this.userinfo;
    }
    
    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public String getWord() {
        return this.word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }

    public String getReplaceTo() {
        return this.replaceTo;
    }
    
    public void setReplaceTo(String replaceTo) {
        this.replaceTo = replaceTo;
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
   








}