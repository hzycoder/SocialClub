package com.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.components.Else;

import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
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
		ActionContext ac = ActionContext.getContext();

		TUser user = new TUser(username, password, birthday, background, uPicture, petname, college, email, phone,registerTime);
		//整合生日日期
		String birthdayString = year+month+day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(birthdayString);
		user.setBirthday(date);
		
		System.out.println("date日期:::"+user.getBirthday().toString());
		System.out.println("user==!!!!!!!==="+user.toString());
		System.out.println("注册EXECUTE");
		
		Integer id = regSrv.insertUser(user);
		if(id>0){
			ac.getSession().put("RegSUCCESS", "注册成功");
			return SUCCESS;
		}else if(id==-1){
			this.addFieldError(ERROR, "该用户名已注册");
			return INPUT;
		}else
			this.addFieldError(ERROR, "网站繁忙");
			return INPUT;
		
	}
	

}
