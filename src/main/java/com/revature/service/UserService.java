package com.revature.service;

import com.revature.beans.UserTable;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;

public class UserService {

	public UserTable validateUser(UserTable user) {
		
		UserDao dao = new UserDaoImpl();
		
		UserTable sUser = dao.getUserByUsername(user);
		
		if(sUser != null) {
			//Compare username and passwords
			if((sUser.getU_username().equals(user.getU_username())) && (sUser.getU_password().equals(user.getU_password()))){
				
				return sUser;
				
			}
		}
		
		return null;
	}
	
	
	public void newUser(UserTable user) {
		
		new UserDaoImpl().saveUser(user);
		
	}
	
	
}
