package com.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private String username;
     private String password;
     private Date birthday;
     private String bacakground;
     private String UPicture;
     private String petname;
     private String college;
     private String email;
     private String phone;
     private Set actLists = new HashSet(0);
     private Set actComments = new HashSet(0);
     private Set blogComments = new HashSet(0);
     private Set TFriendses = new HashSet(0);
     private Set blogLists = new HashSet(0);


    // Constructors

    /** default constructor */
    public TUser() {
    }

	/** minimal constructor */
    public TUser(Integer userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    
    /** full constructor */
    public TUser(Integer userId, String username, String password, Date birthday, String bacakground, String UPicture, String petname, String college, String email, String phone, Set actLists, Set actComments, Set blogComments, Set TFriendses, Set blogLists) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.bacakground = bacakground;
        this.UPicture = UPicture;
        this.petname = petname;
        this.college = college;
        this.email = email;
        this.phone = phone;
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

    public String getBacakground() {
        return this.bacakground;
    }
    
    public void setBacakground(String bacakground) {
        this.bacakground = bacakground;
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
   








}