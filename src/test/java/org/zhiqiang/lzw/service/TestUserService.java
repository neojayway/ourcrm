package org.zhiqiang.lzw.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {
	
	ApplicationContext context;
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
	}

	@Test
	public void testUserLogin() {
		IUserService userService = (IUserService) context.getBean("userService");
		userService.login("RedMushroom", "123");
	}

}
