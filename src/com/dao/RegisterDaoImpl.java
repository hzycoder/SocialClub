package com.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import com.domain.TUser;

public class RegisterDaoImpl implements RegisterDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public Integer insertUser(TUser user) {
		Integer id = null;
		// ��ѯ�û����Ƿ��ظ�
		if (sessionFactory.getCurrentSession().createQuery("from TUser where username=?")
				.setParameter(0, user.getUsername()).list().isEmpty()) {
			try {
				id = (Integer) sessionFactory.getCurrentSession().save(user);
				System.out.println("id====" + id);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sessionFactory.close();
			}
			return id;

		} else {
			// �û����ظ�
			return -1;
		}

	}

}
