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

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		this.clearErrorsAndMessages();
		ac.getSession().remove("LOGFAILE");
		userList = logSrv.searchUser(user);
		System.out.println("---------DDDDD");
		if (userList != null && !userList.isEmpty()) {
			ac.getSession().put("userName", user.getUsername());
			return SUCCESS;
		} else {
			ac.getSession().put("LOGFAILE", "用户名或密码错误");
			return INPUT;
		} 
	}

}
