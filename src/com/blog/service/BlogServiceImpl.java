package com.blog.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.catalina.User;

import com.blog.dao.BlogDao;
import com.blog.domain.BlogList;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

public class BlogServiceImpl implements BlogService {
	@Resource
	BlogDao subBlogDao;
	@Override
	public Integer insertBlog(BlogList blogList) {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		blogList.setBlogTime(timestamp);
		
		ActionContext ac = ActionContext.getContext();
		//从session中获取当前user的信息
		//为Blog添加用户ID
		TUser user1 = (TUser)ac.getSession().get("user");
		blogList.setTUser(user1);
		return subBlogDao.insertBlog(blogList);
	}

}
