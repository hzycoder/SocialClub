package com.action;

import java.util.ArrayList;
import java.util.List;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	User user;
	List<User> userList = new ArrayList<User>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("userName", user.getUserName());
		if(user.getUserName().equals("admin")&&user.getPassword().equals("123")){
			return SUCCESS;
		}
		// TODO Auto-generated method stub
		return INPUT;
	}
	
	

}
