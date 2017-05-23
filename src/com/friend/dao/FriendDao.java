package com.friend.dao;

import java.util.List;

import com.domain.TUser;

public interface FriendDao {
	public List searchFriend(String friendString);
	public Integer beFriend(String friendName);//tÌí¼ÓºÃÓÑ
	public List searchFriendList();
}
