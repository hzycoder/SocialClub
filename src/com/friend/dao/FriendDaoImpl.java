package com.friend.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.domain.TUser;
import com.friend.domain.FriendsInfo;
import com.friend.domain.TFriends;
import com.friend.domain.TFriendsId;
import com.opensymphony.xwork2.ActionContext;

public class FriendDaoImpl implements FriendDao {
	@Resource
	List<TUser> userList;
	@Resource
	TFriends tFriends;
	@Resource
	TFriendsId fFriendsID;
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	TUser friendUser;
	List<TFriends> friendList;	//���ѱ�List
	TUser user;

	@Override
	public List searchFriendList() { // ������ʾ�����б�
		List<FriendsInfo> friInfoList = new ArrayList<FriendsInfo>();
		Date date = new Date();
		ActionContext ac = ActionContext.getContext();// ��ȡ��ǰ�ѵ�¼�û�����Ϣ
		user = (TUser) ac.getSession().get("user");
		friendList = sessionFactory.getCurrentSession().createQuery("from TFriends where userID=?")
				.setParameter(0, user.getUserId()).list();// ��ѯ�����б�
		if (friendList != null && !friendList.isEmpty()) {
			for (int i = 0; i < friendList.size(); i++) { // �ݹ��ѯ�����б���ÿһ�����ѵ���Ϣת��Ϊuser����userList��
				FriendsInfo friInfo = new FriendsInfo();
				System.out.println("i   "+i);
				String name = sessionFactory.getCurrentSession().createQuery("select username from TUser where userID=?")
						.setParameter(0, friendList.get(i).getId().getFriendId()).uniqueResult().toString();
				
				long mm = (date.getTime())-(friendList.get(i).getFriendsAddTime().getTime());
//				System.out.println("mmmmm"+mm);
				int day = (int)(mm / (1000 * 60 * 60 * 24));
				friInfo.setFriendTime(day);
				friInfo.setUsername(name);
				friInfo.setUPicture(null);
//				System.out.println("friInfo"+friInfo.toString());
				
				friInfoList.add(friInfo);
			}
		}
//		System.out.println("friInfoList888888"+friInfoList.toString());
		return friInfoList;
	}

	@Override
	public List searchFriend(String friendString) { // �û������û�
		try {
			userList = sessionFactory.getCurrentSession().createQuery("from TUser where username=?")
					.setParameter(0, friendString).list();
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		finally {
//			sessionFactory.close();		//getCurrentSession����closeSession
//		}
//
//		System.out.println("ssssssssssss" + userList);
		return userList;
	}

	@Override
	public Integer beFriend(String friendName) { // �������
		System.out.println("friendName11119988654"+friendName);
		ActionContext ac = ActionContext.getContext();// ��ȡ��ǰ�ѵ�¼�û�����Ϣ
		user = (TUser) ac.getSession().get("user");
		try {
			friendUser = (TUser) sessionFactory.getCurrentSession().createQuery("from TUser where username=?")
					.setParameter(0, friendName).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		fFriendsID.setFriendId(friendUser.getUserId());// ����friends����
		fFriendsID.setUserId(user.getUserId()); //
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		tFriends.setFriendsAddTime(timestamp);// ������Ӻ���ʱ��
		tFriends.setId(fFriendsID);
		System.out.println("tfrienddd:" + tFriends.toString());
		try {
			sessionFactory.getCurrentSession().save(tFriends);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 1;
	}

	@Override
	public TUser findUser(String username) {
		TUser resultUser = null;
		try {
			resultUser = (TUser) sessionFactory.getCurrentSession().createQuery("from TUser where username=?")
					.setParameter(0, username).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultUser;
	}

	@Override
	public Integer deleteFriend(String friendName) {
		System.out.println(friendName);
		ActionContext ac = ActionContext.getContext();
		TUser user = (TUser) ac.getSession().get("user");
		TUser friendUser = findUser(friendName);
		Integer id = null;
		try {
			id = sessionFactory.getCurrentSession().createQuery("delete from TFriends where userID=? and friendID=?")
			.setParameter(0, user.getUserId())
			.setParameter(1, friendUser.getUserId()).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
