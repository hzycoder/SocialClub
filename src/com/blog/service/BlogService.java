package com.blog.service;

import org.springframework.transaction.annotation.Transactional;

import com.blog.domain.BlogList;
@Transactional
public interface BlogService {
	public Integer insertBlog(BlogList blogList);
}
