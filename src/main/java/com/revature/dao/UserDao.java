package com.revature.dao;

import com.revature.beans.UserTable;

public interface UserDao {

	
	public UserTable getUserByUsername(UserTable user);
	
	public void saveUser(UserTable user);
	
}
