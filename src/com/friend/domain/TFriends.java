package com.friend.domain;

import java.sql.Timestamp;

/**
 * TFriends entity. @author MyEclipse Persistence Tools
 */

public class TFriends implements java.io.Serializable {

	// Fields

	private TFriendsId id;
	private Timestamp friendsAddTime;

	// Constructors

	/** default constructor */
	public TFriends() {
	}

	/** minimal constructor */
	public TFriends(TFriendsId id) {
		this.id = id;
	}

	/** full constructor */
	public TFriends(TFriendsId id, Timestamp friendsAddTime) {
		this.id = id;
		this.friendsAddTime = friendsAddTime;
	}

	// Property accessors

	public TFriendsId getId() {
		return this.id;
	}

	public void setId(TFriendsId id) {
		this.id = id;
	}

	public Timestamp getFriendsAddTime() {
		return this.friendsAddTime;
	}

	public void setFriendsAddTime(Timestamp friendsAddTime) {
		this.friendsAddTime = friendsAddTime;
	}

}