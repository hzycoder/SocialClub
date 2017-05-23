package com.friend.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.domain.TUser;

public class FriendDaoImpl implements FriendDao {
	@Resource
	private SessionFactory SessionFactory;

	@Override
	public Integer beFriend(TUser user) {// tÃÌº”∫√”—
		Integer id = null;
//		SessionFactory.getCurrentSession().createQuery("from ")
		return id;
	}

}
