package com.daily.service;

import java.util.List;

import com.domain.TUser;

public interface DailyService {
	public List showmessage(TUser tuser,int f,int m);
	public Integer addmessage(String mesg,String imgName);
	public void deletemessage(Integer dailyID);
	public int dailyRows(int id);
}
