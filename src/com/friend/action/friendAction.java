package com.friend.action;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.domain.TUser;
import com.friend.service.FriendService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.RefreshUC;

public class friendAction extends ActionSupport {// 访问其他用户主页添加friendsession
	TUser friend = new TUser();
	private String friendName;
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private FriendService friendSrv;
	@Resource
	RefreshUC ruc;

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String execute() {
		ActionContext ac = ActionContext.getContext();
		if(ac.getSession().get("friend")==null){
			friend = (TUser) friendSrv.searchFriend(friendName).get(0);
			ac.getSession().put("friend", friend);
		}
		ruc.refreshUC();
		return SUCCESS;
	}

}
