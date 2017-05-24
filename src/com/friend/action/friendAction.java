package com.friend.action;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.domain.TUser;
import com.friend.service.FriendService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class friendAction extends ActionSupport{//���������û���ҳ����friendsession
	TUser friend = new TUser();
	private String friendName;
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private FriendService friendSrv;
	
	public String getFriendName() {
		return friendName;
	}



	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}



	public String execute(){
		ActionContext ac = ActionContext.getContext();
		System.out.println("friendName:---"+friendName);
		friend = (TUser) friendSrv.searchFriend(friendName).get(0);
		ac.getSession().put("friend", friend);
		System.out.println("friID"+friend.getUserId());
		return SUCCESS;
	}

}