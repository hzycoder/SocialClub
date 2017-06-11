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
	List<TFriends> friendList; // 关注好友表List
	List<TFriends> friendList1; // 被关注好友表List
	TUser user;

	@Override
	public List searchFriendList() { // 用于显示好友列表
		List<FriendsInfo> friInfoList = new ArrayList<FriendsInfo>();
		String uPicture;
		Date date = new Date();
		ActionContext ac = ActionContext.getContext();// 获取当前已登录用户的信息
		user = (TUser) ac.getSession().get("user");
		friendList = sessionFactory.getCurrentSession().createQuery("from TFriends where userID=?")
				.setParameter(0, user.getUserId()).list();// 查询朋友列表

		if (friendList != null && !friendList.isEmpty()) {
			for (int i = 0; i < friendList.size(); i++) { // 递归查询朋友列表中每一个朋友的信息转化为user存入userList中
				FriendsInfo friInfo = new FriendsInfo();
				/* name获取用户名 */
				TUser user_friList = (TUser) sessionFactory.getCurrentSession()
						.createQuery("from TUser where userID=?")
						.setParameter(0, friendList.get(i).getId().getFriendId()).uniqueResult();				
				long mm = (date.getTime()) - (friendList.get(i).getFriendsAddTime().getTime());
				int day = (int) (mm / (1000 * 60 * 60 * 24));
				friInfo.setFriendTime(day);
//				user_friList.setUPicture(uPicture);
				friInfo.setUser_friList(user_friList);
				friInfoList.add(friInfo);
			}
		}
		return friInfoList;
	}

	@Override
	public List searchFriendList1() { // 用于搜索用户（根据用户名）
		List<FriendsInfo> friInfoList1 = new ArrayList<FriendsInfo>();
		String uPicture;
		Date date = new Date();
		ActionContext ac = ActionContext.getContext();// 获取当前已登录用户的信息
		user = (TUser) ac.getSession().get("user");
		friendList1 = sessionFactory.getCurrentSession().createQuery("from TFriends where friendID=?")
				.setParameter(0, user.getUserId()).list();// 查询朋友列表

		if (friendList1 != null && !friendList1.isEmpty()) {
			for (int i = 0; i < friendList1.size(); i++) { // 递归查询朋友列表中每一个朋友的信息转化为user存入userList中
				FriendsInfo friInfo = new FriendsInfo();
				/* name获取用户名 */
				TUser user_friList = (TUser) sessionFactory.getCurrentSession()
						.createQuery("from TUser where userID=?")
						.setParameter(0, friendList.get(i).getId().getFriendId()).uniqueResult();
				long mm = (date.getTime()) - (friendList1.get(i).getFriendsAddTime().getTime());
				int day = (int) (mm / (1000 * 60 * 60 * 24));
				friInfo.setFriendTime(day);
//				user_friList.setUPicture(uPicture);
				friInfo.setUser_friList(user_friList);
				friInfoList1.add(friInfo);
			}
		}
		return friInfoList1;
	}

	@Override
	public List searchFriend(String friendString) { // 用于搜索用户（根据用户名）
		try {
			userList = sessionFactory.getCurrentSession().createQuery("from TUser where username=?")
					.setParameter(0, friendString).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ActionContext ac = ActionContext.getContext();// 获取当前已登录用户的信息
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
	public Integer beFriend(String friendName) { // 添加朋友
		System.out.println("friendName11119988654" + friendName);
		ActionContext ac = ActionContext.getContext();// 获取当前已登录用户的信息
		user = (TUser) ac.getSession().get("user");
		try {
			friendUser = (TUser) sessionFactory.getCurrentSession().createQuery("from TUser where username=?")
					.setParameter(0, friendName).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		fFriendsID.setFriendId(friendUser.getUserId());// 设置friends主键
		fFriendsID.setUserId(user.getUserId()); //
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		tFriends.setFriendsAddTime(timestamp);// 设置添加好友时间
		tFriends.setId(fFriendsID);
		try {
			sessionFactory.getCurrentSession().save(tFriends);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		noticeDao.addFriendNotice(friendUser);//发送添加好友消息
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
