package com.friend.domain;

import java.util.Date;

import com.domain.TUser;

/**
 * TFriends entity. @author MyEclipse Persistence Tools
 */

public class TFriends implements java.io.Serializable {

	// Fields

	private Integer userId;
	private TUser TUserByFriendId;
	private TUser TUserByUserId;
	private Date friendsAddTime;

	// Constructors

	/** default constructor */
	public TFriends() {
	}

	/** minimal constructor */
	public TFriends(TUser TUserByUserId) {
		this.TUserByUserId = TUserByUserId;
	}

	/** full constructor */
	public TFriends(TUser TUserByFriendId, TUser TUserByUserId, Date friendsAddTime) {
		this.TUserByFriendId = TUserByFriendId;
		this.TUserByUserId = TUserByUserId;
		this.friendsAddTime = friendsAddTime;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public TUser getTUserByFriendId() {
		return this.TUserByFriendId;
	}

	public void setTUserByFriendId(TUser TUserByFriendId) {
		this.TUserByFriendId = TUserByFriendId;
	}

	public TUser getTUserByUserId() {
		return this.TUserByUserId;
	}

	public void setTUserByUserId(TUser TUserByUserId) {
		this.TUserByUserId = TUserByUserId;
	}

	public Date getFriendsAddTime() {
		return this.friendsAddTime;
	}

	public void setFriendsAddTime(Date friendsAddTime) {
		this.friendsAddTime = friendsAddTime;
	}

}