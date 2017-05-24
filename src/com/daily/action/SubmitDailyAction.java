package com.daily.action;

import java.sql.Timestamp;

import javax.annotation.Resource;

import com.daily.service.DailyService;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SubmitDailyAction extends ActionSupport {

	private String mesg;
	@Resource
	private DailyService dailySrc;

	public String execute() {

		Integer id = dailySrc.addmessage(mesg);
		ActionContext ac = ActionContext.getContext();
		if (id > 0) {
			ac.getSession().put("SUBSUCCESS", "提交博文成功");
			return SUCCESS;
		} else {
			this.addFieldError(ERROR, "系统繁忙");
			return INPUT;
		}
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
}
