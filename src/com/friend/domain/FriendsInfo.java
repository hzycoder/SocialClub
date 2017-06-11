package com.friend.domain;

import java.io.Serializable;

import com.domain.TUser;

public class FriendsInfo implements Serializable{	//用于显示好友列表
	private TUser user_friList;
	private int friendTime;
	
	public TUser getUser_friList() {
		return user_friList;
	}


	public void setUser_friList(TUser user_friList) {
		this.user_friList = user_friList;
	}


	public FriendsInfo(TUser user_friList, int friendTime) {
		super();
		this.user_friList = user_friList;
		this.friendTime = friendTime;
	}


	public int getFriendTime() {
		return friendTime;
	}


	public void setFriendTime(int friendTime) {
		this.friendTime = friendTime;
	}


	
	public FriendsInfo() {
		super();
	}


	
}
