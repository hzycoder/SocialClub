package com.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.apache.struts2.components.Else;

import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.RegisterService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class RegisterAction extends ActionSupport {
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

	public void validateAdd() {
		this.clearErrorsAndMessages();
		Pattern numPatt = Pattern.compile("[0-9]*");
		Pattern emailPatt = Pattern.compile("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
		if (year.equals("")||month.equals("")||day.equals("")) {
			this.addFieldError("birthday", "����ȷ��������");
		}
		if (!email.equals("")&&!emailPatt.matcher(email).matches()) {
			this.addFieldError("emailError", "����ȷ��д�����ʽ");
		}
		byte[] bytes = username.getBytes();
		if(bytes.length>20){
			this.addFieldError("usernameError", "�û������ȹ���");
		}
		byte[] bytes1 = password.getBytes();
		if(bytes1.length>20||bytes1.length<6){
			this.addFieldError("passwordError", "���볤�Ȳ�����");
		}
		if (!phone.equals("")&&phone.length() != 11) {
			this.addFieldError("phoneError", "����д��ȷ����ϵ�绰");
		}
		if (!phone.equals("")&&!numPatt.matcher(phone).matches()) {
			this.addFieldError("phoneError", "����д��ȷ����ϵ�绰");
		}

	}

	public String add() throws Exception {
		this.clearErrorsAndMessages();
		ActionContext ac = ActionContext.getContext();

		TUser user = new TUser(username, password, birthday, background, uPicture, petname, college, email, phone,
				registerTime);
		// ������������
		String birthdayString = year + month + day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(birthdayString);
		user.setBirthday(date);

		System.out.println("date����:::" + user.getBirthday().toString());
		System.out.println("user==!!!!!!!===" + user.toString());
		System.out.println("ע��EXECUTE");

		Integer id = regSrv.insertUser(user);
		if (id > 0) {
			ac.getSession().put("RegSUCCESS", "ע��ɹ�11");
			return SUCCESS;
		} else if (id == -1) {
			this.addFieldError(ERROR, "���û�����ע��");
			return INPUT;
		} else {
			this.addFieldError(ERROR, "ϵͳ��æ");
			return INPUT;
		}

	}

	@Override
	public String execute() throws Exception {
		return INPUT;
	}

}
