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
	private TUser user; // �Լ�
	private TUser friendUser;// ����
	private String friendName;
	private String friendString;
	private List<FriendsInfo> friInfoList;//��������б�
	@Resource
	private List<TUser> userList;//���ͨ�������ҵ����û�
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

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String execute() throws Exception {//Ĭ�Ϸ���������ʾ�����б�
		System.out.println("EXECVUTTTTTTT");
		ActionContext ac = ActionContext.getContext();
		friInfoList = friendSrv.searchFriendList();
		for (int i = 0; i < friInfoList.size(); i++) {
			System.out.println("friendsList::::::::::::::" + friInfoList.get(i).getUsername());
		}
		ac.getSession().put("friInfoList", friInfoList);

		return SUCCESS;
	}

	public String beFriend() throws Exception { // ���Ӻ���
		System.out.println("BeFriendEXECUTE---");
		System.out.println("username==now==" + friendUser.getUsername());
		friendSrv.beFriend(friendName);
		// ActionContext ac = ActionContext.getContext();
		// user = (TUser) ac.getSession().get("user");
		// System.out.println("ME::::::::"+user.getUsername());
		return SUCCESS;

	}

	public String findFriend() throws Exception { // ���Һ���
		ActionContext ac = ActionContext.getContext();
		userList = friendSrv.searchFriend(friendString);
		if (userList != null && !userList.isEmpty()) {
			friendUser = userList.get(0);
			ac.getSession().put("friendUser", friendUser);
			return NONE;
		} else {
			ac.getSession().put("LOGFAILE", "�û������������");
			return NONE;
		}
	}

}