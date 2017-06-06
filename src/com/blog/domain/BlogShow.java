package com.blog.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.domain.TUser;

public class BlogShow implements java.io.Serializable{
	private Integer blogId;
	private TUser TUser;
	private Date blogTime;
	private String title;
	private String content;
	private Integer blogcommentId;
	private Set blogComments = new HashSet(0);
	
	public BlogShow() {
		super();
	}
	public BlogShow(Integer blogId, com.domain.TUser tUser, Date blogTime, String title, String content,
			Integer blogcommentId, Set blogComments) {
		super();
		this.blogId = blogId;
		TUser = tUser;
		this.blogTime = blogTime;
		this.title = title;
		this.content = content;
		this.blogcommentId = blogcommentId;
		this.blogComments = blogComments;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public TUser getTUser() {
		return TUser;
	}
	public void setTUser(TUser tUser) {
		TUser = tUser;
	}
	public Date getBlogTime() {
		return blogTime;
	}
	public void setBlogTime(Date blogTime) {
		this.blogTime = blogTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getBlogcommentId() {
		return blogcommentId;
	}
	public void setBlogcommentId(Integer blogcommentId) {
		this.blogcommentId = blogcommentId;
	}
	public Set getBlogComments() {
		return blogComments;
	}
	public void setBlogComments(Set blogComments) {
		this.blogComments = blogComments;
	}
	@Override
	public String toString() {
		return "BlogShow [blogId=" + blogId + ", TUser=" + TUser + ", blogTime=" + blogTime + ", title=" + title
				+ ", content=" + content + ", blogcommentId=" + blogcommentId + ", blogComments=" + blogComments + "]";
	}
	
	

}
