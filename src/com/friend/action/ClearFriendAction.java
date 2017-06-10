package com.friend.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.RefreshUC;

public class ClearFriendAction extends ActionSupport {// 返回个人主页 清空friendsession
	@Resource
	RefreshUC ruc;
	int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String execute() {
		ActionContext ac = ActionContext.getContext();
		ac.getSession().remove("friend");
		if (type == 1) {// type等于1打开博文列表
			return "blog";
		} else if (type == 2) { // 返回主页
			ruc.refreshUC();
			return SUCCESS;
		} else if (type == 3) {
			return "board";
		}
		return SUCCESS;
	}

}
