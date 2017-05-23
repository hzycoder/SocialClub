package com.dao;

import java.util.List;

import com.domain.TUser;

public interface LoginDao {
	public List searchUser(TUser user);
	public List searchFriend(String friendString);
	

}
