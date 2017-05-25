package com.blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.blog.domain.BlogList;

public class BlogDaoImpl implements BlogDao {
	@Resource
	List<BlogList> blogLists;
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Integer insertBlog(BlogList blogList) {
		Integer id = null;
		try {
			System.out.println("blogList_UserId" + blogList.getTUser().toString());
			System.out.println("-----------------88");
			id = (Integer) sessionFactory.getCurrentSession().save(blogList);
			System.out.println("id====" + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionFactory.close();
		return id;
	}

	@Override
	public List researchBlog(Integer userID, int maxResult, int firstResult) {
		try {
			Query q = sessionFactory.getCurrentSession().createQuery("from BlogList where userID=?").setParameter(0,
					userID);
			q.setFirstResult(firstResult);
			q.setMaxResults(maxResult);
			blogLists = q.list();
			System.out.println("blogList__query" + blogLists);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		return blogLists;
	}

	@Override
	// 查询博文总记录数
	public int blogRows(int id) {
		System.out.println("blogRows*------");
		long temp = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from  BlogList where userID=?").setParameter(0, id)
				.uniqueResult();
		int rows = (int) temp;
		return rows;
	}
}
