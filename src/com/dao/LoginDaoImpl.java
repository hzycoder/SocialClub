package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.domain.TUser;

public class LoginDaoImpl implements LoginDao {
	@Resource
	List<TUser> userList;
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List searchUser(TUser user) {
		System.out.println("eeeeeeeeee3.eeeee");
		
		try {
			userList = sessionFactory.getCurrentSession().createQuery("from TUser where username=? and password=?")
					.setParameter(0, user.getUsername()).setParameter(1, user.getPassword()).list();
			System.out.println("userList"+userList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		return userList;
	}

}
