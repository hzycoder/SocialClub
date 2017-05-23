package com.friend.action;

import com.domain.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class BeFriendAction extends ActionSupport {
	TUser user;
	String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public String execute() throws Exception {
		System.out.println("BeFriendEXECUTE---");
		System.out.println("username==now==" + username);

		return SUCCESS;
	}

}
