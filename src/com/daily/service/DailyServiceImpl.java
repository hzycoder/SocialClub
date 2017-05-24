package com.daily.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import com.daily.dao.DailyDao;
import com.daily.domain.TDaily;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;

public class DailyServiceImpl implements DailyService {
	@Resource
	TDaily tdaily;
	@Resource
	DailyDao dailydao;
	
	
	public Integer addmessage(String mesg){
		ActionContext ac = ActionContext.getContext();
		TUser tuser = (TUser)ac.getSession().get("user");
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		tdaily.setDailyTime(timestamp);
		tdaily.setTUser(tuser);
		tdaily.setMesg(mesg);
		return dailydao.addmessage(tdaily);
	}
}
