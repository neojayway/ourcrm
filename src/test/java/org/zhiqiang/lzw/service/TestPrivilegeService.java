package org.zhiqiang.lzw.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhiqiang.lzw.entity.Privilege;
import org.zhiqiang.lzw.entity.PrivilegeCodeAndPos;
import org.zhiqiang.lzw.entity.custom.PageBean;
import org.zhiqiang.lzw.web.PrivilegeController;

public class TestPrivilegeService {
	
	private ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}
	
	/**
	 * 测试权限分页查询
	 */
	@Test
	public void test() {
		PageBean pageBean = new PageBean();
		IPrivilegeService privilegeService = (IPrivilegeService) context.getBean("privilegeService");
		List<Privilege> prililege = privilegeService.selectByPage("新增", pageBean);
		System.out.println(pageBean.getTotalRecords());
		for (Privilege privilege : prililege) {
			System.out.println(privilege);
		}
	}
	
	
	/**
	 * 测试权限分页查询
	 */
	@Test
	public void testSelectMaximumPos() {
		IPrivilegeService privilegeService = (IPrivilegeService) context.getBean("privilegeService");
		PrivilegeCodeAndPos selectMaximumPos = privilegeService.selectMaximumPos();
		System.out.println(selectMaximumPos.getPos());
		System.out.println(selectMaximumPos.getCode());
	}
	
	/**
	 * 测试批量删除权限
	 * @throws Exception 
	 */
	@Test
	public void testDeletePrivilegeByBatch() throws Exception {
		IPrivilegeService privilegeService = (IPrivilegeService) context.getBean("privilegeService");
		privilegeService.deletePrivilegeByBatch(new Integer[]{410,411});
	}
	
	/**
	 * 测试新增权限
	 */
	@Test
	public void testAddPrivilege() {
		IPrivilegeService privilegeService = (IPrivilegeService) context.getBean("privilegeService");
		
		for (int i = 0; i < 100; i++) {
			Privilege privilege = new Privilege();
			privilege.setPrivilegename("按实际"+i);
			privilege.setPrivilegeurl("asdjnkkjaksd"+i);
			privilege.setPrivalegecomm(false);
			
			//查询获得最大的权限位以及最大的权限位对应的权限码
			PrivilegeCodeAndPos privilegeCodeAndPos = privilegeService.selectMaximumPos();
			if (privilegeCodeAndPos!=null) {
				Integer pos = privilegeCodeAndPos.getPos();
				Long code = privilegeCodeAndPos.getCode();
				//Long类型在计算机中占用64个二进制位，除去一个符号位，那么1L最多向左移动62位
				if (code==1L<<62) {
					privilege.setPrivilegepos(++pos);
					privilege.setPrivilegecode(1L);
				}else {
					privilege.setPrivilegepos(pos);
					privilege.setPrivilegecode(code<<1);
				}
				//保存权限
				privilegeService.addPrivilege(privilege);
			}
		}
	}

}
