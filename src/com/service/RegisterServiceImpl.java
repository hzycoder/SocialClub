package com.service;

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
		Integer id =  regDao.insertUser(user);
		if (id==1) {
			return true;
		}else return false;
	}

}
