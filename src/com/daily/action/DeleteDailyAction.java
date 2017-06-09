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
	Integer dailyID;
	
	
	public String execute(){
		System.out.println("dailyID:"+dailyID);
		dailySrc.deletemessage(dailyID);
		return "success";
	}


	public Integer getDailyID() {
		return dailyID;
	}


	public void setDailyID(Integer dailyID) {
		this.dailyID = dailyID;
	}


	
	
}
