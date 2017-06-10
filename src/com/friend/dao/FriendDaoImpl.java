package com.friend.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.dao.NoticeDao;
import com.dao.NoticeDaoImpl;
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
	@Resource
	private NoticeDao noticeDao;
	List<TFriends> friendList; // ��ע���ѱ�List
	List<TFriends> friendList1; // ����ע���ѱ�List
	TUser user;

	@Override
	public List searchFriendList() { // ������ʾ�����б�
		List<FriendsInfo> friInfoList = new ArrayList<FriendsInfo>();
		String uPicture;
		Date date = new Date();
		ActionContext ac = ActionContext.getContext();// ��ȡ��ǰ�ѵ�¼�û�����Ϣ
		user = (TUser) ac.getSession().get("user");
		friendList = sessionFactory.getCurrentSession().createQuery("from TFriends where userID=?")
				.setParameter(0, user.getUserId()).list();// ��ѯ�����б�
		System.out.println("------friendList-------");
		for (int i = 0; i < friendList.size(); i++) {
			System.out.println(friendList.get(i).toString());
		}
		System.out.println("------friendList-------");
		if (friendList != null && !friendList.isEmpty()) {
			for (int i = 0; i < friendList.size(); i++) { // �ݹ��ѯ�����б���ÿһ�����ѵ���Ϣת��Ϊuser����userList��
				FriendsInfo friInfo = new FriendsInfo();
				System.out.println("i   " + i);
				/* name��ȡ�û��� */
				String name = sessionFactory.getCurrentSession()
						.createQuery("select username from TUser where userID=?")
						.setParameter(0, friendList.get(i).getId().getFriendId()).uniqueResult().toString();
				/* uPicture��ȡͷ�� */
				if (sessionFactory.getCurrentSession().createQuery("select UPicture from TUser where userID=?")
						.setParameter(0, friendList.get(i).getId().getFriendId()).uniqueResult() == null) {
					uPicture = null;
				} else
					uPicture = sessionFactory.getCurrentSession()
							.createQuery("select UPicture from TUser where userID=?")
							.setParameter(0, friendList.get(i).getId().getFriendId()).uniqueResult().toString();
				long mm = (date.getTime()) - (friendList.get(i).getFriendsAddTime().getTime());
				int day = (int) (mm / (1000 * 60 * 60 * 24));
				friInfo.setFriendTime(day);
				friInfo.setUsername(name);
				friInfo.setUPicture(uPicture);
				System.out.println(friInfo.toString());
				friInfoList.add(friInfo);
			}
		}
		return friInfoList;
	}

	@Override
	public List searchFriendList1() { // ���������û��������û�����
		List<FriendsInfo> friInfoList1 = new ArrayList<FriendsInfo>();
		String uPicture;
		Date date = new Date();
		ActionContext ac = ActionContext.getContext();// ��ȡ��ǰ�ѵ�¼�û�����Ϣ
		user = (TUser) ac.getSession().get("user");
		friendList1 = sessionFactory.getCurrentSession().createQuery("from TFriends where friendID=?")
				.setParameter(0, user.getUserId()).list();// ��ѯ�����б�

		if (friendList1 != null && !friendList1.isEmpty()) {
			for (int i = 0; i < friendList1.size(); i++) { // �ݹ��ѯ�����б���ÿһ�����ѵ���Ϣת��Ϊuser����userList��
				FriendsInfo friInfo = new FriendsInfo();
				/* name��ȡ�û��� */
				String name = sessionFactory.getCurrentSession()
						.createQuery("select username from TUser where userID=?")
						.setParameter(0, friendList1.get(i).getId().getUserId()).uniqueResult().toString();
				/* uPicture��ȡͷ�� */
				if (sessionFactory.getCurrentSession().createQuery("select UPicture from TUser where userID=?")
						.setParameter(0, friendList1.get(i).getId().getUserId()).uniqueResult() == null) {
					uPicture = null;
				} else
					uPicture = sessionFactory.getCurrentSession()
							.createQuery("select UPicture from TUser where userID=?")
							.setParameter(0, friendList1.get(i).getId().getUserId()).uniqueResult().toString();
				long mm = (date.getTime()) - (friendList1.get(i).getFriendsAddTime().getTime());
				int day = (int) (mm / (1000 * 60 * 60 * 24));
				friInfo.setFriendTime(day);
				friInfo.setUsername(name);
				friInfo.setUPicture(uPicture);
				friInfoList1.add(friInfo);
			}
		}
		return friInfoList1;
	}

	@Override
	public List searchFriend(String friendString) { // ���������û��������û�����
		try {
			userList = sessionFactory.getCurrentSession().createQuery("from TUser where username=?")
					.setParameter(0, friendString).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ActionContext ac = ActionContext.getContext();// ��ȡ��ǰ�ѵ�¼�û�����Ϣ
		user = (TUser) ac.getSession().get("user");
		if (sessionFactory.getCurrentSession().createQuery("from TFriends where userID=? and friendID=?")
				.setParameter(0, user.getUserId()).setParameter(1, userList.get(0).getUserId())
				.uniqueResult() != null) {
			ac.getSession().put("friendFlag", 1);
			return userList;
		}
		return userList;
	}

	@Override
	public Integer beFriend(String friendName) { // �������
		System.out.println("friendName11119988654" + friendName);
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
		try {
			sessionFactory.getCurrentSession().save(tFriends);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		noticeDao.addFriendNotice(friendUser);//������Ӻ�����Ϣ
		return 1;
		
		
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
					.setParameter(0, user.getUserId()).setParameter(1, friendUser.getUserId()).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
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
	public Integer friendCount(int userID) {
		long l;
		l = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from TFriends where friendID=?")
				.setParameter(0, userID).uniqueResult();
		int friendCount = (int) l;
		return friendCount;
	}

}
