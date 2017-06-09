package com.daily.dao;
import com.util.*;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.daily.domain.TDaily;
import com.domain.TUser;

public class DailyDaoImpl implements DailyDao {
	
	@Resource
	TDaily tdaily;
	@Resource
	List<TDaily> tdailys;
	private Session session;
	Transaction tx;
	@Resource
	private SessionFactory sessionFactory;
	int rows;

	public Integer addmessage(TDaily tdaily) {
		Integer id = null;
		try {
			session =  HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			id = (Integer) session.save(tdaily);
			tx.commit();
			System.out.println("id=="+id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession(session);
		}
		return id;
	}
	
	public List showmessage(TUser tuser,int f,int m){
		try{
			String userid = tuser.getUserId().toString();
			if(f==0&&m==0){
				tdailys = sessionFactory.getCurrentSession().createQuery("from TDaily where UserID=?").setParameter(0, userid).list();
			}else{
				session = HibernateSessionFactory.getSession();
				String hql="from TDaily where UserID=?";
				Query query = session.createQuery(hql);
				query.setString(0,userid);
				query.setFirstResult(f);
				query.setMaxResults(m);
				tdailys = query.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession(session);
		}
		return tdailys;
	}
	
	public void deletemessage(Integer dailyID){
		try{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			String hql="Delete FROM TDaily Where id=?";
			Query query = session.createQuery(hql);
			query.setLong(0,dailyID);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession(session);
		}
		
		System.out.println("delete ID:"+dailyID);
	}
	
	
	public int dailyRows(int id) {
		System.out.println("dailyRows------");
//		long temp = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from  TDaily where userID=?").setParameter(0, id)
//				.uniqueResult();
		try{
			session = HibernateSessionFactory.getSession();
			String hql="select count(*) from  TDaily where userID=?";
			long temp=(Long) session.createQuery("select count(*) from  TDaily where userID=?").setParameter(0,id).uniqueResult();
			rows=(int)temp;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession(session);
		}
		return rows;
	}
}
