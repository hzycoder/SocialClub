package com.daily.dao;

import java.util.List;

import com.daily.domain.TDaily;
import com.domain.TUser;

public interface DailyDao {
	public Integer addmessage(TDaily tdaily);
	public List showmessage(TUser tuser,int f,int m);
	public void deletemessage(Integer dailyID);
	public int dailyRows(int id);
}
