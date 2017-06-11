package com.daily.action;

import java.util.Map;

import javax.annotation.Resource;

import com.daily.domain.TDaily;
import com.daily.service.DailyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteDailyAction extends ActionSupport {
	@Resource
	private DailyService dailySrc;
	Integer dailyId;
	
	
	public String execute(){
		System.out.println("dailyID:"+dailyId);
		dailySrc.deletemessage(dailyId);
		return "success";
	}


	public Integer getDailyId() {
		return dailyId;
	}


	public void setDailyId(Integer dailyId) {
		this.dailyId = dailyId;
	}


	
	
}
