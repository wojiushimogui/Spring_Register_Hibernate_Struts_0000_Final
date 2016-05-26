package com.register.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.register.model.User;
import com.register.service.impl.UserManagerImpl;

public class UserManagerTest {

	@Test
	public void testExists() {
		ApplicationContext context= new ClassPathXmlApplicationContext("/beans.xml");  
		UserManager um =(UserManager) context.getBean("userManager");  		
//		UserManager um=new UserManagerImpl();
		User user=new User();
		user.setUsername("haowu");
		boolean exists=um.exists(user);
		assertEquals(false, exists);
	}

	@Test
	public void testSave() {
		ApplicationContext context= new ClassPathXmlApplicationContext("/beans.xml");  
		UserManager um =(UserManager) context.getBean("userManager");  
//		UserManager um=new UserManagerImpl();
		User user=new User();
		user.setUsername("haowuwu3");
		user.setPassword("123");
		boolean exists=um.exists(user);
		if(!exists){
			um.save(user);
			//如果我们不想从数据库中查看是否保存成功，则可以利用以下的代码来完成
			exists=um.exists(user);
			assertEquals(true, exists);
		}
		else{
			fail("save fail!!!");
		}
	}

}
