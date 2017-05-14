package com.blog.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.blog.domain.BlogList;
@Transactional
public interface BlogService {
	public Integer insertBlog(BlogList blogList);
	public List researchBlog(Integer userID,int maxResult,int firstResult);
}
