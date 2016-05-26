package com.register.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.register.dao.UserDao;
import com.register.model.User;
import com.register.service.UserManager;

@Component("userManager")
public class UserManagerImpl implements UserManager{
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean exists(User user) {
		
		return userDao.exists(user);
	}
	
	public void save(User user) {
		
		 userDao.save(user);
	}
}
