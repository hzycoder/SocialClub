package com.action;

import java.util.List;

import javax.annotation.Resource;

import com.blog.service.BlogService;
import com.board.service.BoardService;
import com.domain.TUser;
import com.domain.UserCount;
import com.friend.service.FriendService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LoginService;
import com.util.RefreshUC;

public class LoginAction extends ActionSupport {
	TUser user;
	@Resource
	List<TUser> userList;
	@Resource
	UserCount uc;
	@Resource
	LoginService logSrv;
	@Resource
	RefreshUC ruc;
	String friendString;// 用于查询用户的名称或ID

	public String getFriendString() {
		return friendString;
	}

	public void setFriendString(String friendString) {
		this.friendString = friendString;
	}
	

	public UserCount getUc() {
		return uc;
	}

	public void setUc(UserCount uc) {
		this.uc = uc;
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		this.clearErrorsAndMessages();
		ActionContext ac = ActionContext.getContext();
		ac.getSession().remove("LOGFAILE");
		userList = logSrv.searchUser(user);
		if (userList != null && !userList.isEmpty()) {
			user = userList.get(0);
			ac.getSession().put("user", user);
			uc = ruc.refreshUC();//刷新用户博文、好友等数量
			return SUCCESS;
		} else {
			ac.getSession().put("LOGFAILE", "用户名或密码错误");
			return INPUT;
		}
	}

}
