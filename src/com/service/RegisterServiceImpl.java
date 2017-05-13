package com.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.components.Else;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RegisterDao;
import com.domain.TUser;

@Transactional
public class RegisterServiceImpl implements RegisterService {
	@Resource
	RegisterDao regDao;

	@Override
	public Integer insertUser(TUser user) {
		// 生成注册日期
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		user.setRegisterTime(timestamp);

		return regDao.insertUser(user);

	}
}
