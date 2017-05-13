package com.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.domain.TUser;
import com.util.HibernateSessionFactory;

public class RegisterDaoImpl implements RegisterDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Integer insertUser(TUser user) {
		Integer id =null;
		try{
			id = (Integer) sessionFactory.getCurrentSession().save(user);
			System.out.println("id===="+id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sessionFactory.close();
		}
		return id;
	}

}
