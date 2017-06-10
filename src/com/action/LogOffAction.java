package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogOffAction extends ActionSupport{
	
	@Override
	public String execute(){
		ActionContext ac = ActionContext.getContext();
		ac.getSession().remove("user");
		ac.getSession().remove("uc");
		return LOGIN;		
	}

}
