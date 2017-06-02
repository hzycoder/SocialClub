package com.info.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.domain.TUser;

public class infoDaoImpl implements infoDao {
	@Resource
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<TUser> searchUser(TUser user) {
		// TODO Auto-generated method stub
		List<TUser> list = null;
		System.out.println("hi~~"+user.getUserId());
		try{
	   Query q = sessionFactory.openSession().createQuery("from TUser where userID=?").setParameter(0,user.getUserId());
	   list = q.list();
		System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("list:"+list);
		}
		finally{
			sessionFactory.close();
		}
		return list;
	}
	
	@Transactional
	public void updateUser(TUser user) {
		try{
			
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query q = session.createQuery("update TUser set petname=?,college=?,birthday=?,phone=? where username=?");
			System.out.println("petname"+user.getPetname()+user.getUsername());
			q.setParameter(0, user.getPetname());
			q.setParameter(1, user.getCollege());
			q.setParameter(2, user.getBirthday());
			q.setParameter(3, user.getPhone());
			q.setParameter(4, user.getUsername());
			q.executeUpdate();
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("taihan~");
		}
		finally {
			sessionFactory.close();
		}
		
	}
	@Transactional
	public void updatePhoto(TUser user){
		try{
			
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query q = session.createQuery("update TUser set UPicture=? where username=?");
			System.out.println(user.getUPicture());
			q.setParameter(0, user.getUPicture());
			
			q.setParameter(1, user.getUsername());
			q.executeUpdate();
			session.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("taihan~");
		}
		finally {
			sessionFactory.close();
		}
	}

}
