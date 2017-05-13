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
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getBacakground() {
		return bacakground;
	}


	public void setBacakground(String bacakground) {
		this.bacakground = bacakground;
	}


	public String getuPicture() {
		return uPicture;
	}


	public void setuPicture(String uPicture) {
		this.uPicture = uPicture;
	}


	public String getPetname() {
		return petname;
	}


	public void setPetname(String petname) {
		this.petname = petname;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String execute() throws Exception {
		TUser user = new TUser(username, password, birthday, bacakground, uPicture, petname, college, email, phone);
		System.out.println("user==!!!!!!!==="+user.toString());
		System.out.println("×¢²áEXECUTE");
		if(regSrv.insertUser(user))
			return SUCCESS;
		else return INPUT;
	}
	

}
