package com.domain;

import java.util.Date;

import com.blog.domain.BlogList;


/**
 * BlogComment entity. @author MyEclipse Persistence Tools
 */

public class BlogComment  implements java.io.Serializable {


    // Fields    

     private Integer blogcommentId;
     private BlogList blogList;
     private TUser TUser;
     private String commentDetail;
     private Date commentTime;


    // Constructors

    /** default constructor */
    public BlogComment() {
    }

	/** minimal constructor */
    public BlogComment(Integer blogcommentId) {
        this.blogcommentId = blogcommentId;
    }
    
    /** full constructor */
    public BlogComment(Integer blogcommentId, BlogList blogList, TUser TUser, String commentDetail, Date commentTime) {
        this.blogcommentId = blogcommentId;
        this.blogList = blogList;
        this.TUser = TUser;
        this.commentDetail = commentDetail;
        this.commentTime = commentTime;
    }

   
    // Property accessors

    public Integer getBlogcommentId() {
        return this.blogcommentId;
    }
    
    public void setBlogcommentId(Integer blogcommentId) {
        this.blogcommentId = blogcommentId;
    }

    public BlogList getBlogList() {
        return this.blogList;
    }
    
    public void setBlogList(BlogList blogList) {
        this.blogList = blogList;
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