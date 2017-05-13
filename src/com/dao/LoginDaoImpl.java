package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.domain.TUser;

public class LoginDaoImpl implements LoginDao{
	@Resource
	List<TUser> userList;
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List searchUser(TUser user) {
		try {
			userList = sessionFactory.getCurrentSession().createQuery("from User where userName=? and password=?")
					.setParameter(0, user.getUsername()).setParameter(1, user.getPassword()).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		return userList;
	}

}
