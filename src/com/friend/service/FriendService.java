package com.friend.service;

import java.util.List;

public interface FriendService {
	public List searchFriend(String friendString);
	public Integer beFriend(String friendName);
	public List searchFriendList();
	public List searchFriendlist1();
	public Integer deleteFriend(String friendName);
	public Integer friendCount(int userID);
}
