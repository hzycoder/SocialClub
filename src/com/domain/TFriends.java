package com.domain;

import java.util.Date;


/**
 * TFriends entity. @author MyEclipse Persistence Tools
 */

public class TFriends  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private TUser TUser;
     private Integer friendId;
     private Date friendsAddTime;


    // Constructors

    /** default constructor */
    public TFriends() {
    }

	/** minimal constructor */
    public TFriends(Integer userId, TUser TUser) {
        this.userId = userId;
        this.TUser = TUser;
    }
    
    /** full constructor */
    public TFriends(Integer userId, TUser TUser, Integer friendId, Date friendsAddTime) {
        this.userId = userId;
        this.TUser = TUser;
        this.friendId = friendId;
        this.friendsAddTime = friendsAddTime;
    }

   
    // Property accessors

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public TUser getTUser() {
        return this.TUser;
    }
    
    public void setTUser(TUser TUser) {
        this.TUser = TUser;
    }

    public Integer getFriendId() {
        return this.friendId;
    }
    
    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Date getFriendsAddTime() {
        return this.friendsAddTime;
    }
    
    public void setFriendsAddTime(Date friendsAddTime) {
        this.friendsAddTime = friendsAddTime;
    }
   








}