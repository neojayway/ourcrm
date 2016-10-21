package org.zhiqiang.lzw.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhiqiang.lzw.entity.custom.UserCustom;

public class TestUserService {
	
	ApplicationContext context;
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
	}

	@Test
	public void testUserLogin() {
		IUserService userService = (IUserService) context.getBean("userService");
		UserCustom userCustom = userService.login("RedMushroom", "123");
		System.out.println(userCustom.getName()+"\t"+userCustom.getGroup().getGroupname());
	}

}
