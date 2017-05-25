package com.blog.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogDao;
import com.blog.domain.BlogList;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

@Transactional
public class BlogServiceImpl implements BlogService {
	@Resource
	List<BlogList> blogLists;
	@Resource
	BlogDao blogDao;

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
	public List researchBlog(Integer userID, int maxResult, int firstResult) {
		blogLists = blogDao.researchBlog(userID, maxResult, firstResult);
		return blogLists;
	}

	@Override
	public int blogRows(int id) {
		return blogDao.blogRows(id);
	}

}
