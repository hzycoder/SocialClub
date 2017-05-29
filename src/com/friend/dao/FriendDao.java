package com.friend.dao;

import java.util.List;

import com.domain.TUser;

public interface FriendDao {
	public List searchFriend(String friendString);
	public Integer beFriend(String friendName);//t��Ӻ���
	public List searchFriendList();
	public TUser findUser(String username);//����username��userID
	public Integer deleteFriend(String friendName);
}
