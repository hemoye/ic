package com.jsu.ic.po;

import java.sql.Timestamp;


/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message  implements java.io.Serializable {


    // Fields    

     private Integer messageId;
     private User userByUserIdA;
     private User userByUserIdB;
     private String messageContext;
     private Timestamp sendTime;
     private Integer status;
     private Boolean isDelete;
     private Integer sortNumber;


    // Constructors

    /** default constructor */
    public Message() {
    }

	/** minimal constructor */
    public Message(String messageContext, Timestamp sendTime) {
        this.messageContext = messageContext;
        this.sendTime = sendTime;
    }
    
    /** full constructor */
    public Message(User userByUserIdA, User userByUserIdB, String messageContext, Timestamp sendTime, Integer status, Boolean isDelete, Integer sortNumber) {
        this.userByUserIdA = userByUserIdA;
        this.userByUserIdB = userByUserIdB;
        this.messageContext = messageContext;
        this.sendTime = sendTime;
        this.status = status;
        this.isDelete = isDelete;
        this.sortNumber = sortNumber;
    }

   
    // Property accessors

    public Integer getMessageId() {
        return this.messageId;
    }
    
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public User getUserByUserIdA() {
        return this.userByUserIdA;
    }
    
    public void setUserByUserIdA(User userByUserIdA) {
        this.userByUserIdA = userByUserIdA;
    }

    public User getUserByUserIdB() {
        return this.userByUserIdB;
    }
    
    public void setUserByUserIdB(User userByUserIdB) {
        this.userByUserIdB = userByUserIdB;
    }

    public String getMessageContext() {
        return this.messageContext;
    }
    
    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public Timestamp getSendTime() {
        return this.sendTime;
    }
    
    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
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
   








}