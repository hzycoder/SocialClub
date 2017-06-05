package com.friend.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.domain.TUser;
import com.friend.dao.FriendDao;
import com.opensymphony.xwork2.ActionContext;

@Transactional
public class FriendServiceImpl implements FriendService {
	@Resource
	FriendDao friendDao;

	@Override
	public List searchFriend(String friendString) { // ������������
		return friendDao.searchFriend(friendString);
	}

	@Override
	public Integer beFriend(String friendName) {// ������Ӻ���
		friendDao.beFriend(friendName);
		return 1;
	}

	@Override
	public List searchFriendList() { // ������ʾ�����б�
		return friendDao.searchFriendList();
	}

	@Override
	public Integer deleteFriend(String friendName) {
		return friendDao.deleteFriend(friendName);
	}

	@Override
	public Integer friendCount(int userID) {
		return friendDao.friendCount(userID);
	}

}
