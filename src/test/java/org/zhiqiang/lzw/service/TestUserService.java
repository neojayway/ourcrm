package org.zhiqiang.lzw.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhiqiang.lzw.entity.User;
import org.zhiqiang.lzw.entity.custom.UserCustom;

public class TestUserService {
	
	private ApplicationContext context;
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
	}
	
	/**
	 * 测试登录
	 */
	@Test
	public void testUserLogin() {
		IUserService userService = (IUserService) context.getBean("userService");
		UserCustom userCustom = userService.login("RedMushroom", "123");
		System.out.println(userCustom.getName()+"\t"+userCustom.getGroup().getGroupname());
	}
	
	/**
	 * 测试修改用户所在部门
	 * @throws Exception 
	 */
	@Test
	public void testUpdateGroupIdForUser() throws Exception {
		IUserService userService = (IUserService) context.getBean("userService");
		userService.updateGroupIdForUser(1, 1);
	}
	
	
	/**
	 * 测试 查询所有用户
	 * @throws Exception 
	 */
	@Test
	public void testSelectAllUser() throws Exception {
		IUserService userService = (IUserService) context.getBean("userService");
		List<User> user = userService.selectAllUser();
		for (User user2 : user) {
			System.out.println(user2.getCnname());
		}
	}
	
	/**
	 * 测试批量修改用户所在部门
	 * @throws Exception 
	 */
	@Test
	public void testupdateBatchGroupIdForUser() throws Exception {
		IUserService userService = (IUserService) context.getBean("userService");
		userService.updateBatchGroupIdForUser(2, new Integer[]{1,6});
	}
	
	
	@Test
	public void testzzz() throws Exception {
		List<Long> list = new ArrayList<Long>();
		list.add(0, 5L);
		list.add(1,7L);
		System.out.println(list);
	}

}
