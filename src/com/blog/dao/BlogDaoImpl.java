package com.blog.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.blog.domain.BlogList;

public class BlogDaoImpl implements BlogDao {
	@Resource
	private SessionFactory SessionFactory;

	@Override
	public Integer insertBlog(BlogList blogList) {
		Integer id = null;
		try {
			System.out.println("blogList_UserId" + blogList.getTUser().toString());
			System.out.println("-----------------88");
			id = (Integer) SessionFactory.getCurrentSession().save(blogList);
			System.out.println("id===="+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SessionFactory.close();
		return id;
	}

}
