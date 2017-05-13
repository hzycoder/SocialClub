package com.action;

import javax.annotation.Resource;

import com.domain.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RegisterService;

public class RegisterAction extends ActionSupport{
	@Resource
	RegisterService regSrv;
	
	TUser user;
	
	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("user====="+user.toString());
		System.out.println("×¢²áEXECUTE");
		if(regSrv.insertUser(user))
			return SUCCESS;
		else return INPUT;
	}
	

}
