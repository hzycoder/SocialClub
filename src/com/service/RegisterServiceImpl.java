package com.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dao.RegisterDao;
import com.domain.TUser;
@Transactional
public class RegisterServiceImpl implements RegisterService {
	@Resource
	RegisterDao regDao;
	@Override
	public boolean insertUser(TUser user) {
		//生成注册日期
		Date date = new Date();   
		Timestamp timestamp = new Timestamp(date.getTime()); 
		user.setRegisterTime(timestamp);
		
		Integer id =  regDao.insertUser(user);
		if (id==1) {
			return true;
		}else return false;
	}

}
