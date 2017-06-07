package com.blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;

public class BlogDaoImpl implements BlogDao {
	@Resource
	List<BlogList> blogLists;
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Integer insertBlog(BlogList blogList) {
		Integer id = null;
		try {
			id = (Integer) sessionFactory.getCurrentSession().save(blogList);
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
//			System.out.println("blogList__query" + blogLists);
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
	@Override
	public void deleteBlog(int blogId){
		sessionFactory.getCurrentSession().createQuery("delete from BlogList where blogID=?").setParameter(0, blogId).executeUpdate();
	}

	@Override
	public List research(String researchKey) {
		blogLists = sessionFactory.getCurrentSession().createQuery("from BlogList where content like ?").setString(0, "%"+researchKey+"%").list();
		return blogLists;
	}

	@Override
	public List research(Integer blogID) {
		blogLists = sessionFactory.getCurrentSession().createQuery("from BlogList where blogID=?").setParameter(0, blogID).list();
		
		return blogLists;
	}
}
