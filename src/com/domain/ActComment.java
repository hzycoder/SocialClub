package com.domain;

import java.util.Date;


/**
 * ActComment entity. @author MyEclipse Persistence Tools
 */

public class ActComment  implements java.io.Serializable {


    // Fields    

     private Integer actcommentId;
     private ActList actList;
     private TUser TUser;
     private String commentDetail;
     private Date commentTime;


    // Constructors

    /** default constructor */
    public ActComment() {
    }

	/** minimal constructor */
    public ActComment(Integer actcommentId) {
        this.actcommentId = actcommentId;
    }
    
    /** full constructor */
    public ActComment(Integer actcommentId, ActList actList, TUser TUser, String commentDetail, Date commentTime) {
        this.actcommentId = actcommentId;
        this.actList = actList;
        this.TUser = TUser;
        this.commentDetail = commentDetail;
        this.commentTime = commentTime;
    }

   
    // Property accessors

    public Integer getActcommentId() {
        return this.actcommentId;
    }
    
    public void setActcommentId(Integer actcommentId) {
        this.actcommentId = actcommentId;
    }

    public ActList getActList() {
        return this.actList;
    }
    
    public void setActList(ActList actList) {
        this.actList = actList;
    }

    public TUser getTUser() {
        return this.TUser;
    }
    
    public void setTUser(TUser TUser) {
        this.TUser = TUser;
    }

    public String getCommentDetail() {
        return this.commentDetail;
    }
    
    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    public Date getCommentTime() {
        return this.commentTime;
    }
    
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
   








}