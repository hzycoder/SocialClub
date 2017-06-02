package com.info.dao;

import java.util.List;

import com.domain.TUser;

public interface infoDao {

	public List searchUser(TUser user);
	public void updateUser(TUser user);
	public void updatePhoto(TUser user);
}
