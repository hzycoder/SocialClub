package com.blog.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.blog.domain.BlogList;

public class SubmitBlogDaoImpl implements SubmitBlogDao {
	@Resource
	private SessionFactory SessionFactory;

	@Override
	public Integer insertBlog(BlogList blogList) {
		
		Integer id = null;
		try {
			System.out.println("blogList1111" + blogList.toString());
			id = (Integer) SessionFactory.getCurrentSession().save(blogList);
			System.out.println("id===="+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SessionFactory.close();
		return id;
	}

}
