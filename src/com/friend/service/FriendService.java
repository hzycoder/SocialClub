package com.friend.service;

import java.util.List;

public interface FriendService {
	public List searchFriend(String friendString);
	public Integer beFriend(String friendName);
	public List searchFriendList();
	public Integer deleteFriend(String friendName);
}
