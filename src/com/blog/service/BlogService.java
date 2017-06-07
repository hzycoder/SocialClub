package com.blog.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;
@Transactional
public interface BlogService {
	public Integer insertBlog(BlogList blogList);
	public List<BlogShow> researchBlog(Integer userID,int maxResult,int firstResult);
	public List<BlogShow> research(Integer blogID);
	public List<BlogShow> research(String researchKey);
	public int blogRows(int id);
	public void deleteBlog(int blogId);
}
