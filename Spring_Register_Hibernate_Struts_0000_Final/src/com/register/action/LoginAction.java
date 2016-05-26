package com.register.action;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.register.model.User;
import com.register.service.UserManager;
import com.register.service.impl.UserManagerImpl;

public class LoginAction  extends ActionSupport{
	private String username;
	private String password;
	private String password2;
	
	private UserManager userManager;
	
	public LoginAction(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		userManager = (UserManager)ac.getBean("userManager");
	}
	public UserManager getUserManager() {
		return userManager;
	}
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	//判断user在数据库中是否存在来返回不同的字符串
	@Override
	public String execute() throws Exception {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean exists=userManager.exists(user);
		if(exists){
			System.out.println("registerFail");
			return "fail";
		}

		userManager.save(user);
		System.out.println("registerSuccess");
		return "success";
	}	
}
