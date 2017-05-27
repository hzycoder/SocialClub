package com.friend.domain;

import java.io.Serializable;

public class FriendsInfo implements Serializable{	//用于显示好友列表
	private String UPicture;
	private String username;
	private int friendTime;
	
	
	public String getUPicture() {
		return UPicture;
	}


	public void setUPicture(String uPicture) {
		UPicture = uPicture;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public FriendsInfo(String uPicture, String username, int friendTime) {
		super();
		UPicture = uPicture;
		this.username = username;
		this.friendTime = friendTime;
	}


	@Override
	public String toString() {
		return "FriendsList [UPicture=" + UPicture + ", username=" + username + ", friendTime=" + friendTime + "]";
	}
	
	
}
