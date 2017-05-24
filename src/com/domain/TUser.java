package com.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String username;
	private String password;
	private Date birthday;
	private String background;
	private String UPicture;
	private String petname;
	private String college;
	private String email;
	private String phone;
	private Timestamp registerTime;
	private Set actLists = new HashSet(0);
	private Set actComments = new HashSet(0);
	private Set blogComments = new HashSet(0);
	private Set TFriendses = new HashSet(0);
	private Set blogLists = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	// ** 注册用的构造方法 */
	public TUser(String username, String password, Date birthday, String background, String uPicture, String petname,
			String college, String email, String phone, Timestamp registerTime) {
		super();
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.background = background;
		this.UPicture = uPicture;
		this.petname = petname;
		this.college = college;
		this.email = email;
		this.phone = phone;
		this.registerTime = registerTime;
	}

	/** minimal constructor */
	public TUser(Integer userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public TUser(Integer userId, String username, String password, Date birthday, String background, String UPicture,
			String petname, String college, String email, String phone, Timestamp registerTime, Set actLists,
			Set actComments, Set blogComments, Set TFriendses, Set blogLists) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.background = background;
		this.UPicture = UPicture;
		this.petname = petname;
		this.college = college;
		this.email = email;
		this.phone = phone;
		this.registerTime = registerTime;
		this.actLists = actLists;
		this.actComments = actComments;
		this.blogComments = blogComments;
		this.TFriendses = TFriendses;
		this.blogLists = blogLists;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getUPicture() {
		return this.UPicture;
	}

	public void setUPicture(String UPicture) {
		this.UPicture = UPicture;
	}

	public String getPetname() {
		return this.petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Set getActLists() {
		return this.actLists;
	}

	public void setActLists(Set actLists) {
		this.actLists = actLists;
	}

	public Set getActComments() {
		return this.actComments;
	}

	public void setActComments(Set actComments) {
		this.actComments = actComments;
	}

	public Set getBlogComments() {
		return this.blogComments;
	}

	public void setBlogComments(Set blogComments) {
		this.blogComments = blogComments;
	}

	public Set getTFriendses() {
		return this.TFriendses;
	}

	public void setTFriendses(Set TFriendses) {
		this.TFriendses = TFriendses;
	}

	public Set getBlogLists() {
		return this.blogLists;
	}

	public void setBlogLists(Set blogLists) {
		this.blogLists = blogLists;
	}

	@Override
	public String toString() {
		return "TUser [userId=" + userId + ", username=" + username + ", password=" + password + ", birthday="
				+ birthday + ", background=" + background + ", UPicture=" + UPicture + ", petname=" + petname
				+ ", college=" + college + ", email=" + email + ", phone=" + phone + ", actLists=" + actLists
				+ ", actComments=" + actComments + ", blogComments=" + blogComments + ", TFriendses=" + TFriendses
				+ ", blogLists=" + blogLists + "]";
	}

}