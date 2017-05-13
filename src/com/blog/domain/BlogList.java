package com.blog.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.domain.TUser;

/**
 * BlogList entity. @author MyEclipse Persistence Tools
 */

public class BlogList implements java.io.Serializable {

	// Fields

	private Integer blogId;
	private TUser TUser;
	private Date blogTime;
	private String content;
	private Integer blogcommentId;
	private Set blogComments = new HashSet(0);

	// Constructors

	/** default constructor */
	public BlogList() {
	}

	/** full constructor */
	public BlogList(TUser TUser, Date blogTime, String content, Integer blogcommentId, Set blogComments) {
		this.TUser = TUser;
		this.blogTime = blogTime;
		this.content = content;
		this.blogcommentId = blogcommentId;
		this.blogComments = blogComments;
	}

	// Property accessors

	public Integer getBlogId() {
		return this.blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public Date getBlogTime() {
		return this.blogTime;
	}

	public void setBlogTime(Date blogTime) {
		this.blogTime = blogTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getBlogcommentId() {
		return this.blogcommentId;
	}

	public void setBlogcommentId(Integer blogcommentId) {
		this.blogcommentId = blogcommentId;
	}

	public Set getBlogComments() {
		return this.blogComments;
	}

	public void setBlogComments(Set blogComments) {
		this.blogComments = blogComments;
	}

}