package com.friend.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClearFriendAction extends ActionSupport{//���ظ�����ҳ ���friendsession
	int type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String execute(){
		if(type==1){//type����1�򿪲����б�
			ActionContext ac = ActionContext.getContext();
			ac.getSession().remove("friend");
			return "blog";
		}else if(type==2){	//������ҳ
			ActionContext ac = ActionContext.getContext();
			ac.getSession().remove("friend");
			return SUCCESS;
		}else if(type==3){
			ActionContext ac = ActionContext.getContext();
			ac.getSession().remove("LEAVEMESSAGESUCCESS");
			ac.getSession().remove("friend");
			return "board";
		}
		return SUCCESS;
	}

}
