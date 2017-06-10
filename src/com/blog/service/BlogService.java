package com.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.blog.domain.BlogComment;
import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;
import com.domain.TUser;

@Transactional
public interface BlogService {
	public Integer insertBlog(BlogList blogList);

	public List<BlogShow> researchBlog(Integer userID, int maxResult, int firstResult);

	public List<BlogShow> research(Integer blogID);

	public List<BlogShow> research(String researchKey);

	public int blogRows(int id);

	public void deleteBlog(int blogId);

	public Integer comment(TUser user, int blogID, String commentDetail);

	public List<BlogComment> commentList(int blogID,int maxResult, int firstResult);
	
	public Integer getCommentCount(int blogID);
}
