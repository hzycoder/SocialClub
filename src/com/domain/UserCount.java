package com.domain;

public class UserCount implements java.io.Serializable {
	private int friendCount;
	private int blogCount;
	private int actCount;
	private int messageCount;

	public int getFriendCount() {
		return friendCount;
	}

	public void setFriendCount(int friendCount) {
		this.friendCount = friendCount;
	}

	public int getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(int blogCount) {
		this.blogCount = blogCount;
	}

	public int getActCount() {
		return actCount;
	}

	public void setActCount(int actCount) {
		this.actCount = actCount;
	}

	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	public UserCount() {
		// TODO Auto-generated constructor stub
	}

	public UserCount(int friendCount, int blogCount, int actCount, int messageCount) {
		super();
		this.friendCount = friendCount;
		this.blogCount = blogCount;
		this.actCount = actCount;
		this.messageCount = messageCount;
	}

}
