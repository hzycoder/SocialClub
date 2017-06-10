package com.blog.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import com.blog.dao.BlogDao;
import com.blog.domain.BlogComment;
import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.util.ChangeBlogShowFormat;

@Transactional
public class BlogServiceImpl implements BlogService {
	@Resource
	List<BlogList> blogLists;
	@Resource
	BlogDao blogDao;
	@Resource
	ChangeBlogShowFormat cbsf;
	@Resource
	BlogComment blogComment;

	@Override
	public Integer insertBlog(BlogList blogList) {
		ActionContext ac = ActionContext.getContext();
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		blogList.setBlogTime(timestamp);

		if (ac.getSession().get("friend") != null) {// 判断当前是否浏览其他用户主页
			// 从session中获取当前user的信息
			// 为Blog添加用户ID
			TUser user1 = (TUser) ac.getSession().get("friend");
			blogList.setTUser(user1);
			return blogDao.insertBlog(blogList);
		} else {
			TUser user1 = (TUser) ac.getSession().get("user");
			blogList.setTUser(user1);
			return blogDao.insertBlog(blogList);
		}

	}

	@Override
	public List<BlogShow> researchBlog(Integer userID, int maxResult, int firstResult) {
		blogLists = blogDao.researchBlog(userID, maxResult, firstResult);
		return cbsf.change(blogLists);

	}

	@Override
	public int blogRows(int id) {
		return blogDao.blogRows(id);
	}

	@Override
	public void deleteBlog(int blogId) {
		blogDao.deleteBlog(blogId);
	}

	@Override
	public List<BlogShow> research(String researchKey) {
		blogLists = blogDao.research(researchKey);
		return cbsf.change(blogLists);
	}

	@Override
	public List<BlogShow> research(Integer blogID) {
		blogLists = blogDao.research(blogID);
		return cbsf.change(blogLists);
	}

	@Override
	public Integer comment(TUser user, int blogID, String commentDetail) {

		blogLists = blogDao.research(blogID);
		blogComment.setBlogList(blogLists.get(0));
		blogComment.setTUser(user);
		blogComment.setCommentDetail(commentDetail);
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		blogComment.setCommentTime(timestamp);

		return blogDao.comment(blogComment);
	}

	@Override
	public List<BlogComment> commentList(int blogID,int maxResult, int firstResult) {
		return blogDao.commentList(blogID,maxResult,firstResult);
	}

	@Override
	public Integer getCommentCount(int blogID) {
		return blogDao.getCommentCount(blogID);
	}
}
