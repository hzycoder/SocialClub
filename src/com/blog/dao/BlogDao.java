package com.blog.dao;

import java.util.List;

import com.blog.domain.BlogList;

public interface BlogDao {
	public Integer insertBlog(BlogList blogList);
	public List researchBlog(Integer userID,int maxResult,int firstResult);
	

}
