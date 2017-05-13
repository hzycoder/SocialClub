package com.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.domain.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RegisterService;

public class RegisterAction extends ActionSupport{
	@Resource
	RegisterService regSrv;
	
	private String username;
	private String password;
	private Date birthday = null;
	private String background = null;
	private String uPicture = null;
	private String petname = null;
	private String college = null;
	private String email = null;
	private String phone = null;
	private Timestamp registerTime = null;
	private String year;
	private String month;
	private String day;

	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


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
		TUser user = new TUser(username, password, birthday, background, uPicture, petname, college, email, phone,registerTime);
		
		String birthdayString = year+month+day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(birthdayString);
		user.setBirthday(date);
		
		System.out.println("dateÈÕÆÚ:::"+user.getBirthday().toString());
		System.out.println("user==!!!!!!!==="+user.toString());
		System.out.println("×¢²áEXECUTE");
		if(regSrv.insertUser(user))
			return SUCCESS;
		else return INPUT;
	}
	

}
