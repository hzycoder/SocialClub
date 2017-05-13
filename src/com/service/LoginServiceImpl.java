package com.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import com.dao.LoginDao;
import com.domain.TUser;
@Transactional
public class LoginServiceImpl implements LoginService {
	@Resource
	LoginDao loginDao;

	@Override
	public List searchUser(TUser user) {
		return loginDao.searchUser(user);
	}

}
