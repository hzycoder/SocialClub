package com.daily.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.daily.dao.DailyDao;
import com.daily.domain.TDaily;
import com.domain.TUser;
import com.opensymphony.xwork2.ActionContext;
@Transactional
public class DailyServiceImpl implements DailyService {

	@Resource
	TDaily tdaily;
	@Resource
	DailyDao dailyDao;
	
	@Override
	public List showmessage(int f,int m) {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		TUser tuser = (TUser)ac.getSession().get("user");
		return dailyDao.showmessage(tuser,f,m);
	}

	@Override
	public Integer addmessage(String mesg, String imgName) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		ActionContext ac = ActionContext.getContext();
		TUser user1 = (TUser)ac.getSession().get("user");
		tdaily.setTUser(user1);
		this.tdaily.setDailyTime(timestamp);
		this.tdaily.setMesg(mesg);
		this.tdaily.setImgName(imgName);
		return dailyDao.addmessage(tdaily);
	}
	
	public void deletemessage(Integer dailyID){
		dailyDao.deletemessage(dailyID);
	}

	
	public int dailyRows(int id){
		return dailyDao.dailyRows(id);
	}
}
