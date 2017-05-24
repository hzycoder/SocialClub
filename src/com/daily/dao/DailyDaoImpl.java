package com.daily.dao;
import com.util.*;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.daily.domain.TDaily;

public class DailyDaoImpl implements DailyDao {
	
	@Resource
	TDaily tdaily;
	
	private Session session;

	public Integer addmessage(TDaily tdaily) {
		Integer id = null;
		Transaction tx =null;
		try {
			session =  HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			id = (Integer) session.save(tdaily);
			tx.commit();
			System.out.println("id=="+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//HibernateSessionFactory.closeSession(session);
		return id;
	}
}
