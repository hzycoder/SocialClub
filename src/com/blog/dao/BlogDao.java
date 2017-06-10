package com.blog.dao;

import java.util.List;

import com.blog.domain.BlogComment;
import com.blog.domain.BlogList;

public interface BlogDao {
	public Integer insertBlog(BlogList blogList);

	public List researchBlog(Integer userID, int maxResult, int firstResult);

	public List research(Integer blogID);

	public List research(String researchKey);

	public int blogRows(int id);

	public void deleteBlog(int blogId);

	public Integer comment(BlogComment blogComment);

	public List<BlogComment> commentList(int blogID, int maxResult, int firstResult);
	
	public Integer getCommentCount(int blogID);
}
