package com.friend.action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.domain.TUser;
import com.friend.domain.FriendsInfo;
import com.friend.service.FriendService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BeFriendAction extends ActionSupport {
	private TUser user; // 自己
	private TUser friendUser;// 朋友
	private String friendString; // 用于查找用户的username
	private List<FriendsInfo> friInfoList;// 存放朋友列表
	@Resource
	private List<TUser> userList;// 存放通过搜索找到的用户
	@Resource
	private FriendService friendSrv;
	@Resource
	private SessionFactory sessionFactory;

	public TUser getFriendUser() {
		return friendUser;
	}

	public void setFriendUser(TUser friendUser) {
		this.friendUser = friendUser;
	}

	public String getFriendString() {
		return friendString;
	}

	public void setFriendString(String friendString) {
		this.friendString = friendString;
	}

	public String execute() throws Exception {// 默认方法用于显示好友列表
		System.out.println("EXECVUTTTTTTT");
		ActionContext ac = ActionContext.getContext();
		friInfoList = friendSrv.searchFriendList();
		for (int i = 0; i < friInfoList.size(); i++) {
			System.out.println("friendsList::::::::::::::" + friInfoList.get(i).getUsername());
		}
		ac.getSession().put("friInfoList", friInfoList);

		return SUCCESS;
	}
	public String friendCount(){ //查询好友数量
		
		
		return SUCCESS;
	}
	public String beFriend() throws Exception { // 添加好友
		System.out.println("BeFriendEXECUTE---");
		System.out.println("username==now==" + friendUser.getUsername());
		friendSrv.beFriend(friendUser.getUsername());
		return SUCCESS;

	}

	public String deleteFriend() throws Exception{		//删除好友
		friendSrv.deleteFriend(friendString);
		return SUCCESS;
	}

	public String findFriend() throws Exception { // 查找好友
		ActionContext ac = ActionContext.getContext();
		userList = friendSrv.searchFriend(friendString);
		if (userList != null && !userList.isEmpty()) {
			friendUser = userList.get(0);
			ac.getSession().put("friendUser", friendUser);
			return NONE;
		} else {
			return NONE;
		}
	}

}
