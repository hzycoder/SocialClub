package com.action;

import java.util.List;
import java.util.regex.Pattern;

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
	String friendString;// ���ڲ�ѯ�û������ƻ�ID

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
		ruc.refreshUC();// ˢ���û����ġ����ѵ�����
		return SUCCESS;
	}

	public String judgeLogin(){
		this.clearErrorsAndMessages();
		ActionContext ac = ActionContext.getContext();
		if(ac.getSession().get("user")!=null){
			return SUCCESS;
		}else {
			return INPUT;
		}
	}
	
	public String login() {
		this.clearErrorsAndMessages();
		ActionContext ac = ActionContext.getContext();
		ac.getSession().remove("LOGFAILE");
		userList = logSrv.searchUser(user);
		if (userList != null && !userList.isEmpty()) {
			user = userList.get(0);
			ac.getSession().put("user", user);
			ruc.refreshUC();// ˢ���û����ġ����ѵ�����
			return SUCCESS;
		} else {
			ac.getSession().put("LOGFAILE", "�û������������");
			return INPUT;
		}

	}

}
