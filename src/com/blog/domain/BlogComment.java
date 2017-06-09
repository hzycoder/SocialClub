package com.blog.domain;

import java.sql.Timestamp;

import com.domain.TUser;

/**
 * BlogComment entity. @author MyEclipse Persistence Tools
 */

public class BlogComment implements java.io.Serializable {

	// Fields

	private Integer blogcommentId;
	private BlogList blogList;
	private TUser TUser;
	private String commentDetail;
	private Timestamp commentTime;

	// Constructors

	/** default constructor */
	public BlogComment() {
	}

	/** full constructor */
	public BlogComment(BlogList blogList, TUser TUser, String commentDetail, Timestamp commentTime) {
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

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}