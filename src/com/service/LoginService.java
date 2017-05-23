package com.service;

import java.util.List;

import com.domain.TUser;

public interface LoginService {
	public List searchUser(TUser user);
	public List searchFriend(String friendString);
}
