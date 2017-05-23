package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LoginService;
import com.service.LoginServiceImpl;

public class LoginAction extends ActionSupport {
	TUser user;
	@Resource
	List<TUser> userList;
	@Resource
	LoginService logSrv;
	String friendString;//用于查询用户的名称或ID
	
	
	public String getFriendString() {
		return friendString;
	}

	public void setFriendString(String friendString) {
		this.friendString = friendString;
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		this.clearErrorsAndMessages();
		ActionContext ac = ActionContext.getContext();
		ac.getSession().remove("LOGFAILE");
		userList = logSrv.searchUser(user);
		System.out.println("---------LOGINEXECUTE");
		if (userList != null && !userList.isEmpty()) {
			user = userList.get(0);
			System.out.println("userrrr" + user);
			ac.getSession().put("user", user);
			return SUCCESS;
		} else {
			ac.getSession().put("LOGFAILE", "用户名或密码错误");
			return INPUT;
		}
	}

	public String findFriend() throws Exception {
		System.out.println("--------LOGINFINDFRIEND");
		ActionContext ac = ActionContext.getContext();
		userList = logSrv.searchFriend(friendString);
		if (userList != null && !userList.isEmpty()) {
			user = userList.get(0);
			System.out.println("findFFFFFFFFFF" + user);
			ac.getSession().put("user", user);
			return NONE;
		} else {
			ac.getSession().put("LOGFAILE", "用户名或密码错误");
			return NONE;
		}
	}

}
