package com.blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.blog.domain.BlogComment;
import com.blog.domain.BlogList;
import com.blog.domain.BlogShow;
import com.dao.NoticeDao;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

public class BlogDaoImpl implements BlogDao {
	@Resource
	List<BlogList> blogLists;
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private List<BlogComment> blogCommentList;
	@Resource
	private NoticeDao noticeDao;

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
			Query q = sessionFactory.getCurrentSession()
					.createQuery("from BlogList where userID=? ORDER BY blogID DESC ").setParameter(0, userID);
			q.setFirstResult(firstResult);
			q.setMaxResults(maxResult);
			blogLists = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blogLists;
	}

	@Override
	// 查询博文总记录数
	public int blogRows(int id) {
		System.out.println("blogRows*------");
		long temp = (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from  BlogList where userID=?").setParameter(0, id).uniqueResult();
		int rows = (int) temp;
		return rows;
	}

	@Override
	public void deleteBlog(int blogId) {
		sessionFactory.getCurrentSession().createQuery("delete from BlogComment where blogID=?").setParameter(0, blogId)
				.executeUpdate();
		sessionFactory.getCurrentSession().createQuery("delete from BlogList where blogID=?").setParameter(0, blogId)
				.executeUpdate();

	}

	@Override
	public List research(String researchKey) {
		blogLists = sessionFactory.getCurrentSession().createQuery("from BlogList where content like ?")
				.setString(0, "%" + researchKey + "%").list();
		return blogLists;
	}

	@Override
	public List research(Integer blogID) {
		blogLists = sessionFactory.getCurrentSession().createQuery("from BlogList where blogID=?")
				.setParameter(0, blogID).list();

		return blogLists;
	}

	@Override
	public Integer comment(BlogComment blogComment) {
		Integer id = null;
		try {
			id = (Integer) sessionFactory.getCurrentSession().save(blogComment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ActionContext ac = ActionContext.getContext();
		if (ac.getSession().get("friend") != null) { // 判断是否在评论他人博文
			blogLists = this.research(blogComment.getBlogList().getBlogId());
			noticeDao.blogCommentNotice(blogLists);
		}

		return id;
	}

	@Override
	public List<BlogComment> commentList(int blogID, int maxResult, int firstResult) {
		Query q = sessionFactory.getCurrentSession().createQuery("from BlogComment where blogID=? ORDER BY blogID DESC")
				.setParameter(0, blogID).setFirstResult(firstResult).setMaxResults(maxResult);
		blogCommentList = q.list();
		return blogCommentList;
	}

	@Override
	public Integer getCommentCount(int blogID) {
		long temp = (Long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from  BlogComment where blogID=?").setParameter(0, blogID).uniqueResult();
		int rows = (int) temp;
		return rows;
	}
}
