package com.friend.dao;

import java.util.List;

import com.domain.TUser;

public interface FriendDao {
	public List searchFriend(String friendString);
	public Integer beFriend(String friendName);//t添加好友
	public List searchFriendList();
	public TUser findUser(String username);//根据username找userID
	public Integer deleteFriend(String friendName);
}
