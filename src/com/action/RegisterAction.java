package com.action;

import java.util.Date;

import javax.annotation.Resource;

import com.domain.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RegisterService;

public class RegisterAction extends ActionSupport{
	@Resource
	RegisterService regSrv;
	String username;
	String password;
	Date birthday = null;
	String bacakground = null;
	String uPicture = null;
	String petname = null;
	String college = null;
	String email = null;
	String phone = null;
	TUser user = new TUser(username, password, birthday, bacakground, uPicture, petname, college, email, phone);
	
	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("user==!!!!!!!==="+user.toString());
		
		System.out.println("×¢²áEXECUTE");
		if(regSrv.insertUser(user))
			return SUCCESS;
		else return INPUT;
	}
	

}
