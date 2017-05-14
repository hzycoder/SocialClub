package com.blog.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.catalina.User;

import com.blog.dao.SubmitBlogDao;
import com.blog.domain.BlogList;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

public class SubmitBlogServiceImpl implements SubmitBlogService {
	@Resource
	SubmitBlogDao subBlogDao;
	@Override
	public Integer insertBlog(BlogList blogList) {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		blogList.setBlogTime(timestamp);
		
		ActionContext ac = ActionContext.getContext();
		//��session�л�ȡ��ǰuser����Ϣ
		//ΪBlog����û�ID
		TUser user1 = (TUser)ac.getSession().get("user");
		blogList.setTUser(user1);
		// TODO Auto-generated method stub
		return subBlogDao.insertBlog(blogList);
	}

}
