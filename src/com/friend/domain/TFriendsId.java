package com.friend.domain;

/**
 * TFriendsId entity. @author MyEclipse Persistence Tools
 */

public class TFriendsId implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer friendId;

	// Constructors

	/** default constructor */
	public TFriendsId() {
	}

	/** full constructor */
	public TFriendsId(Integer userId, Integer friendId) {
		this.userId = userId;
		this.friendId = friendId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFriendId() {
		return this.friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TFriendsId))
			return false;
		TFriendsId castOther = (TFriendsId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& ((this.getFriendId() == castOther.getFriendId()) || (this.getFriendId() != null
						&& castOther.getFriendId() != null && this.getFriendId().equals(castOther.getFriendId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + (getFriendId() == null ? 0 : this.getFriendId().hashCode());
		return result;
	}

}